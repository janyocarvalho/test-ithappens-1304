package com.janyo.mateus.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.janyo.mateus.domain.enums.TipoOperacao;

@Entity
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataHora;
	private int operacao;
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL, mappedBy="pedido")
	private Pagamento pagamento;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
		
	@OneToMany(mappedBy ="id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();
	
	public Pedido() {
	}

	
	public Pedido(Integer id, Date dataHora, TipoOperacao operacao, Cliente cliente, Usuario usuario) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.operacao = operacao.getCod();
		this.cliente = cliente;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return dataHora;
	}

	public void setData(Date dataHora) {
		this.dataHora = dataHora;
	}
	
	public TipoOperacao getOperacao() {
		return TipoOperacao.toEnum(operacao);
	}

	public void setOperacao(TipoOperacao operacao) {
		this.operacao = operacao.getCod();
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
		
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	
	
	
}
