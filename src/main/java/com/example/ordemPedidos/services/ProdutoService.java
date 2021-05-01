package com.example.ordemPedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.ordemPedidos.entities.Categoria;
import com.example.ordemPedidos.entities.Produto;
import com.example.ordemPedidos.repositories.CategoriaRepository;
import com.example.ordemPedidos.repositories.ProdutoRepository;
import com.example.ordemPedidos.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Produto findById(Integer id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado"));
	}
	
	public Page<Produto> search(
			String nome, 
			List<Integer> ids,
			Integer page, 
			Integer linesPerPage, 
			String direction,
			String orderBy){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repository.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}

}
