package com.anisha.jdbc.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatement3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver is loaded....");
		
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","anisha");
		System.out.println("Connection is created....");
		
		CallableStatement callStatement = connection.prepareCall("{call getSumOfSal(?,?,?)}");
		
		callStatement.setInt(1, 111);
		callStatement.setInt(2, 222);
        callStatement.registerOutParameter(3, Types.FLOAT);
        
        callStatement.execute();
        
        System.out.println("Sum "+callStatement.getFloat(3));
        
        connection.close();
        callStatement.close();
	
	}

}
