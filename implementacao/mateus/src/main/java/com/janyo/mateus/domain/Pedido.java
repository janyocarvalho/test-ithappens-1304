package com.janyo.mateus.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

	private Integer id;
	private Date data;
	private Pagamento pagamento;
	private Cliente cliente;
	
	
	private List<ItemPedido> itemPedido = new ArrayList<>();
	
	public Pedido() {
	}

	public Pedido(Integer id, Date data, Pagamento pagamento, Cliente cliente, List<ItemPedido> itemPedido) {
		super();
		this.id = id;
		this.data = data;
		this.pagamento = pagamento;
		this.cliente = cliente;
		this.itemPedido = itemPedido;
	}
	
	
}
