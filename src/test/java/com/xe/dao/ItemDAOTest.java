package com.xe.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.xe.domain.Categoria;
import com.xe.domain.Item;
import com.xe.domain.Usuario;

public class ItemDAOTest {

	@Ignore
	@Test
	public void salvar() {
		Item item = new Item();
		Categoria categoria = new Categoria();
		Usuario servidor = new Usuario();
		
		ItemDAO itemDAO = new ItemDAO();
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		categoria = categoriaDAO.buscar(1L);
		servidor = usuarioDAO.buscar(3L);
		
		item.setNome("Lapis");
		item.setCategoria(categoria);
		item.setQuantidade(new Short("2"));
		item.setServidor(servidor);
		
		itemDAO.salvar(item);
	}
	
	@Ignore
	@Test
	public void listar() {
		ItemDAO itemDAO = new ItemDAO();
		
		List<Item> itens = itemDAO.listar();
		
		for (Item item : itens) {
			System.out.println(item.getNome());
		}
	}
	
	@Ignore
	@Test
	public void buscar() {
		Long codigo = 2L;
		
		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscar(codigo);
		
		System.out.println(item.getNome());
	}
	
	@Ignore
	@Test
	public void excluir() {
		Long codigo = 2L;
		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscar(codigo);
		itemDAO.excluir(item);
	}
	
	@Test
	public void editar() {
		Long codigo = 1L;
		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscar(codigo);
		item.setQuantidade(new Short("2"));
		itemDAO.editar(item);
	}
}
