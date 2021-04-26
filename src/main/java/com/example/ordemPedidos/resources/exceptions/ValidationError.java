package com.example.ordemPedidos.resources.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

	private static final long serialVersionUID = 1L;
	
	List<String> listaErros = new ArrayList<>();

	public ValidationError(Instant timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}

	public List<String> getListaErros() {
		return listaErros;
	}

	public void addError(String message) {
		listaErros.add(message);
	}	
}
