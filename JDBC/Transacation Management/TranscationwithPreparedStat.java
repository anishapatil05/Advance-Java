package com.anisha.jdbc.transcation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TranscationwithPreparedStat {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver loaded successfully....");

		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe", "system", "anisha");
		System.out.println("Connection created successfully...");

		connection.setAutoCommit(false);

		PreparedStatement preparedStatement = connection.prepareStatement("insert into students values(?,?,?)");

		Scanner sc = new Scanner(System.in);
		String option = null;
		while (true) {
			System.out.println("Enter student id");
			int eid = sc.nextInt();

			System.out.println("Enter student name");
			String ename = sc.next();

			System.out.println("Enter student emarks");
			double emaks = sc.nextDouble();

			preparedStatement.setInt(1, eid);
			preparedStatement.setString(2, ename);
			preparedStatement.setDouble(3, emaks);

			preparedStatement.executeUpdate();
			System.out.println("Enter : commit/rollback");
			String decision = sc.next();

			if (decision.equals("commit")) {
				connection.commit();
				System.out.println("values are commited successfully...do yo want more records yes/no");
				option = sc.next();
			} else {
				connection.rollback();
				System.out.println("values are rollback successfully...do yo want more records yes/no");
				option = sc.next();
			}

			if (option.equalsIgnoreCase("no")) {
				break;
			}
		}

		connection.close();
		preparedStatement.close();
		sc.close();
		System.out.println("Resorces are releases...");

	}

}
