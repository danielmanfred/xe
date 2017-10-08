package com.xe.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.google.gson.Gson;
import com.xe.dao.ItemDAO;
import com.xe.domain.Item;

@Path("usuario")
public class UsuarioService {

	@GET
	public String listarItens() {
		ItemDAO dao = new ItemDAO();
		List<Item> itens = dao.listar("nome");
		
		Gson gson = new Gson();
		
		String json = gson.toJson(itens);
		
		return json;
	}
}
