package com.anisha.jdbc.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatement1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

//		Load the Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver is loaded....");

//		Create the connection
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe", "system", "anisha");
		System.out.println("Connection is created....");
		
		CallableStatement callStatement = connection.prepareCall("{call TOGETSAL4(?,?)}");
		callStatement.setInt(1, 111);
		callStatement.registerOutParameter(2, Types.FLOAT);
		
		callStatement.execute();
		
		System.out.println("Result :"+callStatement.getFloat(2));
		
		
		connection.close();
		callStatement.close();
		System.out.println("Resoreces close successfully...");

	}

}
