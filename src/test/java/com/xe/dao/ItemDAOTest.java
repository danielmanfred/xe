package com.xe.dao;

import org.junit.Test;

import com.xe.domain.Categoria;
import com.xe.domain.Item;
import com.xe.domain.Usuario;

public class ItemDAOTest {

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
	
}
