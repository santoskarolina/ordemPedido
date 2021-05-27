package com.example.ordemPedidos.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ordemPedidos.entities.Cidade;
import com.example.ordemPedidos.entities.Estado;
import com.example.ordemPedidos.entities.DTO.CidadeDTO;
import com.example.ordemPedidos.entities.DTO.EstadoDTO;
import com.example.ordemPedidos.services.CidadeService;
import com.example.ordemPedidos.services.EstadoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResources {
	
	@Autowired
	private EstadoService service;
	
	@Autowired
	private CidadeService cidadeService;
	
	@ApiOperation(value="Retornar todos os estados")
	@GetMapping
	public ResponseEntity<List<EstadoDTO>> findAll(){
		List<Estado> list = service.findAll();
		List<EstadoDTO> listDTO = list.stream().map(x -> new EstadoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@ApiOperation(value="Retornar todos as cidades de um estado")
	@GetMapping(value="/{estadoId}/cidades")
	public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer estadoId){
		List<Cidade> list = cidadeService.findbyEstado(estadoId);
		List<CidadeDTO> listDTO = list.stream().map(x -> new CidadeDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
