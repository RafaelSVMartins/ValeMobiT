package com.rafael.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class Mercadoria {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long CodigoMercadoria;
	private String TipoMercadoria;
	private String NomeMercadoria;
	private Integer Quantidade;
	@DecimalMin(value="0.01",message="Este campo não deve ser menor que 0,01")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal Preco;
	@Enumerated(EnumType.STRING)
	private StatusMercadoria status;
	
	public Mercadoria() {
		super();
	}

	public Long getCodigoMercadoria() {
		return CodigoMercadoria;
	}

	public void setCodigoMercadoria(Long codigoMercadoria) {
		CodigoMercadoria = codigoMercadoria;
	}

	public String getTipoMercadoria() {
		return TipoMercadoria;
	}

	public void setTipoMercadoria(String tipoMercadoria) {
		TipoMercadoria = tipoMercadoria;
	}

	public String getNomeMercadoria() {
		return NomeMercadoria;
	}

	public void setNomeMercadoria(String nomeMercadoria) {
		NomeMercadoria = nomeMercadoria;
	}

	public Integer getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		Quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return Preco;
	}

	public void setPreco(BigDecimal preco) {
		Preco = preco;
	}

	public StatusMercadoria getStatus() {
		return status;
	}

	public void setStatus(StatusMercadoria status) {
		this.status = status;
	}
	
	public boolean isCompra() {
		return StatusMercadoria.COMPRA.equals(this.status);
	}
	
	
	
}
