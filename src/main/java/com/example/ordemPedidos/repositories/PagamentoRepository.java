package com.example.ordemPedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ordemPedidos.entities.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
