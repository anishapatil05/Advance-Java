package com.anisha.jdbc.firstapp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* try-catch-finally :
 *                    TASK : create a students table table : sid, sname, smarks 
 *                    insert four student records 
 *                    print the records 
 *                    update the marks +2 where marks>35
 *                    stop the excution 20sec : goto database and check db is updated or not
 *                    drop the table */

public class Assignment2 {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
	   
		
		try {
		// Load the Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver is loaded successfully....");
		
//		Create Conncetion
	    connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","anisha");
		System.out.println("Connection created....");
		
//		Create Statement
	    statement = connection.createStatement();
	    
//	    Ececute query : 1.Create table
	    String createTableQuery = "create table students ( "
	    		                 + "sid number ,"
	    		                 + "sname varchar2(10) ,"
	    		                 + "smarks number )";
	    statement.executeUpdate(createTableQuery);
	    System.out.println("Table is created....");
	    
	    
//	    2 :  insert four student records 
	    statement.executeUpdate("insert into students values(111,'Shreya',34.90)");
	    statement.executeUpdate("insert into students values(222,'Anisha',56.90)");
	    statement.executeUpdate("insert into students values(333,'Apeksha',90.67)");
	    statement.executeUpdate("insert into students values(444,'Neha',89.09)");
	    
	    System.out.println("Data is inserted  ....");
	    
//	    3 : Print the records
	    
		ResultSet set = statement.executeQuery("select * from students ");

		while (set.next()) {
			System.out.println(set.getInt(1) + " " + set.getString(2) + " " + set.getInt(3));
		}
	    
//	    4.update the marks +2 where marks>35
		int a = statement.executeUpdate("update students set smarks = smarks+2 where smarks>35");
		System.out.println("Data is updated by..."+a+" rows");
		
//		5.stop the excution 20sec : goto database and check db is updated or not
		System.out.println("Pausing database for 20sec...Check the database");
	    Thread.sleep( 20000);
	    
//	    6.Drop the table
	    statement.executeUpdate("drop table students");
	    System.out.println("table is dropped....");
		
		
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}

	}

}
