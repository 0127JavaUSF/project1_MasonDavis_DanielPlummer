package com.revature.util;

/*Daniel Plummer
 * Project_1
 * ConnectionUtil util class
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {
	
	static {
		try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	}

	public static Connection connect() {

		try {
			Connection conn = DriverManager.getConnection(PlainTextConfig.getUrl(), PlainTextConfig.getUsername(),
					PlainTextConfig.getPassword());
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public static void main(String[] args) {
		Connection testConn = connect();
		System.out.println(testConn);
	}
}
