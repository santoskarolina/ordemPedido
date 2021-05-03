package com.example.ordemPedidos.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
import com.example.ordemPedidos.entities.enums.Perfil;
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


@Service
public class DBservice {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

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


	public void instantiateDatabase() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		Categoria c3 = new Categoria(null, "Cama mesa e banho");
		Categoria c4 = new Categoria(null, "Eletrônicos");
		Categoria c5 = new Categoria(null, "Jardinagem");
		Categoria c6 = new Categoria(null, "Decoração");
		Categoria c7 = new Categoria(null, "Perfumaria");
		cegoriaRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7));

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
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		c1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		c2.getProdutos().addAll(Arrays.asList(p2, p4));
		c3.getProdutos().addAll(Arrays.asList(p5, p6));
		c4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		c5.getProdutos().addAll(Arrays.asList(p8));
		c6.getProdutos().addAll(Arrays.asList(p9, p10));
		c7.getProdutos().addAll(Arrays.asList(p11));
		cegoriaRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7));

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
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		Estado est1 = new Estado(null, "Acre");
		Estado est2 = new Estado(null, "Alagoas");
		Estado est3 = new Estado(null, "Amapá");
		Estado est4 = new Estado(null, "Amazonas");
		Estado est5 = new Estado(null, "Bahia");
		Estado est6 = new Estado(null, "Ceará");
		Estado est7 = new Estado(null, "Distrito Federal");
		Estado est8 = new Estado(null, "Espírito Santo");
		Estado est9 = new Estado(null, "Goiás");
		Estado est10 = new Estado(null, "Maranhão");
		Estado est11 = new Estado(null, "Mato Grosso");
		Estado est12 = new Estado(null, "Mato Grosso do Sul");
		Estado est13 = new Estado(null, "Pará");
		Estado est14 = new Estado(null, "Paraíba");
		Estado est15 = new Estado(null, "Paraná");
		Estado est16 = new Estado(null, "Pernambuco");
		Estado est17 = new Estado(null, "Piauí");
		Estado est18 = new Estado(null, "Rio de Janeiro");
		Estado est19 = new Estado(null, "Rio Grande do Norte");
		Estado est20 = new Estado(null, "Rio Grande do Sul");
		Estado est21 = new Estado(null, "Rondônia");
		Estado est22 = new Estado(null, "Roraima");
		Estado est23 = new Estado(null, "Santa Catarina");
		Estado est24 = new Estado(null, "São Paulo");
		Estado est25 = new Estado(null, "Sergipe");
		Estado est26 = new Estado(null, "Tocantins");
		estadoRepository.saveAll(Arrays.asList(est1, est2,est3,est4,est5,est6,est7,est8,est9,est10,
				est11,est12,est13,est14,est15,est16,est17,est18,est19,est20,est21,est22,est23,est24,est25,est26));
		
		Cidade cd1 = new Cidade(null, "São Luis", est1);
		Cidade cd2 = new Cidade(null, "Imperatriz", est1);
		Cidade cd3 = new Cidade(null, "Parauapebas", est2);
		cidadeRepository.saveAll(Arrays.asList(cd1, cd2, cd3));

		est1.getCidades().addAll(Arrays.asList(cd1, cd2));
		est2.getCidades().addAll(Arrays.asList(cd3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));

		Cliente cli1 = new Cliente(null, "Ana Karolina", "lorakteste@gmail.com", TipoCliente.PESSOA_FISICA,"61801405379", passwordEncoder.encode("123"));
		cli1.getTelefones().add("(98)983507150");
		clienteRepository.saveAll(Arrays.asList(cli1));
		
		Cliente cli2 = new Cliente(null, "Maria", "marysantos.san@gmail.com", TipoCliente.PESSOA_FISICA,"61801405379", passwordEncoder.encode("123"));
		cli2.addPerfil(Perfil.ADMIN);
		cli2.getTelefones().addAll(Arrays.asList("(98)981166683","(98)981459104"));
		clienteRepository.saveAll(Arrays.asList(cli2));
		
		Cliente cli3 = new Cliente(null, "Ana Karolina", "mariasantos@gmail.com", TipoCliente.PESSOA_FISICA,"61801405379", passwordEncoder.encode("123"));
		cli1.getTelefones().add("(98)983507150");
		clienteRepository.saveAll(Arrays.asList(cli3));

		Endereco ed1 = new Endereco(null, "Rua", "3A", "Rua da farmacia", "Forquilha", "65052572", cli1, cd1);
		Endereco ed2 = new Endereco(null, "Rua", "3B", "Rua da farmacia", "Forquilha", "65052572", cli1, cd1);
		Endereco ed3 = new Endereco(null, "Rua", "3C", "Rua da Manga", "Lima Verde", "65052572", cli2, cd1);
		Endereco ed4 = new Endereco(null, "Rua", "3C", "Rua da Manga", "Lima Verde", "65052572", cli2, cd1);
		enderecoRepository.saveAll(Arrays.asList(ed1, ed2,ed3,ed4));

		cli1.getEnderecos().addAll(Arrays.asList(ed1,ed2));
		cli2.getEnderecos().add(ed3);
		cli3.getEnderecos().add(ed4);
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3));

	
		ed2.setCliente(cli1);
		enderecoRepository.saveAll(Arrays.asList(ed1, ed2));

	
		Pedido pd1 = new Pedido(null, sdf.parse("01/04/2021 12:30"), cli1, ed1);
		Pedido pd2 = new Pedido(null, sdf.parse("12/01/2021 12:30"), cli1, ed2);
		Pedido pd3 = new Pedido(null, sdf.parse("12/01/2021 12:30"), cli3, ed4);

		Pagamento pgt1 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pd1, sdf.parse("20/02/2021 00:00"),
				null);
		pd1.setPagamento(pgt1);
		Pagamento pgt2 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pd2, 4);
		pd2.setPagamento(pgt2);
		Pagamento pgt3 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pd3, 4);
		pd3.setPagamento(pgt3);

		cli1.getPedidos().addAll(Arrays.asList(pd1, pd2));
		cli3.getPedidos().addAll(Arrays.asList(pd3));

		pedidoRepository.saveAll(Arrays.asList(pd1, pd2));
		pagamentoRespository.saveAll(Arrays.asList(pgt1, pgt2,pgt3));
		clienteRepository.saveAll(Arrays.asList(cli1,cli3));

		ItemPedido ip1 = new ItemPedido(p1, pd1, 10.00, 2, 1500.20);
		ItemPedido ip2 = new ItemPedido(p2, pd2, 15.00, 1, 1320.20);

		pd1.getItems().addAll(Arrays.asList(ip1));
		pd2.getItems().addAll(Arrays.asList(ip2));

		p1.getItems().addAll(Arrays.asList(ip1));
		p2.getItems().addAll(Arrays.asList(ip2));

		itemRepository.saveAll(Arrays.asList(ip1, ip2));
		pedidoRepository.saveAll(Arrays.asList(pd1, pd2));
		pedidoRepository.saveAll(Arrays.asList(pd1, pd2));

	}

}
