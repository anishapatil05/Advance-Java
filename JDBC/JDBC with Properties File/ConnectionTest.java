package com.anisha.jdbc.propertiesfile.example;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionTest {

	public static Connection crateConnection() {
		Connection connection = null;

		try {
//			Load the properties file
			Properties properties = new Properties();
			properties.load(new FileInputStream("abc.properties"));

//			read the data from properties file
			Class.forName(properties.getProperty("driver"));

			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),
					properties.getProperty("password"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	}

}
