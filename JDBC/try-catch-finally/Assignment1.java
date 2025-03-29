package com.anisha.jdbc.firstapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* try-catch-finally blocks :
                 TASK : Create the products table : pid pname mfdate expdate time 
                         Insert the three records.
                         Print the three records.   */

public class Assignment1 {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;

		try {
//			Load the Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver is loaded....");

//			Create the connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe", "system", "anisha");
			System.out.println("Connection is created....");

//			Create the statment
			statement = connection.createStatement();

//			execute query
//			String createTableQuery = "create table products1 ( "
//                                   +  " pid number ,"
//					               +  " pname varchar2(30) ,"
//                                   +  " mfdate varchar2(20) ,"
//					               +  " expdate varchar2(30) ,"
//                                   +  " prodution_time number(5,2) )";
//			
//			statement.executeUpdate(createTableQuery);
//			System.out.println("table is created....");
//			
//			Insert the values
			statement.executeUpdate("insert into products1 values(111,'SOAP','5/7/2024','15/8/2025',20.49)");
			statement.executeUpdate("insert into products1 values(222,'TV','6/8/2025','25/8/2029',19.39)");
			statement.executeUpdate("insert into products1 values(333,'WASING MACHINE','2/9/2022','25/8/2028',20.59)");
			System.out.println("Data is added....");

//			Printing all values 
			ResultSet set = statement.executeQuery("select * from products1");

			while (set.next()) {
				System.out.println(set.getInt(1) + " " + set.getString(2) + " " + set.getString(3) + " "
						+ set.getString(4) + " " + set.getInt(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
