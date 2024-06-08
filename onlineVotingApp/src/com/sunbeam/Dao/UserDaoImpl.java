package com.sunbeam.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sunbeam.entity.User;

public class UserDaoImpl {
	public Connection connection;

	public void close() throws Exception {
		if (connection != null)
			connection.close();
	}

//	public User findByEmail(String email) throws Exception{
//			
//	}

	public int save(User user) throws Exception {
		String sql = "INSERT INTO users(first_name, last_name, email, password, dob, status, role) VALUES(?, ?, ?, ?, ?, ?S)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, user.getFirst_name());
			stmt.setString(2, user.getLast_name());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getPassword());
			stmt.setDate(5, user.getDob());
			stmt.setInt(6, user.getStatus());
			
			stmt.executeUpdate();	
		}
		return 0;

	}
}
