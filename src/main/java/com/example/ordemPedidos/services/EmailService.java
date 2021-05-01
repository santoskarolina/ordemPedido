package com.example.ordemPedidos.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.example.ordemPedidos.entities.Cliente;
import com.example.ordemPedidos.entities.Pedido;

public interface EmailService {

	//versão texto plano
	void senderOrderConfirmationEmail(Pedido obj);
	void sendMail(SimpleMailMessage msg);
	
	//versão html
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	void sendHtmlEmail(MimeMessage msg);
	
	//email de recuperacao de senha
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
