package com.anisha.loginPage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SuccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		General Settings 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("this is in SuccessServlet....You Login suucessfully...");
	}

}
