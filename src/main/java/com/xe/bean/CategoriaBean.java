package com.xe.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

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
			categoriaDAO.merge(categoria);		
			novo();
			listar();
			Messages.addGlobalInfo("Categoria foi salvo corretamente");
		}
		catch(RuntimeException erro) {
			Messages.addGlobalError("Erro: Categoria não foi salva");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		try {
			categoria = (Categoria) evento.getComponent().getAttributes().get("escolhido");
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			categoriaDAO.excluir(categoria);
			Messages.addGlobalInfo("O objeto foi removido");
			listar();
		}
		catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro na remoção");
			erro.printStackTrace();
		}	
	}
	
	public void editar(ActionEvent evento) {
		categoria = (Categoria) evento.getComponent().getAttributes().get("escolhido");
	}
}
