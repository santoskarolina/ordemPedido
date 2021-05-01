package com.example.ordemPedidos.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ordemPedidos.entities.Cliente;
import com.example.ordemPedidos.repositories.ClienteRepository;
import com.example.ordemPedidos.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private EmailService emailService;
	
	private Random random = new Random();
	
	public void sendNewPassword(String email) {
		Cliente cliente = clienteRepository.findByEmail(email);
		if (cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		
		String newPass = newPassord();
		cliente.setSenha(passwordEncoder.encode(newPass));
		clienteRepository.save(cliente);
		emailService.sendNewPasswordEmail(cliente, newPass);
	}

	private String newPassord() {
		char vet[] = new char[10];
		for(int i=0; i<10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = random.nextInt(3);
		if(opt == 0) { //gerar um numero
			return (char) (random.nextInt(10) + 48);
		}
		else if(opt == 1 ) {//gerar letra maiuscula
			return (char) (random.nextInt(26) + 65);
		}
		else{ //gerar letra minuscula
			return (char) (random.nextInt(26) + 97);
		}
	}
}
