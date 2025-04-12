package com.anisha.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FirstServlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		General settings
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ServletContext context = request.getServletContext(); 
	out.println("FirstServlet context param-1: "+context.getInitParameter("username"));
	out.print("<br><br>");
	out.println("FirstServlet context param-2: "+context.getInitParameter("Password"));
	out.print("<br><br>");
//		accessing init-param from web.xml

		ServletConfig config = this.getServletConfig();
		out.println("First Servlet init-param-1 : "+config.getInitParameter("Carloan"));
		out.print("<br><br>");
		out.println("First Servlet init param-2 : "+config.getInitParameter("HomeLoan"));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
