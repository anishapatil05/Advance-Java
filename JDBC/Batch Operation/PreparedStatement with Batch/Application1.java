package com.anisha.jdbc.batch.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//           PREPAREDSTATEMENT WITH BATCH OPERATION

public class Application1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

//		Load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver loaded successfully...");

//		Create a Connection
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe", "system", "anisha");
		System.out.println("Connection created successfully...");

//		Create a preparedStatment

		PreparedStatement preparedstatement = connection.prepareStatement("update emp set ename=? where eid=?");

//		Setting dynamic values....
		preparedstatement.setString(1, "anishaaa");
		preparedstatement.setInt(2, 111);
		preparedstatement.addBatch();

//		Setting dynamic values....
		preparedstatement.setString(1, "saniya");
		preparedstatement.setInt(2, 222);
		preparedstatement.addBatch();

		preparedstatement.executeBatch();
		System.out.println("Operations are completed....");

//      Releses the resources...
		connection.close();
		preparedstatement.close();
		System.out.println("resoureces are releses....");

	}

}
