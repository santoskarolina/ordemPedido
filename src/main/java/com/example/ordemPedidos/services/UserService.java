package com.example.ordemPedidos.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.example.ordemPedidos.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		try {
			//retornar o usuario logado no sistem
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}catch(Exception e) {
			return null;
		}	
	}
}
