package com.xe.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import com.xe.dao.PessoaDAO;
import com.xe.domain.Administrador;

@SuppressWarnings({ "serial", "deprecation" })
@ManagedBean
@ViewScoped
public class AdministradorBean implements Serializable{

	private Administrador administrador;
	
	public Administrador getAdministrador() {
		return administrador;
	}
	
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	
	public void novo() {
		administrador = new Administrador();
	}
	
	public void salvar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(administrador);
		Messages.addGlobalInfo("Administrador foi adicionado corretamente");
	}
}
