package com.xe.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.xe.domain.Item;
import com.xe.domain.Negocio;
import com.xe.domain.Pessoa;

public class NegocioDAOTest {
	
	@Test
	public void salvar() throws ParseException {
		Negocio negocio = new Negocio();
		
		NegocioDAO negocioDAO = new NegocioDAO();
		ItemDAO itemDAO = new ItemDAO();
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		Item item = itemDAO.buscar(1L);
		Pessoa pessoa = pessoaDAO.buscar(6L);
		
		negocio.setItem(item);
		negocio.setCliente(pessoa);
		negocio.setData(new SimpleDateFormat("dd/MM/yyyy").parse("15/05/2000"));
		negocio.setValor(new BigDecimal("02.00"));
		negocio.setAcordo(false);
		negocio.setTipo('B');
		
		negocioDAO.salvar(negocio);
	}
	
	
}
