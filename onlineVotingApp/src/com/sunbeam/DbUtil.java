package com.sunbeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	public static final String DB_URL = "jdbc:mysql://localhost:3306/appdata";
	public static final String username = "kd1-AbhayDange-83587";
	public static final String password = "manager";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, username, password);
	}
}
