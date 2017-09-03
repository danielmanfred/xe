package com.xe.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.xe.domain.Pessoa;
import com.xe.domain.Usuario;

public class UsuarioDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Usuario usuario = new Usuario();
		usuario.setMatricula("2015789101");
		usuario.setNome("Souza");
		usuario.setSenha("24242424");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
	}

	@Test
	@Ignore
	public void listar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.listar();

		for (Usuario usuario : resultado) {
			System.out.println("Nome: " + usuario.getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);

		if (usuario == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Nome: " + usuario.getNome());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 3L;

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);
		
		if (usuario == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			usuarioDAO.excluir(usuario);
			System.out.println("Nome: " + usuario.getNome());
		}
	}
	
	@Test
	public void editar() {
		Long codigo = 5L;

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);
		usuario.setNome("Manfred");
		usuarioDAO.editar(usuario);
	}

}
