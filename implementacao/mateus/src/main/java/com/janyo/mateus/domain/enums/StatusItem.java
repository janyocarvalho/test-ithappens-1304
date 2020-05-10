package com.janyo.mateus.domain.enums;

public enum StatusItem {
	
	ATIVO (1, "Ativo"),
	CANCELADO (2, "Cancelado"),
	PROCESSADO (3, "Processado");
	
	
	private int cod;
	private String descricao;

	private StatusItem(int cod, String descricao) {
		
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static StatusItem toEnum(Integer cod) {
		
		if (cod ==null) {
			return null;
		}
		
		for (StatusItem x : StatusItem.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}