package com.example.ordemPedidos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ordemPedidos.entities.Estado;
import com.example.ordemPedidos.repositories.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repository;
	
	public List<Estado> findAll(){
		return repository.findAllByOrderByNome();
	}
}
