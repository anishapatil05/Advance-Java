package com.anisha.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/*                  USING PreparedStatement 
           TASK : Take a input from end user and store into database 
 *         INPUT : eid , ename , esal  */ 
public class Application {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		Loading driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver is loaded successfully...");
		
//		Creating connection
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe", "system", "anisha");
		System.out.println("Connection created successfully....");
		
//		Creating PreparedStatement
		PreparedStatement preparedstatement = connection.prepareStatement("insert into emp values(?,?,?)");
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter your eid...");
			int eid = sc.nextInt();

			System.out.println("Enter your ename..");
			String ename = sc.next();

			System.out.println("Enter your esal...");
			double esal = sc.nextDouble();
			
			preparedstatement.setInt(1, eid);
			preparedstatement.setString(2, ename);
			preparedstatement.setDouble(3, esal);
			
			preparedstatement.executeUpdate();
			System.out.println("Data is stored...If you want to store once again Yes/No");
			String option = sc.next();
			if(option.equalsIgnoreCase("No")) {
				break;
			}

		}
	 preparedstatement.close();
	 connection.close();
	 sc.close();
	
	 System.out.println("Resources realses successfully....");

	}

}
