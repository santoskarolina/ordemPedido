package com.example.ordemPedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ordemPedidos.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
