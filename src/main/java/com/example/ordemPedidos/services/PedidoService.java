package com.example.ordemPedidos.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ordemPedidos.entities.Pedido;
import com.example.ordemPedidos.entities.enums.EstadoPagamento;
import com.example.ordemPedidos.repositories.PedidoRepository;
import com.example.ordemPedidos.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repository;
	
	public List<Pedido> findAll(){
		return repository.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setHoraPedido(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		return obj;	
	}
}
