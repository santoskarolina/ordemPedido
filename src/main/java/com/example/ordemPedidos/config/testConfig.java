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
	private CategoriaRepository cegoriaRepository;
	
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		Categoria c3 = new Categoria(null, "Cama mesa e banho");
		Categoria c4 = new Categoria(null, "Eletrônicos");
		Categoria c5 = new Categoria(null, "Jardinagem");
		Categoria c6 = new Categoria(null, "Decoração");
		Categoria c7 = new Categoria(null, "Perfumaria");
		cegoriaRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7));
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Mesa de escritório", 300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "Colcha", 200.00);
		Produto p7 = new Produto(null, "TV true color", 1200.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "Abajour", 100.00);
		Produto p10 = new Produto(null, "Pendente", 180.00);
		Produto p11 = new Produto(null, "Shampoo", 90.00);
		
		Produto p12 = new Produto(null, "Produto 12", 10.00);
		Produto p13 = new Produto(null, "Produto 13", 10.00);
		Produto p14 = new Produto(null, "Produto 14", 10.00);
		Produto p15 = new Produto(null, "Produto 15", 10.00);
		Produto p16 = new Produto(null, "Produto 16", 10.00);
		Produto p17 = new Produto(null, "Produto 17", 10.00);
		Produto p18 = new Produto(null, "Produto 18", 10.00);
		Produto p19 = new Produto(null, "Produto 19", 10.00);
		Produto p20 = new Produto(null, "Produto 20", 10.00);
		Produto p21 = new Produto(null, "Produto 21", 10.00);
		Produto p22 = new Produto(null, "Produto 22", 10.00);
		Produto p23 = new Produto(null, "Produto 23", 10.00);
		Produto p24 = new Produto(null, "Produto 24", 10.00);
		Produto p25 = new Produto(null, "Produto 25", 10.00);
		Produto p26 = new Produto(null, "Produto 26", 10.00);
		Produto p27 = new Produto(null, "Produto 27", 10.00);
		Produto p28 = new Produto(null, "Produto 28", 10.00);
		Produto p29 = new Produto(null, "Produto 29", 10.00);
		Produto p30 = new Produto(null, "Produto 30", 10.00);
		Produto p31 = new Produto(null, "Produto 31", 10.00);
		Produto p32 = new Produto(null, "Produto 32", 10.00);
		Produto p33 = new Produto(null, "Produto 33", 10.00);
		Produto p34 = new Produto(null, "Produto 34", 10.00);
		Produto p35 = new Produto(null, "Produto 35", 10.00);
		Produto p36 = new Produto(null, "Produto 36", 10.00);
		Produto p37 = new Produto(null, "Produto 37", 10.00);
		Produto p38 = new Produto(null, "Produto 38", 10.00);
		Produto p39 = new Produto(null, "Produto 39", 10.00);
		Produto p40 = new Produto(null, "Produto 40", 10.00);
		Produto p41 = new Produto(null, "Produto 41", 10.00);
		Produto p42 = new Produto(null, "Produto 42", 10.00);
		Produto p43 = new Produto(null, "Produto 43", 10.00);
		Produto p44 = new Produto(null, "Produto 44", 10.00);
		Produto p45 = new Produto(null, "Produto 45", 10.00);
		Produto p46 = new Produto(null, "Produto 46", 10.00);
		Produto p47 = new Produto(null, "Produto 47", 10.00);
		Produto p48 = new Produto(null, "Produto 48", 10.00);
		Produto p49 = new Produto(null, "Produto 49", 10.00);
		Produto p50 = new Produto(null, "Produto 50", 10.00);
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
		
		produtoRepository.saveAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
				p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38,
				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
		
		
		
		c1.getProdutos().addAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
				p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
		
		c1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		c2.getProdutos().addAll(Arrays.asList(p2, p4));
		c3.getProdutos().addAll(Arrays.asList(p5, p6));
		c4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		c5.getProdutos().addAll(Arrays.asList(p8));
		c6.getProdutos().addAll(Arrays.asList(p9, p10));
		c7.getProdutos().addAll(Arrays.asList(p11));
		cegoriaRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7));
		
		p1.getCategorias().addAll(Arrays.asList(c1, c4));
		p2.getCategorias().addAll(Arrays.asList(c1, c2, c4));
		p3.getCategorias().addAll(Arrays.asList(c1, c4));
		p4.getCategorias().addAll(Arrays.asList(c2));
		p5.getCategorias().addAll(Arrays.asList(c3));
		p6.getCategorias().addAll(Arrays.asList(c3));
		p7.getCategorias().addAll(Arrays.asList(c4));
		p8.getCategorias().addAll(Arrays.asList(c5));
		p9.getCategorias().addAll(Arrays.asList(c6));
		p10.getCategorias().addAll(Arrays.asList(c6));
		p11.getCategorias().addAll(Arrays.asList(c7));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
		Estado est1 = new Estado(null, "Maranhão");
		Estado est2 = new Estado(null, "Pará");
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		
		Cidade cd1 = new Cidade(null, "São Luis", est1);
		Cidade cd2 = new Cidade(null, "Imperatriz", est1);
		Cidade cd3 = new Cidade(null, "Parauapebas", est2);
		cidadeRepository.saveAll(Arrays.asList(cd1,cd2,cd3));
		
		est1.getCidades().addAll(Arrays.asList(cd1,cd2));
		est2.getCidades().addAll(Arrays.asList(cd3));
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		
		Cliente cli1 = new Cliente(null, "Ana Karolina", "anna15solviera@gmail.com", TipoCliente.PESSOA_FISICA,"618.014.053-79");
		Cliente cli2 = new Cliente(null, "Mary Santos", "mary@gmail.com",TipoCliente.PESSOA_FISICA, "618.014.053-79");
		Cliente cli3 = new Cliente(null, "João Carlos", "joao@gmail.com", TipoCliente.PESSOA_FISICA,"618.014.053-79");
		Cliente cli4= new Cliente(null, "Carlos Alberto", "carlos@gmail.com", TipoCliente.PESSOA_JURIDICA,"618.014.053-79");
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4));
		
		Endereco ed1 = new Endereco(null, "Rua", "3A", "Rua da farmacia", "Forquilha", "65052-572",cli1,cd1);
		Endereco ed2 = new Endereco(null, "Rua", "3B", "Rua da farmacia", "Forquilha", "65052-572", cli1,cd1);
		Endereco ed3 = new Endereco(null, "Rua", "12", "Rua da metalurgica", "Lima Verde", "65130-000",cli2, cd2);
		Endereco ed4 = new Endereco(null, "Rua", "12", "Rua da metalurgica", "Lima Verde", "65130-000",cli3,cd3);
		Endereco ed5 = new Endereco(null, "Rua", "12", "Rua da metalurgica", "Lima Verde", "65130-000",cli4,cd3);
		enderecoRepository.saveAll(Arrays.asList(ed1,ed2,ed3,ed4,ed5));
		
		cli1.getEnderecos().add(ed1);
		cli1.getEnderecos().add(ed2);
		cli2.getEnderecos().add(ed3);
		cli3.getEnderecos().add(ed4);
		cli4.getEnderecos().add(ed5);
		clienteRepository.saveAll(Arrays.asList(cli1,cli1,cli2,cli3,cli4));
		
		ed1.setCliente(cli3);
		ed2.setCliente(cli1);
		ed3.setCliente(cli2);
		ed4.setCliente(cli3);
		ed4.setCliente(cli4);
		enderecoRepository.saveAll(Arrays.asList(ed1,ed2,ed3,ed4));
		
		cli1.getTelefones().add("(98)983507150");
		cli2.getTelefones().add("(98)981166683");
		cli3.getTelefones().add("(98)981459104");
		cli4.getTelefones().add("(98)988091909");
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4));
	
		Pedido pd1 = new Pedido(null, sdf.parse("01/04/2021 12:30"), cli1, ed1);
		Pedido pd2 = new Pedido(null, sdf.parse("12/01/2021 12:30"), cli1, ed2);
		Pedido pd3 = new Pedido(null, sdf.parse("25/10/2020 12:30"), cli2, ed3);
		Pedido pd4 = new Pedido(null, sdf.parse("23/09/2020 12:30"), cli3, ed4);
		Pedido pd5 = new Pedido(null, sdf.parse("10/04/2021 12:30"), cli4, ed5);
		
	
		Pagamento pgt1 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pd1, sdf.parse("20/02/2021 00:00"), null);
		pd1.setPagamento(pgt1);
		Pagamento pgt2 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pd2, 4);
		pd2.setPagamento(pgt2);
		Pagamento pgt3 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pd3, sdf.parse("20/02/2021 00:00"), null);
		pd3.setPagamento(pgt3);
		Pagamento pgt4 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pd4, sdf.parse("20/02/2021 00:00"), null);
		pd4.setPagamento(pgt4);
		Pagamento pgt5 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pd5, 4);
		pd5.setPagamento(pgt5);
		
		
		cli1.getPedidos().addAll(Arrays.asList(pd1,pd2));
		cli2.getPedidos().addAll(Arrays.asList(pd3));
		cli3.getPedidos().addAll(Arrays.asList(pd4));
		cli4.getPedidos().addAll(Arrays.asList(pd5));
		
		pedidoRepository.saveAll(Arrays.asList(pd1,pd2,pd3,pd4,pd5));
		pagamentoRespository.saveAll(Arrays.asList(pgt1, pgt2,pgt3,pgt4,pgt5));
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4));
		
		
		ItemPedido ip1 = new ItemPedido(p1, pd1, 10.00, 2, 1500.20);
		ItemPedido ip2 = new ItemPedido(p2, pd2, 15.00, 1, 1320.20);
		
		
		
		pd1.getItems().addAll(Arrays.asList(ip1));
		pd2.getItems().addAll(Arrays.asList(ip2));
		
		p1.getItems().addAll(Arrays.asList(ip1));
		p2.getItems().addAll(Arrays.asList(ip2));
		
		itemRepository.saveAll(Arrays.asList(ip1,ip2));
		pedidoRepository.saveAll(Arrays.asList(pd1,pd2,pd3,pd4,pd5));
		pedidoRepository.saveAll(Arrays.asList(pd1,pd2,pd3,pd4,pd5));
		
	}
}
