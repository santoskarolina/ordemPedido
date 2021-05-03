package com.example.ordemPedidos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ordemPedidos.entities.Cidade;
import com.example.ordemPedidos.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repository;
	
	public List<Cidade> findbyEstado(Integer estadoId){
		return repository.findCidades(estadoId);
	}

}
