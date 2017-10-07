package com.xe.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContext implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent evento) {
		HibernateUtil.getFabricaDeSessoes();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent evento) {
		HibernateUtil.getFabricaDeSessoes().close();
	}
}
