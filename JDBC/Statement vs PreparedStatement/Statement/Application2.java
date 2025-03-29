package com.anisha.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* TASK : 1️⃣ Create a table named products with columns: pid, pname, price
 *        2️⃣ Insert three product records using Statement.
 *        3️⃣ Retrieve and print all records.
 *        4️⃣ Update the price of a product where pid=101.
 *        5️⃣ Delete a product record where pid=103.               */
public class Application2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

//		Load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver loaded successfully....");

//		Create connection
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe", "system", "anisha");
		System.out.println("Connection created.....");

//		Create Conncetion
		Statement statement = connection.createStatement();

//		1️⃣ Create a table named products with columns: pid, pname, price

		String createTableQuery = " create table products (" + " pid number ," + " pname varchar(20) ,"
				+ " price  number )";
		statement.executeUpdate(createTableQuery);
		System.out.println("table is created successfully....");

//		 2️⃣ Insert three product records using Statement.

		statement.executeUpdate("insert into products values(111,'SOAP',50.0)");
		statement.executeUpdate("insert into products values(222,'PEN',34.0)");
		statement.executeUpdate("insert into products values(333,'COMPAS',90.02)");

		System.out.println("Data is inserted....");

//		 3️⃣ Retrieve and print all records.

		ResultSet set = statement.executeQuery("select * from products");

		while (set.next()) {
			System.out.println(set.getInt(1) + " " + set.getString(2) + " " + set.getDouble(3));
		}

//		 4️⃣ Update the price of a product where pid=111.

		int a = statement.executeUpdate("update products set price = price+67 where pid=111");
		System.out.println("Data is updated by " + a + "row");

//		  5️⃣ Delete a product record where pid=103.        
		int b = statement.executeUpdate("delete from products where pid=333");
		System.out.println(b + " row is deleted....");

		statement.close();
		connection.close();
		
		System.out.println("Resources are realeses....");
		
	}

}
