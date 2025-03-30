package com.anisha.jdbc.propertiesfile.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCApplication2 {

	public static void main(String[] args) throws SQLException {

//		Getting Connection 
		Connection connection = ConnectionTest.crateConnection();

//		Creating connection
		Statement statement = connection.createStatement();

//		creating statement
		ResultSet set = statement.executeQuery("select * from emp");

		ResultSetMetaData metadata = set.getMetaData();

		System.out.println(metadata.getColumnCount());
		System.out.println(metadata.getColumnDisplaySize(2));
		System.out.println(metadata.getColumnName(3));
		System.out.println(metadata.getColumnType(1));

	}

}
