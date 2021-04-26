package com.example.ordemPedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.ordemPedidos.entities.Categoria;
import com.example.ordemPedidos.entities.DTO.CategoriaDTO;
import com.example.ordemPedidos.repositories.CategoriaRepository;
import com.example.ordemPedidos.services.exceptions.DataIntegrityException;
import com.example.ordemPedidos.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Categoria update(Long id, Categoria obj) {
		Categoria newObj = repository.getOne(id);
		updateDate(newObj,obj);
		return repository.save(newObj);		
		
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Categoria possui produtos associados");
		}
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String direction,String orderBy){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	private void updateDate(Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	}
	
	//cria um acategoria a partir de uma categoriaDTO
	public Categoria fromDTO(CategoriaDTO objDTO){
		return new Categoria(objDTO.getId(), objDTO.getNome());
	}
}
