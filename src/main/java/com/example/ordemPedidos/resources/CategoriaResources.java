package com.example.ordemPedidos.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.ordemPedidos.entities.Categoria;
import com.example.ordemPedidos.entities.DTO.CategoriaDTO;
import com.example.ordemPedidos.services.CategoriaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

	@Autowired
	private CategoriaService service;
	
	@ApiOperation(value="Retorna todas as categorias")
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<CategoriaDTO> listDTO = service.findAll().stream().map((x) -> new CategoriaDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@ApiOperation(value="Buscar categoria por id")
	@GetMapping(value="/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id){
		Categoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value="Inserir nova categoria")
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO objDTO){
		Categoria obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value="Atualizar categoria")
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(value="/{id}")
	public ResponseEntity<Categoria> update(@Valid @RequestBody CategoriaDTO objDTo, @PathVariable Integer id){
		Categoria obj = service.fromDTO(objDTo);
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value="Deletar categoria por id")
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value="/{id}")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "N??o ?? poss??vel excluir uma categoria que possui produtos") })
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@ApiOperation(value="Retornar todas as categorias com pagina????o")
	@GetMapping(value="/page")
	public ResponseEntity<Page<CategoriaDTO>> findPage(
			@RequestParam(name="page", defaultValue="0") Integer page, 
			@RequestParam(name="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(name="direction", defaultValue="ASC") String direction,
			@RequestParam(name="orderBy", defaultValue="nome") String orderBy		
			){
				Page<Categoria> list = service.findPage(page, linesPerPage,direction,orderBy);
				Page<CategoriaDTO> listDTO = list.map((x) -> new CategoriaDTO(x));
				return ResponseEntity.ok().body(listDTO);
	}
}
