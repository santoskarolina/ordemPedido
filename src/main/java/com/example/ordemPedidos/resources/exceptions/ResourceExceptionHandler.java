package com.example.ordemPedidos.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.ordemPedidos.services.exceptions.DataIntegrityException;
import com.example.ordemPedidos.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> resurceNotFound(ObjectNotFoundException e, HttpServletRequest request ){
		String error = "Recursos não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataException(DataIntegrityException e, HttpServletRequest request ){
		String error = "Violação de dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
		String erro = "Erro da validação";
		String message = "Campos incorretos";
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		
		ValidationError validationErro = new ValidationError(Instant.now(), status.value(), erro, message, request.getRequestURI());
		
		//percorrer a lista de erros
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			validationErro.addError(x.getDefaultMessage());
		}	
		return ResponseEntity.status(status).body(validationErro);	
	}
}
