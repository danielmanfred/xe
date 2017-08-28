package com.xe.main;

import org.hibernate.Session;

import com.xe.util.HibernateUtil;

public class HibernateUtilTest {

	public static void main(String[] args) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}

}
