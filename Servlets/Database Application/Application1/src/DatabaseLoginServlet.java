package com.anisha.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DatabaseLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DatabaseLoginServlet() {
        // Constructor
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response); // Reuse the post logic for GET
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        
        // Retrieving form data
        String Firstname = request.getParameter("firstname");
        String Lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String mobilenum = request.getParameter("number");

        // Handling multiple address fields
        String[] caddr = request.getParameterValues("add");
        StringBuffer buffer = new StringBuffer();
     
            for (String add : caddr) {
                buffer.append(add + ",");
            }
        
        String address = buffer.toString();

        // Creating database connection and inserting data
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe", "system", "anisha");

            // SQL query to insert data
            PreparedStatement preparedStatement = connection.prepareStatement("insert into customer values(?,?,?,?,?)");

            preparedStatement.setString(1, Firstname);
            preparedStatement.setString(2, Lastname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, mobilenum);
            preparedStatement.setString(5, address);

            // Execute the query
            int a = preparedStatement.executeUpdate();

            if (a == 1) {
                writer.print("Data is inserted successfully...<br><br>");
                writer.print("<a href='/DatabaseApplication/DisplayServlet'>Click here To see records..</a>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            writer.print("Error: " + e.getMessage());
        }


    }
}
