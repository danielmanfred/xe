package com.xe.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@SuppressWarnings("serial")
@Entity
@PrimaryKeyJoinColumn(name = "codigo")
public class Administrador extends Pessoa {
	
}
