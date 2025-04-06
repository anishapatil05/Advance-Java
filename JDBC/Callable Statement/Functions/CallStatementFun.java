package com.anisha.jdbc.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallStatementFun {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver is loaded....");
		
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","anisha");
		System.out.println("Connection is created....");
		
		CallableStatement callableStatement = connection.prepareCall("{? = call getAvg(?,?)}");
		
		callableStatement.setInt(2, 111);
		callableStatement.setInt(3, 222);

		callableStatement.registerOutParameter(1, Types.FLOAT);
		
		callableStatement.execute();
		
		System.out.println("result "+callableStatement.getFloat(1));
		
		connection.close();
		callableStatement.close();
		
		
	}

}
