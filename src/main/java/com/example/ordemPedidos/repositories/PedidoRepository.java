package com.example.ordemPedidos.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.ordemPedidos.entities.Cliente;
import com.example.ordemPedidos.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	@Transactional(readOnly=true)
	public Page<Pedido> findByCliente(Cliente cliente, Pageable pageRequest);
}