package com.xe.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.xe.domain.Categoria;

public class CategoriaDAOTest {
	
	@Test
	public void salvar() {
		Categoria categoria = new Categoria();		
		categoria.setNome("Física");
		
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		categoriaDAO.salvar(categoria);
	}

	@Test
	@Ignore
	public void listar() {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		List<Categoria> categorias = categoriaDAO.listar();
		
		for (Categoria categoria : categorias) {
			System.out.println(categoria.getNome());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;		
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = categoriaDAO.buscar(codigo);
		
		System.out.println(categoria.getNome());
	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;		
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = categoriaDAO.buscar(codigo);
		categoriaDAO.excluir(categoria);
	}
	
	@Test
	@Ignore
	public void editar() {
		Long codigo = 1L;		
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = categoriaDAO.buscar(codigo);
		categoria.setNome("Matemática");
		categoriaDAO.editar(categoria);
	}
}
