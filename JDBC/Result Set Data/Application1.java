package com.anisha.jdbc.resultset.backword;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {

//		Load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver loaded successfully...");

//      Create connection with database
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe", "system", "anisha");
		System.out.println("Conncetion created successfully...");

//		Create Statement : To print data in backword direction..
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

		ResultSet set = statement.executeQuery("select * from emp");

//        To move cursor at after last record
		set.afterLast();

		while (set.previous()) {
			System.out.println(set.getInt(1) + " " + set.getString(2) + " " + set.getInt(3));
		}

		set.first();
		System.out.println(set.getString(2));

		set.last();
		System.out.println(set.getInt(3));

		set.absolute(4);
		System.out.println(set.getInt(1));

//		To close the connections...
		connection.close();
		statement.close();
		System.out.println("Resoureses are releses...");
	}

}
