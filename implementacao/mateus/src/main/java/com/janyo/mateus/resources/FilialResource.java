package com.janyo.mateus.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.janyo.mateus.domain.Filial;

@RestController
@RequestMapping(value="/filiais")
public class FilialResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Filial> listar() {
		
		Filial fil1 = new Filial (1, "Sao Luís");
		Filial fil2 = new Filial (2, "Imperatriz");
		
		List<Filial> lista = new ArrayList<>();
		lista.add(fil1);
		lista.add(fil2);
		
		return lista;
	}
	
}

