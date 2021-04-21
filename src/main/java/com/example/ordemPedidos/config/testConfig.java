package com.example.ordemPedidos.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.ordemPedidos.entities.Categoria;
import com.example.ordemPedidos.entities.Cidade;
import com.example.ordemPedidos.entities.Cliente;
import com.example.ordemPedidos.entities.Endereco;
import com.example.ordemPedidos.entities.Estado;
import com.example.ordemPedidos.entities.ItemPedido;
import com.example.ordemPedidos.entities.Pagamento;
import com.example.ordemPedidos.entities.PagamentoComBoleto;
import com.example.ordemPedidos.entities.PagamentoComCartao;
import com.example.ordemPedidos.entities.Pedido;
import com.example.ordemPedidos.entities.Produto;
import com.example.ordemPedidos.entities.enums.EstadoPagamento;
import com.example.ordemPedidos.entities.enums.TipoCliente;
import com.example.ordemPedidos.repositories.CategoriaRepository;
import com.example.ordemPedidos.repositories.CidadeRepository;
import com.example.ordemPedidos.repositories.ClienteRepository;
import com.example.ordemPedidos.repositories.EnderecoRepository;
import com.example.ordemPedidos.repositories.EstadoRepository;
import com.example.ordemPedidos.repositories.ItemPedidoRepository;
import com.example.ordemPedidos.repositories.PagamentoRepository;
import com.example.ordemPedidos.repositories.PedidoRepository;
import com.example.ordemPedidos.repositories.ProdutoRepository;

@Configuration
public class testConfig implements CommandLineRunner{

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemPedidoRepository itemRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRespository;
	

	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		
		Categoria c1 = new Categoria(null, "Computadores");
		Categoria c2 = new Categoria(null, "Móveis");
		categoriaRepository.saveAll(Arrays.asList(c1,c2));
		
		Produto p1 = new Produto(null, "PC gamer", 5000.20);
		Produto p2 = new Produto(null, "Notebook gamer", 3100.00);
		Produto p3 = new Produto(null, "Geladeira", 1500.20);
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		p1.getCategorias().add(c1);
		p2.getCategorias().add(c1);
		p3.getCategorias().add(c2);
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Pedido pd1 = new Pedido(null, sdf.parse("2021-04-23 14:30"));
		Pedido pd2 = new Pedido(null, sdf.parse("2021-04-01 12:30"));
		pedidoRepository.saveAll(Arrays.asList(pd1,pd2));
		
		ItemPedido ip1 = new ItemPedido(p3, pd1, 10.00, 2, 1500.20);
		ItemPedido ip2 = new ItemPedido(p3, pd2, 10.00, 2, 1500.20);
		itemRepository.saveAll(Arrays.asList(ip1,ip2));
		
		Endereco ed1 = new Endereco(null, "Rua", "3A", "Rua da farmacia", "Forquilha", "65052-572");
		Endereco ed2 = new Endereco(null, "Rua", "3B", "Rua da farmacia", "Forquilha", "65052-572");
		Endereco ed3 = new Endereco(null, "Rua", "12", "Rua da metalurgica", "Lima Verde", "65130-000");
		Endereco ed4 = new Endereco(null, "Rua", "12", "Rua da metalurgica", "Lima Verde", "65130-000");
		enderecoRepository.saveAll(Arrays.asList(ed1,ed2,ed3,ed4));
		
		Estado est1 = new Estado(null, "Maranhão");
		Estado est2 = new Estado(null, "Pará");
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		
		Cidade cd1 = new Cidade(null, "São Luis", est1);
		Cidade cd2 = new Cidade(null, "Imperatriz", est1);
		Cidade cd3 = new Cidade(null, "Parauapebas", est2);
		cidadeRepository.saveAll(Arrays.asList(cd1,cd2,cd3));
		
		ed1.setCidade(cd1);
		ed2.setCidade(cd1);
		ed3.setCidade(cd2);
		ed4.setCidade(cd3);
		enderecoRepository.saveAll(Arrays.asList(ed1,ed2,ed3,ed4));
		
		Cliente cli1 = new Cliente(null, "Ana Karolina", "anna15solviera@gmail.com", TipoCliente.PESSOA_FISICA,"618.014.053-79");
		Cliente cli2 = new Cliente(null, "Mary Santos", "mary@gmail.com",TipoCliente.PESSOA_FISICA, "618.014.053-79");
		Cliente cli3 = new Cliente(null, "João Carlos", "joao@gmail.com", TipoCliente.PESSOA_FISICA,"618.014.053-79");
		Cliente cli4= new Cliente(null, "Carlos Alberto", "carlos@gmail.com", TipoCliente.PESSOA_JURIDICA,"618.014.053-79");
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4));
		
		cli1.getEnderecos().add(ed1);
		cli1.getEnderecos().add(ed2);
		cli2.getEnderecos().add(ed3);
		cli3.getEnderecos().add(ed4);
		cli4.getEnderecos().add(ed4);
		clienteRepository.saveAll(Arrays.asList(cli1,cli1,cli2,cli3,cli4));
		
		ed1.setCliente(cli3);
		ed2.setCliente(cli1);
		ed3.setCliente(cli2);
		ed4.setCliente(cli3);
		ed4.setCliente(cli4);
		enderecoRepository.saveAll(Arrays.asList(ed1,ed2,ed3,ed4));
		
		pd1.setEnderecoDeEntrega(ed4);
		pd2.setEnderecoDeEntrega(ed3);
		pedidoRepository.saveAll(Arrays.asList(pd1,pd2));
		
		cli1.getTelefones().add("(98)983507150");
		clienteRepository.saveAll(Arrays.asList(cli1));
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pagamento pgt1 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pd1, sdf2.parse("20/02/2021 00:00"), null);
		Pagamento pgt2 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pd2, 4);
		pagamentoRespository.saveAll(Arrays.asList(pgt1, pgt2));
		
		pd1.setPagamento(pgt1);
		pd2.setPagamento(pgt2);
		pedidoRepository.saveAll(Arrays.asList(pd1,pd2));
		
	}
}
