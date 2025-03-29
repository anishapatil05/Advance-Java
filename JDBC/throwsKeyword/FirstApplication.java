package com.anisha.jdbc.throwskey.fristapp;

import java.sql.*;

// Third Way : using throws keyword
public class FirstApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

//		To load driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver loaded successfully.....");

//		Create connection java to database 
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe", "system", "anisha");
		System.out.println("Connection created successfully....");

//		Create a statement 
		Statement statement = connection.createStatement();

//		excute query
		int a = statement.executeUpdate("update emp set esal = esal+20 where esal>20000");
		System.out.println("Data is updated by ..." + a + " row");

		System.out.println("Operations are completed....");
	}

}
