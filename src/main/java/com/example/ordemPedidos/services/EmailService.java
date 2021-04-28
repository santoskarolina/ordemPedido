package com.example.ordemPedidos.services;

import org.springframework.mail.SimpleMailMessage;

import com.example.ordemPedidos.entities.Pedido;

public interface EmailService {

	void senderOrderConfirmationEmail(Pedido obj);
	void sendMail(SimpleMailMessage msg);
}
