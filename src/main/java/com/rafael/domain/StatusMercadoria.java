package com.rafael.domain;

public enum StatusMercadoria {
	COMPRA("compra"),
	VENDA("venda");
	
	private String descricao;

	private StatusMercadoria(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
