package com.example.ordemPedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ordemPedidos.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
