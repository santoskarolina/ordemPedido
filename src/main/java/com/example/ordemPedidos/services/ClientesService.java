package com.example.ordemPedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ordemPedidos.entities.Cidade;
import com.example.ordemPedidos.entities.Cliente;
import com.example.ordemPedidos.entities.Endereco;
import com.example.ordemPedidos.entities.DTO.ClienteDTO;
import com.example.ordemPedidos.entities.DTO.ClienteNewDTO;
import com.example.ordemPedidos.entities.enums.TipoCliente;
import com.example.ordemPedidos.repositories.ClienteRepository;
import com.example.ordemPedidos.repositories.EnderecoRepository;
import com.example.ordemPedidos.services.exceptions.DataIntegrityException;
import com.example.ordemPedidos.services.exceptions.ObjectNotFoundException;

@Service
public class ClientesService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repository.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}
	
	public Cliente update(Integer id, Cliente obj) {
		Cliente newObj = repository.getOne(id);
		updateDate(newObj,obj);
		return repository.save(newObj);		
	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Cliente possui produtos associados");
		}
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String direction,String orderBy){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	private void updateDate(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
	
	//cria um acategoria a partir de uma categoriaDTO
	public Cliente fromDTO(ClienteDTO objDTO){
		return new Cliente(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), null, null);
	}
	
	public Cliente fromDTO(ClienteNewDTO objDTO){
		Cliente cli = new Cliente(null, objDTO.getNome(), objDTO.getEmail(), TipoCliente.toEnum(objDTO.getTipo()), objDTO.getCpfOuCnpj());
		Cidade cid = new Cidade(objDTO.getCidadeId(),null, null);
		Endereco end = new Endereco(null, objDTO.getLogradouro(), objDTO.getNumero(), objDTO.getComplemento(),objDTO.getBairro(), objDTO.getCep(), cli, cid);
		
		cli.getEnderecos().add(end);
		cli.getTelefones().add(objDTO.getTelefone1());
		
		if(objDTO.getTelefone2() != null) {
			cli.getTelefones().add(objDTO.getTelefone2());
		}
		if(objDTO.getTelefone3() != null) {
			cli.getTelefones().add(objDTO.getTelefone3());
		}
		return cli;
	}
}
