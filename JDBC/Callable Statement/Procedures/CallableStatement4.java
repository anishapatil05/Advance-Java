package com.anisha.jdbc.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableStatement4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver is loaded....");
		
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","anisha");
		System.out.println("Connection is created....");
		
		CallableStatement callableStatement = connection.prepareCall("{call insert_data(?,?,?)}");
		
		callableStatement.setInt(1, 333);
		callableStatement.setString(2, "januu");
		callableStatement.setFloat(3, 56000.89f);
		
		callableStatement.execute();
		
	
		
		connection.close();
		callableStatement.close();
		
		

	}

}
