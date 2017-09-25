package com.xe.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import com.xe.dao.CategoriaDAO;
import com.xe.domain.Categoria;

@SuppressWarnings({ "serial", "deprecation" })
@ManagedBean
@ViewScoped
public class CategoriaBean implements Serializable{

	private Categoria categoria;
	private List<Categoria> categorias;
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
	
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	@PostConstruct
	public void listar() {
		try {
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			categorias = categoriaDAO.listar();
		}
		catch(RuntimeException erro) {
			Messages.addGlobalError("Erro na listagem");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		categoria = new Categoria();
	}
	
	public void salvar() {
		try {
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			categoriaDAO.salvar(categoria);		
			novo();
			Messages.addGlobalInfo("Categoria foi adicionado corretamente");
		}
		catch(RuntimeException erro) {
			Messages.addGlobalError("Erro: Categoria não foi salva");
			erro.printStackTrace();
		}
	}
	
}
