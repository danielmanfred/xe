package com.xe.domain;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Negocio extends GenericDomain {

	@ManyToOne
	@JoinColumn (nullable = false)
	private Item item;
	
}
