package com.example.ordemPedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ordemPedidos.entities.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
