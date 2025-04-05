package com.anisha.jdbc.transcation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Scanner;

public class TranscationSavePointEx {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

            // Load the driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver loaded successfully...");

            // Create Connection
            Connection  connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "anisha");
            System.out.println("Connection created successfully...");

            // Set auto-commit to false
            connection.setAutoCommit(false);

            // Create statement
            Statement  statement = connection.createStatement();

            // Execute queries
        
            statement.executeUpdate("insert into students values(111,'Anisha',23)");
            statement.executeUpdate("insert into students values(222,'neha',67)");
            Savepoint savepoint  = connection.setSavepoint(); 

            statement.executeUpdate("insert into students values(333,'Apeksha',90)");
            statement.executeUpdate("update students set smarks = smarks + 10 where smarks > 10");

            // Intentional wrong statement to cause exception
            statement.executeUpdate("delete from students where sid =333");

              Scanner sc = new Scanner(System.in);  
              System.out.println("enter commit/rollback");
            String decision = sc.next();
            
            if(decision.equals("commit")) {
            	 connection.commit();
            	 System.out.println("transcations are commited...");
            }else {
            	connection.rollback(savepoint);
           	 System.out.println("transcations are  fail...");
            }
           
           sc.close();
           connection.close();
           statement.close();

        

    }
}
