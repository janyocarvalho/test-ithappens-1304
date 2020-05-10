package com.janyo.mateus;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.janyo.mateus.domain.Cliente;
import com.janyo.mateus.domain.Filial;
import com.janyo.mateus.domain.Pagamento;
import com.janyo.mateus.domain.Pedido;
import com.janyo.mateus.domain.Produto;
import com.janyo.mateus.domain.enums.EstadoPagamento;
import com.janyo.mateus.domain.enums.FormaPagamento;
import com.janyo.mateus.repositories.ClienteRepository;
import com.janyo.mateus.repositories.FilialRepository;
import com.janyo.mateus.repositories.PagamentoRepository;
import com.janyo.mateus.repositories.PedidoRepository;
import com.janyo.mateus.repositories.ProdutoRepository;

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
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 
		
		Pedido ped1 = new Pedido(null, sdf.parse( "10/05/2019 02:20"), cli1);
		Pedido ped2 = new Pedido(null, sdf.parse( "10/05/2019 02:26"), cli2);
		
		Pagamento pagto1 = new Pagamento(null,FormaPagamento.AVISTA, EstadoPagamento.QUITADO, ped1);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new Pagamento(null,FormaPagamento.BOLETO,EstadoPagamento.CANCELADO, ped2);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1));
		cli2.getPedidos().addAll(Arrays.asList(ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		
		
	}
	
}
