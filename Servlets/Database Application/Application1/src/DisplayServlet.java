package com.anisha.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","anisha");
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery("select * from Customer");
	    writer.print("<tr><th>Firstname</th><th>Lastname</th><th>email</th><th>Mobile No</th><th>Addrees</th></tr>");
		while(resultSet.next()) {
		    writer.print("<tr>");
		    writer.print("<td>" + resultSet.getString(1) + "</td>");
		    writer.print("<td>" + resultSet.getString(2) + "</td>");
		    writer.print("<td>" + resultSet.getString(3) + "</td>");
		    writer.print("<td>" + resultSet.getString(4) + "</td>");
		    writer.print("<td>" + resultSet.getString(5) + "</td>");
		    writer.print("</tr>");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
			writer.print("Error "+e.getMessage());
		}
		
		writer.print("<a href='Customer.html'>Click here to add records...</a>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
