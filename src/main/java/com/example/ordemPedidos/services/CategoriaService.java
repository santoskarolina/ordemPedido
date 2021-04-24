package com.example.ordemPedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.ordemPedidos.entities.Categoria;
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
		Categoria entity = repository.getOne(id);
		updateDate(entity,obj);
		return repository.save(entity);		
		
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Categoria possui produtos associados");
		}
		
	}
	private void updateDate(Categoria entity, Categoria obj) {
		entity.setNome(obj.getNome());
	}
}
