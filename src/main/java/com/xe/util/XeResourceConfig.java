package com.xe.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class XeResourceConfig extends ResourceConfig {

	public XeResourceConfig() {
		packages("com.xe.service");
	}
}
