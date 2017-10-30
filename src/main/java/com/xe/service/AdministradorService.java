package com.xe.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.xe.dao.AdministradorDAO;
import com.xe.domain.Administrador;

@Path("administrador")
public class AdministradorService {

	@GET
	public String listar() {
		AdministradorDAO administradorDAO = new AdministradorDAO();
		List<Administrador> administradores = administradorDAO.listar("nome");

		Gson gson = new Gson();

		String json = gson.toJson(administradores);

		return json;
	}
	
	@GET
	@Path("{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public String buscar(@PathParam("codigo") Long codigo) {
		AdministradorDAO administradorDAO = new AdministradorDAO();
		Administrador administrador = administradorDAO.buscar(codigo);
		
		Gson gson = new Gson();

		String json = gson.toJson(administrador);

		return json;
	}
	
	@POST
	public void salvar(String json) {
		Gson gson = new Gson();
		Administrador administrador = gson.fromJson(json, Administrador.class);
		
		AdministradorDAO administradorDAO = new AdministradorDAO();
		administradorDAO.salvar(administrador);
	}
	
	@PUT
	public void editar(String json) {
		Gson gson = new Gson();
		Administrador administrador = gson.fromJson(json, Administrador.class);
		
		AdministradorDAO administradorDAO = new AdministradorDAO();
		administradorDAO.editar(administrador);
	}
	
	@DELETE
	public void excluir(String json) {
		Gson gson = new Gson();
		Administrador administrador = gson.fromJson(json, Administrador.class);
		
		AdministradorDAO administradorDAO = new AdministradorDAO();
		administrador = administradorDAO.buscar(administrador.getCodigo());
		administradorDAO.excluir(administrador);
	}
}
