package com.xe.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Negocio extends GenericDomain {

	@ManyToOne
	@JoinColumn (nullable = false)
	private Item item;
	
	@ManyToOne
	@JoinColumn (nullable = false)
	private Pessoa cliente;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal valor;
	
	@Column(nullable = false)
	private Boolean acordo;
	
	@Column(nullable = false)
	private Character tipo;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Boolean getAcordo() {
		return acordo;
	}

	public void setAcordo(Boolean acordo) {
		this.acordo = acordo;
	}

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}
	
	
}
