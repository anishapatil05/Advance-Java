package com.anisha.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*                  USING Statement 
           TASK : Take a input from end user and store into database 
 *         INPUT : eid , ename , esal  */

public class Application1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

//		Load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver loaded successfully....");

//		Create connection
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe", "system", "anisha");
		System.out.println("Connection created.....");

//		create statement 
		Statement statement = connection.createStatement();

		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.println("Enter your eid...");
			int eid = sc.nextInt();

			System.out.println("Enter your ename..");
			String ename = sc.next();

			System.out.println("Enter your esal...");
			double esal = sc.nextDouble();

//			inserting into table
			String query = "insert into emp values ( " + eid + ",'" + ename + "'," + esal + ")";
			statement.executeUpdate(query);
			System.out.println("Data is stored...If you want store once again Yes/ no");
			String option = sc.next();
			if (option.equalsIgnoreCase("no")) {
				break;
			}

		}

		connection.close();
		statement.close();
		sc.close();

	}

}
