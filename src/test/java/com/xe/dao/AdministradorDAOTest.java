package com.xe.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.xe.domain.Administrador;

public class AdministradorDAOTest {
	
	@Test
	public void salvar() {
		Administrador administrador = new Administrador();
		administrador.setNome("Jacob");
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(administrador);
	}
	
	@Test
	@Ignore
	public void listar() {
		AdministradorDAO administradorDAO = new AdministradorDAO();
		List<Administrador> administradores = administradorDAO.listar();
		
		for (Administrador administrador : administradores) {
			System.out.println(administrador.getNome());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 4L;
		
		AdministradorDAO administradorDAO = new AdministradorDAO();
		Administrador administrador = administradorDAO.buscar(codigo);
		
		if (administrador == null) {
			System.out.println("Nenhum adminstrador encontrado");
		}
		else {
			System.out.println("Nome: " + administrador.getNome());
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;
		
		AdministradorDAO administradorDAO = new AdministradorDAO();
		Administrador administrador = administradorDAO.buscar(codigo);
		
		if (administrador == null) {
			System.out.println("Nenhum adminstrador encontrado");
		}
		else {
			administradorDAO.excluir(administrador);
		}
	}
	
	@Test
	@Ignore
	public void editar() {
		Long codigo = 5L;
		
		AdministradorDAO administradorDAO = new AdministradorDAO();
		Administrador administrador = administradorDAO.buscar(codigo);
		
		administrador.setNome("Ringo");
		administradorDAO.editar(administrador);
	}
	
	@Test
	@Ignore
	public void merge() {
		AdministradorDAO administradorDAO = new AdministradorDAO();
		Administrador administrador = administradorDAO.buscar(10L);
		administrador.setNome("George");
		administradorDAO.merge(administrador);
	}
}
