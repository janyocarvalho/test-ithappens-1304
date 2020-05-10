package com.janyo.mateus.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janyo.mateus.domain.Pedido;
import com.janyo.mateus.repositories.PedidoRepository;
import com.janyo.mateus.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	
	public Pedido buscar(Integer id) {
		 Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		
	}

}