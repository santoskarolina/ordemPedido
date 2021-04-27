package com.example.ordemPedidos.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.ordemPedidos.entities.PagamentoComBoleto;

@Service
public class BoletoService {

	public void preencherPagamentoComBoleto(PagamentoComBoleto pagt, Date instantPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instantPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagt.setDataVencimento(cal.getTime());
	}
}
