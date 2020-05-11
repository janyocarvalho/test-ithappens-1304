package com.janyo.mateus;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.janyo.mateus.domain.Cliente;
import com.janyo.mateus.domain.Filial;
import com.janyo.mateus.domain.ItemPedido;
import com.janyo.mateus.domain.Pagamento;
import com.janyo.mateus.domain.Pedido;
import com.janyo.mateus.domain.Produto;
import com.janyo.mateus.domain.StatusItemPedido;
import com.janyo.mateus.domain.Usuario;
import com.janyo.mateus.domain.enums.EstadoPagamento;
import com.janyo.mateus.domain.enums.FormaPagamento;
import com.janyo.mateus.domain.enums.TipoOperacao;
import com.janyo.mateus.repositories.ClienteRepository;
import com.janyo.mateus.repositories.FilialRepository;
import com.janyo.mateus.repositories.ItemPedidoRepository;
import com.janyo.mateus.repositories.PagamentoRepository;
import com.janyo.mateus.repositories.PedidoRepository;
import com.janyo.mateus.repositories.ProdutoRepository;
import com.janyo.mateus.repositories.StatusItemPedidoRepository;
import com.janyo.mateus.repositories.UsuarioRepository;

@SpringBootApplication
public class MateusApplication implements CommandLineRunner {
	
	@Autowired
	private FilialRepository filialRepository;	
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	@Autowired
	private StatusItemPedidoRepository statusItemPedidoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	

	public static void main(String[] args) {
		SpringApplication.run(MateusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Filial fil1 = new Filial(null, "São Luís");
		Filial fil2 = new Filial(null, "Imperatriz");
		
		Produto p1 = new Produto(null, "Arroz", 4.00);
		Produto p2 = new Produto(null, "Feijao", 5.00);
		Produto p3 = new Produto(null, "Acucar", 6.00);
		
		fil1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		fil2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getFilial().addAll(Arrays.asList(fil1));
		p2.getFilial().addAll(Arrays.asList(fil1, fil2));
		p3.getFilial().addAll(Arrays.asList(fil1));
		
		filialRepository.saveAll(Arrays.asList(fil1, fil2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Cliente cli1 = new Cliente(null, "Maria", "maria@maria.com");
		Cliente cli2 = new Cliente(null, "João", "joao@joao.com");
		
		Usuario usu1 = new Usuario(null, 12345, "Janyo Carvalho", "12345");
		Usuario usu2 = new Usuario(null, 12346, "João Sousa", "12346");
		Usuario usu3 = new Usuario(null, 12347, "Maria Firmina", "12347");
		
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		usuarioRepository.saveAll(Arrays.asList(usu1, usu2, usu3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 
		
		Pedido ped1 = new Pedido(null, sdf.parse("10/05/2019 02:20"),TipoOperacao.ENTRADA ,cli1, usu1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/05/2019 02:26"),TipoOperacao.SAIDA ,cli2, usu2);
		
		Pagamento pagto1 = new Pagamento(null,FormaPagamento.AVISTA, EstadoPagamento.QUITADO, ped1);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new Pagamento(null,FormaPagamento.BOLETO,EstadoPagamento.CANCELADO, ped2);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1));
		cli2.getPedidos().addAll(Arrays.asList(ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 1, 4.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 2, 6.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 2, 5.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
		StatusItemPedido statusItem1 = new StatusItemPedido(null, "ATIVO");
		StatusItemPedido statusItem2 = new StatusItemPedido(null, "CANCELADO");
		StatusItemPedido statusItem3 = new StatusItemPedido(null, "PROCESSADO");
		
		statusItemPedidoRepository.saveAll(Arrays.asList(statusItem1, statusItem2, statusItem3));
		
	

		
		
		
		
		
		
	}
	
}
