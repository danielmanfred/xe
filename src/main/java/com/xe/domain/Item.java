package com.xe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Item extends GenericDomain {
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private Short quantidade;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Pessoa servidor;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Categoria categoria;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Short getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public Pessoa getServidor() {
		return servidor;
	}

	public void setServidor(Pessoa servidor) {
		this.servidor = servidor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
