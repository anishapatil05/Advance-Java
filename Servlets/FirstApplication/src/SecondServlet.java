package com.anisha;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public SecondServlet() {
		super();

	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("service() method");

//	            General Settings
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("this is second application.....");
	}

}
