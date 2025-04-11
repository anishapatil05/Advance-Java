package com.anisha.loginPage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		General Settings
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

//		get requested data from client
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if(username.equalsIgnoreCase("Anisha Patil") && password.equals("anisha@05")) {
			out.print("Login success...");
		}else {
			out.print("Login fail...Please try again...");
		}

//		if (username.equalsIgnoreCase("Anisha Patil") && password.equals("anisha@05")) {
//			response.sendRedirect("https://www.flipkart.com/");
//		} else {
//			response.sendError(9090, "Enter correct data");
//		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
       doGet(request, response);

}
}
