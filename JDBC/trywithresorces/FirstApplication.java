package com.anisha.jdbc.trywithresources.firstapp;

import java.sql.*;

// Secoend Way : try with resources... 

public class FirstApplication {

	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe", "system",
				"anisha"); Statement statement = connection.createStatement()) {

//			To Retrive/ read data from emp table 

			ResultSet set = statement.executeQuery("select * from emp");

			while (set.next()) {
//				Print only one column
//				System.out.println(set.getInt(1));

//				Print all columns in table
//				System.out.println(set.getInt("eid")+" "+set.getString("ename")+" "+set.getInt("esal"));

//			 Print all columns by idx
				System.out.println(set.getInt(1) + " " + set.getString(2) + " " + set.getInt(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Operations are completed....");
	}

}
