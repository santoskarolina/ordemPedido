package com.example.ordemPedidos.entities.DTO;

import java.io.Serializable;

import com.example.ordemPedidos.entities.Estado;

public class EstadoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public EstadoDTO() {
	}

	public EstadoDTO(Estado obj) {
		super();
		id = obj.getId();
		nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
