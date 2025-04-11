package com.anisha;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ThirdServlet() {

	}

//	By Default request from browser 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

//		general settings
		PrintWriter out = response.getWriter();
		out.print("this is in doGet() method.....");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

//		general settings
		PrintWriter out = response.getWriter();
		out.print("this is in doPost() method...");
	}

}
