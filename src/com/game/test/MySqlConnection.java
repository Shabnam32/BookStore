package com.game.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	
	static Connection conn=null;
	public static Connection getConnection()throws SQLException

	{
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_db","root","root");
		return conn;
	}
	public static void closeConnection()
{if(conn!=null) {
	try {
		conn.close();
	}
	catch(SQLException e) {
		
		System.out.println("Something Wrong");
	}
}
		
}
}



