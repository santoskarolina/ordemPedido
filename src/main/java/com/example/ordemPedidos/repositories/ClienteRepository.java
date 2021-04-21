package com.example.ordemPedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ordemPedidos.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
