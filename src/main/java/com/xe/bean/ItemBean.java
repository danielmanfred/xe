package com.xe.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.xe.dao.ItemDAO;
import com.xe.domain.Item;

@SuppressWarnings({ "serial", "deprecation" })
@ManagedBean
@ViewScoped
public class ItemBean implements Serializable {

	private Item item;
	private List<Item> itens;
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
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
	}
	
	public void salvar() {
		try {
			ItemDAO itemDAO = new ItemDAO();
			itemDAO.salvar(item);		
			novo();
			Messages.addGlobalInfo("Item foi adicionado corretamente");
		}
		catch(RuntimeException erro) {
			Messages.addGlobalError("Erro: Item não foi salva");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		item = (Item) evento.getComponent().getAttributes().get("escolhido");
		Messages.addGlobalInfo(item.getNome());
	}
}
