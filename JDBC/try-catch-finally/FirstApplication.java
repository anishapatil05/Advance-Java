package com.anisha.jdbc.firstapp;

import java.sql.*;

// But using throws keyword is not recommended : USE try-catch-finally blocks
public class FirstApplication {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statment = null;

		try {

//			Loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver is loading suucessfully...");

//			Creating connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe", "system", "anisha");
			System.out.println("Connection established successfully....");
//			
////			Creating statement : for executing 
			statment = connection.createStatement();
//			 
////			Creating table 
//			 String createTableQuery = "create table "
//			 		+ " students ("+ "Id number ,"+" name varchar(30),"+" marks number )";
////			
//			 statment.executeUpdate(createTableQuery);
//			 System.out.println("table is created successfully...");
//			 
//			 Adding values 
//			 statment.executeUpdate("insert into students values(111,'anu',78)");
//			 statment.executeUpdate("insert into students values(222,'prema',34)");
//			 statment.executeUpdate("insert into students values(333,'neha',90)");
//			 
//			 System.out.println("Student data is added....");

//			 For updating data
//			statment.executeUpdate("update students set marks = marks+10 where marks >20");
//			System.out.println("Student data updated...");

//			deleting table row 2
//			statment.executeUpdate("delete from students where ID =111");
//			System.out.println("row1 is deleted....");

//			drop the table
			int a = statment.executeUpdate("drop table students");
			System.out.println("table is droped successfully...." + a);

		} catch (ClassNotFoundException e) {
			System.out.println("Driver is not loaded sueccesfully....");
		} catch (SQLException e) {
			System.out.println("Connection is not created....");
		} finally {

			try {
				if (connection != null)
					connection.close();
				if (statment != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
