package com.janyo.mateus.domain.enums;

public enum TipoOperacao {

	ENTRADA(1, "Entrada"),
	SAIDA(2, "Saída");

	private int cod;
	private String descricao;

	private TipoOperacao(int cod, String descricao) {
		
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoOperacao toEnum(Integer cod) {
		
		if (cod ==null) {
			return null;
		}
		
		for (TipoOperacao x : TipoOperacao.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
