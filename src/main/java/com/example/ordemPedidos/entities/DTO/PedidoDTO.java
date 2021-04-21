package com.example.ordemPedidos.entities.DTO;

import java.io.Serializable;
import java.util.Date;

import com.example.ordemPedidos.entities.Pagamento;
import com.example.ordemPedidos.entities.Pedido;


public class PedidoDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date horaPedido;
	private Pagamento pagamento;
	
	public PedidoDTO() {
	}

	public PedidoDTO(Pedido obj) {
		super();
		id = obj.getId();
		horaPedido = obj.getHoraPedido();
		pagamento = obj.getPagamento();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getHoraPedido() {
		return horaPedido;
	}

	public void setHoraPedido(Date horaPedido) {
		this.horaPedido = horaPedido;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
}
