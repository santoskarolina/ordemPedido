package com.example.ordemPedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ordemPedidos.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
