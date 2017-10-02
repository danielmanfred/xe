package com.xe.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.xe.dao.AdministradorDAO;
import com.xe.dao.PessoaDAO;
import com.xe.domain.Administrador;

@SuppressWarnings({ "serial", "deprecation" })
@ManagedBean
@ViewScoped
public class AdministradorBean implements Serializable{

	private Administrador administrador;
	private List<Administrador> administradores;
	
	public Administrador getAdministrador() {
		return administrador;
	}
	
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	
	public List<Administrador> getAdministradores() {
		return administradores;
	}
	
	public void setAdministradores(List<Administrador> administradores) {
		this.administradores = administradores;
	}
	
	@PostConstruct
	public void listar() {
		try {
			AdministradorDAO administradorDAO = new AdministradorDAO();
			administradores = administradorDAO.listar();
		}
		catch(RuntimeException erro) {
			Messages.addGlobalError("Erro na listagem");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		administrador = new Administrador();
	}
	
	public void salvar() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.salvar(administrador);		
			novo();
			listar();
			Messages.addGlobalInfo("Administrador foi adicionado corretamente");
		}
		catch(RuntimeException erro) {
			Messages.addGlobalError("Erro: Administrador não foi salva");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		try {
			administrador = (Administrador) evento.getComponent().getAttributes().get("escolhido");
			AdministradorDAO administradorDAO = new AdministradorDAO();
			administradorDAO.excluir(administrador);
			Messages.addGlobalInfo("O objeto foi removido");
			listar();
		}
		catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro na remoção");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		
	}
}
