package com.anisha.jdbc.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatement5 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver is loaded....");
		
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","anisha");
		System.out.println("Connection is created....");
		
		CallableStatement callStatement = connection.prepareCall("{call getData(?,?,?,?)}");
		
		callStatement.setInt(1, 111);
		callStatement.registerOutParameter(2, Types.INTEGER);
		callStatement.registerOutParameter(3, Types.VARCHAR);
		callStatement.registerOutParameter(4, Types.FLOAT);
		callStatement.execute();
		System.out.println(callStatement.getInt(2));
		System.out.println(callStatement.getString(3));
		System.out.println(callStatement.getFloat(4));

	}

}
