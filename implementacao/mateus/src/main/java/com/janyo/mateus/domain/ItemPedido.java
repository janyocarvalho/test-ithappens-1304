package com.janyo.mateus.domain;

public class ItemPedido {
	private Integer id;
	private String quantidade;
	private Integer produtoId;
	private Integer statusItemId;
	private Integer pedidoId;
	
	public ItemPedido() {
	}

	public ItemPedido(Integer id, String quantidade, Integer produtoId, Integer statusItemId, Integer pedidoId) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.produtoId = produtoId;
		this.statusItemId = statusItemId;
		this.pedidoId = pedidoId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public Integer getStatusItemId() {
		return statusItemId;
	}

	public void setStatusItemId(Integer statusItemId) {
		this.statusItemId = statusItemId;
	}

	public Integer getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}
	
	

}
