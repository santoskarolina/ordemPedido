package com.example.ordemPedidos.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ordemPedidos.entities.Cliente;
import com.example.ordemPedidos.entities.ItemPedido;
import com.example.ordemPedidos.entities.PagamentoComBoleto;
import com.example.ordemPedidos.entities.Pedido;
import com.example.ordemPedidos.entities.enums.EstadoPagamento;
import com.example.ordemPedidos.entities.enums.Perfil;
import com.example.ordemPedidos.repositories.ItemPedidoRepository;
import com.example.ordemPedidos.repositories.PagamentoRepository;
import com.example.ordemPedidos.repositories.PedidoRepository;
import com.example.ordemPedidos.security.UserSS;
import com.example.ordemPedidos.services.exceptions.AuthorizationException;
import com.example.ordemPedidos.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ClientesService clienteService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private EmailService emailService;
	
	
	public Pedido findById(Integer id) {
		UserSS user = UserService.authenticated();
		Optional<Pedido> obj = repository.findById(id);
		if(user==null || !user.hasRole(Perfil.ADMIN) && !obj.get().getCliente().getId().equals(user.getId())){
			throw new AuthorizationException("Acesso Negado");
		}
	    return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setHoraPedido(new Date());
		obj.setCliente(clienteService.findById(obj.getCliente().getId()));
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		
		if(obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagt = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagt, obj.getHoraPedido());
		}
		obj = repository.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		
		for( ItemPedido ip: obj.getItems()) {
			ip.setDesconto(0.0);
			ip.setProduto(produtoService.findById(ip.getProduto().getId()));
			ip.setPreco(ip.getProduto().getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItems());
		//emailService.senderOrderConfirmationEmail(obj);
		emailService.sendOrderConfirmationHtmlEmail(obj);
		return obj;	
	}
	
	// Verifica quem é o user logado e busca os pedidos somente dele
	public Page<Pedido> findPage(Integer page, Integer linesPerPage, String direction,String orderBy){
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Cliente cliente =  clienteService.findById(user.getId());
		return repository.findByCliente(cliente, pageRequest);
	}
}
