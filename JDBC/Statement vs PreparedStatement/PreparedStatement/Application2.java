package com.anisha.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Application2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

//		Loading driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver is loaded successfully...");

//		Creating connection
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe", "system", "anisha");
		System.out.println("Connection created successfully....");

//		Creating preparedStaement
		PreparedStatement preparedstatement = connection.prepareStatement("insert into products values(?,?,?)");

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Enter Product ID...");
			int pid = sc.nextInt();

			System.out.println("Enter Product name...");
			String pname = sc.next();

			System.out.println("Enter Product price...");
			double price = sc.nextDouble();

			preparedstatement.setInt(1, pid);
			preparedstatement.setString(2, pname);
			preparedstatement.setDouble(3, price);

			preparedstatement.executeUpdate();

			System.out.println("Data is stored...If you want store once again YES/NO");
			String option = sc.next();

			if (option.equalsIgnoreCase("No")) {
				break;
			}
		}

		connection.close();
		preparedstatement.close();
		sc.close();
		System.out.println("Resources are releses....");

	}

}
