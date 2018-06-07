package com.infy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/studentsDB";
		String user = "root";
		String pass = "1234";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection connection=DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection successful!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
