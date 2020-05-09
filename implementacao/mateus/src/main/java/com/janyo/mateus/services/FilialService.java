package com.janyo.mateus.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janyo.mateus.domain.Filial;
import com.janyo.mateus.repositories.FilialRepository;

@Service
public class FilialService {
	
	@Autowired
	private FilialRepository repo;
	
	public Filial buscar(Integer id) {
		Optional<Filial> obj = repo.findById(id);
		return obj.orElse(null); 
		
	}

}