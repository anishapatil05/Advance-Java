package com.anisha.jdbc.transcation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TranscationApllication1 {

	public static void main(String[] args) throws SQLException {
//	          Decalre The resorces
		Connection connection = null;
		Statement statement = null;

		try {
//			Load the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded successfully....");

//			Create Conncetion
			connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe", "system", "anisha");
			System.out.println("Connection created successfully...");

//			Set autoCommit to false
			connection.setAutoCommit(false);

//			Create Statement
			statement = connection.createStatement();

//			Exeucte Queries
			statement.executeUpdate("insert into emp values(333,'anu',40000)");
			statement.executeUpdate("insert into emp values(444,'prema',50000)");
			statement.executeUpdate("update emp set esal = esal+890 where esal>10000");

//			Here operation becomes fail
			statement.executeUpdate("delete from emp where eid==111");

//			Commit the Connection
			connection.commit();

			System.out.println("Operations are successfull...");

		} catch (Exception e) {
//			rollback Connection - if fail 
			connection.rollback();
			System.out.println("Operations are fail.....");

		} finally {

//			Releases the resources
			if (connection != null)
				connection.close();
			if (statement != null)
				statement.close();
			System.out.println("Resorces are releases...");
		}

	}

}
