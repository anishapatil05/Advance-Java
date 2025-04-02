package com.anisha.jdbc.batch.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//                   STATEMENT WITH BATCH OPERATION

// Batch Operation : It add all queries inside batch and send one batch request to database and also takes one respoence
public class Application1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

//		Load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver loaded successfully...");

//		Create a Connection
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe", "system", "anisha");
		System.out.println("Connection created successfully...");

//	    Create a statement
		Statement statement = connection.createStatement();

		statement.addBatch("create table emp2(id number, name varchar(20),sal number)");
		statement.addBatch("insert into emp2 values(111,'anu',90000.89)");
		statement.addBatch("insert into emp2 values(222,'sanu',70000.89)");
		statement.addBatch("insert into emp2 values(333,'panu',80000.89)");
		statement.addBatch("drop table emp2");

		statement.executeBatch();
		System.out.println("Qeries are executed....");

		statement.close();
		connection.close();
		System.out.println("Resorces are releses...");
	}

}
