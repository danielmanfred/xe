package com.xe.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.xe.dao.CategoriaDAO;
import com.xe.dao.ItemDAO;
import com.xe.dao.UsuarioDAO;
import com.xe.domain.Categoria;
import com.xe.domain.Item;
import com.xe.domain.Usuario;

@SuppressWarnings({ "serial", "deprecation" })
@ManagedBean
@ViewScoped
public class ItemBean implements Serializable {

	private Usuario servidor;
	private Categoria categoria;
	private Item item;
	private List<Usuario> servidores;
	private List<Categoria> categorias;
	private List<Item> itens;
	
	public Usuario getServidor() {
		return servidor;
	}
	
	public void setServidor(Usuario servidor) {
		this.servidor = servidor;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public List<Usuario> getServidores() {
		return servidores;
	}
	
	public void setServidores(List<Usuario> servidores) {
		this.servidores = servidores;
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
	
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public List<Item> getItens() {
		return itens;
	}
	
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	@PostConstruct
	public void listar() {
		try {
			ItemDAO itemDAO = new ItemDAO();
			itens = itemDAO.listar();
		}
		catch(RuntimeException erro) {
			Messages.addGlobalError("Erro na listagem");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		item = new Item();
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			servidores = usuarioDAO.listar();
			categorias = categoriaDAO.listar();
		}
		catch(RuntimeException erro) {
			Messages.addGlobalError("Erro na listagem de servidores ou categorias");
			erro.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			ItemDAO itemDAO = new ItemDAO();
			itemDAO.merge(item);
			
			item = new Item();
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			servidores = usuarioDAO.listar();
			categorias = categoriaDAO.listar();
			
			itens = itemDAO.listar();
			
			Messages.addGlobalInfo("Item foi salvo corretamente");
		}
		catch(RuntimeException erro) {
			Messages.addGlobalError("Erro: Item não foi salvo");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		try {
			item = (Item) evento.getComponent().getAttributes().get("escolhido");
			ItemDAO itemDAO = new ItemDAO();
			itemDAO.excluir(item);		
			Messages.addGlobalInfo("O objeto foi removido");
			listar();
		}
		catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro na remoção");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		item = (Item) evento.getComponent().getAttributes().get("escolhido");
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			servidores = usuarioDAO.listar();
			categorias = categoriaDAO.listar();
		}
		catch(RuntimeException erro) {
			Messages.addGlobalError("Erro na edição de servidores ou categorias");
			erro.printStackTrace();
		}
	}
}
