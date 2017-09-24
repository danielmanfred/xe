package com.xe.bean;

import java.io.Serializable;

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
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public void novo() {
		categoria = new Categoria();
	}
	
	public void salvar() {
		//novo();
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		System.out.println("Nome: " + categoria.getNome());
		categoriaDAO.salvar(categoria);		
		System.out.println("salvar_meio");
		Messages.addGlobalInfo("Categoria foi adicionado corretamente");
		System.out.println("salvar_depois");
	}
	
}
