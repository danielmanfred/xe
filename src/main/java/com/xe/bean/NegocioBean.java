package com.xe.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.xe.dao.NegocioDAO;
import com.xe.domain.Negocio;


@SuppressWarnings({ "serial", "deprecation" })
@ManagedBean
@ViewScoped
public class NegocioBean implements Serializable {
	
	private Negocio negocio;
	private List<Negocio> negocios;
	
	public Negocio getNegocio() {
		return negocio;
	}
	
	public void setNegocio(Negocio negocio) {
		this.negocio = negocio;
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
		}
		catch(RuntimeException erro) {
			Messages.addGlobalError("Erro na listagem");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		negocio = new Negocio();
	}
	
	public void salvar() {
		try {
			NegocioDAO negocioDAO = new NegocioDAO();
			negocioDAO.salvar(negocio);
			novo();
			Messages.addGlobalInfo("Negocio foi adicionado corretamente");
		}
		catch(RuntimeException erro) {
			Messages.addGlobalError("Erro: Negocio não foi salva");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		negocio = (Negocio) evento.getComponent().getAttributes().get("escolhido");
		Messages.addGlobalInfo(negocio.getItem().getNome());
	}
}
