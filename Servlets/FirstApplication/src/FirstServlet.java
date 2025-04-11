package com.anisha;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet implements Servlet {

	public FirstServlet() {

	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() method");
	}

	public void destroy() {
		System.out.println("destroy() method");
	}

	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig() method");
		return null;
	}

	public String getServletInfo() {

		return null;
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		System.out.println("service() method");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("this is frist servlet application...");
	}

}
