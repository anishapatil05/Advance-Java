package com.anisha.servlet;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class Connutils {

	static BasicDataSource datasource = null;
	
	static {
		datasource = new BasicDataSource();
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@Localhost:1521:xe");
		datasource.setUsername("system");
		datasource.setPassword("anisha");
	}
}
