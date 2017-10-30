package com.xe.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.xe.dao.PessoaDAO;
import com.xe.dao.UsuarioDAO;
import com.xe.domain.Usuario;

@SuppressWarnings({ "serial", "deprecation" })
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {
	
	private Usuario usuario;
	private List<Usuario> usuarios;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	@PostConstruct
	public void listar() {
		try {
			UsuarioDAO dao = new UsuarioDAO();
			usuarios = dao.listar();
		}
		catch(RuntimeException erro) {
			Messages.addGlobalError("Erro na listagem");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		usuario = new Usuario();
	}
	
	public void salvar() {
		try {
			PessoaDAO dao = new PessoaDAO();
			dao.merge(usuario);
			novo();
			listar();
			Messages.addGlobalInfo("Usuário foi salvo corretamente");
		}
		catch(RuntimeException erro) {
			Messages.addGlobalError("Erro: Usuário não foi salva");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		try {
			usuario = (Usuario) evento.getComponent().getAttributes().get("escolhido");
			PessoaDAO dao = new PessoaDAO();
			dao.excluir(usuario);		
			Messages.addGlobalInfo("O objeto foi removido");
			listar();
		}
		catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro na remoção");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		usuario = (Usuario) evento.getComponent().getAttributes().get("escolhido");
	}
	
	public void criarConta(String nome, String matricula, String senha) {		
		usuario = new Usuario();
		
		usuario.setNome(nome);
		usuario.setMatricula(matricula);
		usuario.setSenha(senha);
		salvar();
	}
	
}
