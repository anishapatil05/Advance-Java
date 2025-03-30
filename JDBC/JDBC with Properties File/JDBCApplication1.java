package com.anisha.jdbc.propertiesfile.example;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class JDBCApplication1 {

	public static void main(String[] args) throws SQLException {

		Connection connection = ConnectionTest.crateConnection();

		DatabaseMetaData metadata = connection.getMetaData();

		System.out.println(metadata.getDatabaseProductName());
		System.out.println(metadata.getDriverMajorVersion());
	}

}
