package com.example.ordemPedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ordemPedidos.entities.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{

}
