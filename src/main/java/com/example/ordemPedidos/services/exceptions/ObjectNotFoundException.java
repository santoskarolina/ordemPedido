package com.example.ordemPedidos.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(Long id) {
		super("Objeto não ecnontrado com id " + id);
	}

}
