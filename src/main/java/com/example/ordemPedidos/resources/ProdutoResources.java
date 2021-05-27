package com.example.ordemPedidos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ordemPedidos.entities.Produto;
import com.example.ordemPedidos.entities.DTO.ProdutoDTO;
import com.example.ordemPedidos.resources.utils.URL;
import com.example.ordemPedidos.services.ProdutoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResources {

	@Autowired
	private ProdutoService service;
	
	@ApiOperation(value="Buscar produto por id")
	@GetMapping(value="/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Integer id){
		Produto obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value="Retornar todos os produtos com paginação")
	@GetMapping
	public ResponseEntity<Page<ProdutoDTO>> findPage(
			@RequestParam(name="nome", defaultValue="") String nome, 
			@RequestParam(name="categorias", defaultValue="") String categorias, 
			@RequestParam(name="page", defaultValue="0") Integer page, 
			@RequestParam(name="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(name="direction", defaultValue="ASC") String direction,
			@RequestParam(name="orderBy", defaultValue="nome") String orderBy){
		
				String nomeDecodec = URL.decodeParam(nome);
				List<Integer> ids = URL.decodeInList(categorias);
		
				Page<Produto> list = service.search(nomeDecodec,ids, page, linesPerPage,direction,orderBy);
				Page<ProdutoDTO> listDTO = list.map((x) -> new ProdutoDTO(x));
				return ResponseEntity.ok().body(listDTO);
	}
}
