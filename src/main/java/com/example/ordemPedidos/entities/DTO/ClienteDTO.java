package com.example.ordemPedidos.entities.DTO;

import java.io.Serializable;

import com.example.ordemPedidos.entities.Cliente;

public class ClienteDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String email;
	
	private String nome;
	
	public ClienteDTO() {
	}

	public ClienteDTO(Cliente obj) {
		super();
		id = obj.getId();
		email = obj.getEmail();
		nome = obj.getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
