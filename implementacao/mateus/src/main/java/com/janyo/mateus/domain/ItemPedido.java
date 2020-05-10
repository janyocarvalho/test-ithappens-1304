package com.janyo.mateus.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ItemPedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();	
	
	private String quantidade;
	private Double preco;
	private Integer statusItemId;
	
	public ItemPedido() {
	}

	public ItemPedido(Pedido pedido, Produto produto, String quantidade, Double preco, Integer statusItemId) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
		this.statusItemId = statusItemId;
	}
	
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}

	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getStatusItemId() {
		return statusItemId;
	}

	public void setStatusItemId(Integer statusItemId) {
		this.statusItemId = statusItemId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
