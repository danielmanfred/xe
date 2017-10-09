package com.xe.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.xe.dao.ItemDAO;
import com.xe.dao.NegocioDAO;
import com.xe.dao.UsuarioDAO;
import com.xe.domain.Item;
import com.xe.domain.Negocio;
import com.xe.domain.Pessoa;
import com.xe.domain.Usuario;


@SuppressWarnings({ "serial", "deprecation" })
@ManagedBean
@ViewScoped
public class NegocioBean implements Serializable {
	
	private Item item;
	private Pessoa cliente;
	private Negocio negocio;
	private List<Item> itens;
	private List<Usuario> clientes;
	private List<Negocio> negocios;
	
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
	
	public Negocio getNegocio() {
		return negocio;
	}
	
	public void setNegocio(Negocio negocio) {
		this.negocio = negocio;
	}

	public List<Item> getItens() {
		return itens;
	}
	
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	public List<Usuario> getClientes() {
		return clientes;
	}
	
	public void setClientes(List<Usuario> clientes) {
		this.clientes = clientes;
	}
	
	public List<Negocio> getNegocios() {
		return negocios;
	}
	
	public void setNegocios(List<Negocio> negocios) {
		this.negocios = negocios;
	}
	
	@PostConstruct
	public void listar() {
		try {
			NegocioDAO dao = new NegocioDAO();
			negocios = dao.listar();
			//negocios = new ArrayList<>();
		}
		catch(RuntimeException erro) {
			Messages.addGlobalError("Erro na listagem");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		negocio = new Negocio();
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			ItemDAO itemDAO = new ItemDAO();
			clientes = usuarioDAO.listar("nome");
			itens = itemDAO.listar("nome");
		}
		catch(RuntimeException erro) {
			Messages.addGlobalError("Erro na listagem de clientes ou itens");
			erro.printStackTrace();
		}
	}
	
	private void novoCliente() {
		negocio = new Negocio();
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			ItemDAO itemDAO = new ItemDAO();
			cliente = usuarioDAO.buscar(3L);
			clientes = usuarioDAO.listar("nome");
			itens = itemDAO.listar("nome");
		}
		catch(RuntimeException erro) {
			Messages.addGlobalError("Erro na listagem de clientes ou itens");
			erro.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			NegocioDAO negocioDAO = new NegocioDAO();
			negocioDAO.merge(negocio);
			negocio = new Negocio();
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			ItemDAO itemDAO = new ItemDAO();
			clientes = usuarioDAO.listar();
			itens = itemDAO.listar(); 
			
			negocios = negocioDAO.listar();
			Messages.addGlobalInfo("Negocio foi realizada corretamente");
		}
		catch(RuntimeException erro) {
			Messages.addGlobalError("Erro: Negocio não foi salvo");
			erro.printStackTrace();
		}   
	}
	
	public void excluir(ActionEvent evento) {
		try {
			negocio = (Negocio) evento.getComponent().getAttributes().get("escolhido");
			NegocioDAO negocioDAO = new NegocioDAO();
			negocioDAO.excluir(negocio);		
			Messages.addGlobalInfo("O objeto foi removido");
			listar();
		}
		catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro na remoção");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		negocio = (Negocio) evento.getComponent().getAttributes().get("escolhido");
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			ItemDAO itemDAO = new ItemDAO();
			clientes = usuarioDAO.listar();
			itens = itemDAO.listar();
		}
		catch(RuntimeException erro) {
			Messages.addGlobalError("Erro na listagem de clientes ou itens");
			erro.printStackTrace();
		}
	}
	
	public void editarAcordo(ActionEvent evento) {
		
		negocio = (Negocio) evento.getComponent().getAttributes().get("escolhido");
		
		alterarAcordo();
		
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			ItemDAO itemDAO = new ItemDAO();
			clientes = usuarioDAO.listar();
			itens = itemDAO.listar();
		}
		catch(RuntimeException erro) {
			Messages.addGlobalError("Erro na listagem de clientes ou itens");
			erro.printStackTrace();
		}
	}
	
	public void selecionarItem(ActionEvent evento) throws ParseException {
		item = (Item) evento.getComponent().getAttributes().get("escolhido");
		
		boolean flag = true;
		
		for (int p = 0; p < negocios.size(); p++) {
			if (negocios.get(p).getItem().equals(item)) {
				flag = false;
			}
		}
		
		if (flag) {
			novoCliente();		
			
			negocio.setCliente(cliente);
			negocio.setItem(item);
			negocio.setData(new SimpleDateFormat("dd/MM/yyyy").parse("08/10/2017"));
			negocio.setValor(new BigDecimal("23.22"));
			negocio.setAcordo(false);
			negocio.setTipo('U');

			salvar();
		}
		else {
			Messages.addGlobalError("O objeto já foi inserido antes");
		}
	}
	
	public void alterarAcordo() {
		
		if (negocio.getAcordo()) {
			negocio.setAcordo(false);
			Messages.addGlobalInfo("Negociação foi desativada");
		}
		else {
			negocio.setAcordo(true);
			Messages.addGlobalInfo("Negociação foi ativada");
		}
	}
}
