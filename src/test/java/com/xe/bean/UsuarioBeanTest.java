package com.xe.bean;

import org.junit.Test;

import com.xe.domain.Usuario;

public class UsuarioBeanTest {
	
	@Test
	public void criarConta() {
		String nome = "Chaves";
		String matricula = "20145885";
		String senha = "14796385";
		
		UsuarioBean bean = new UsuarioBean();
		
		bean.criarConta(nome, matricula, senha);
	}
}
