package com.janyo.mateus;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.janyo.mateus.domain.Cliente;
import com.janyo.mateus.domain.Filial;
import com.janyo.mateus.domain.Produto;
import com.janyo.mateus.repositories.ClienteRepository;
import com.janyo.mateus.repositories.FilialRepository;
import com.janyo.mateus.repositories.ProdutoRepository;

@SpringBootApplication
public class MateusApplication implements CommandLineRunner {
	
	@Autowired
	private FilialRepository filialRepository;	
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ClienteRepository clienteRepository;

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
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		
	}
	
}
