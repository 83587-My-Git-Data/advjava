package jspapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginBean {
	private String email;
	private String password;
	private User user;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public LoginBean() {
	}

	public LoginBean(String email, String password, User user) {
		this.email = email;
		this.password = password;
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void authenticate() {
		String DB_URL = "jdbc:mysql://localhost:3306/election";
		String DB_USER = "root";
		String DB_PASS = "manager";
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM users WHERE email=? AND password=?";
			try (PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.setString(1, this.email);
				stmt.setString(2, this.password);
				try (ResultSet rs = stmt.executeQuery()) {
					if (rs.next()) {
						int id = rs.getInt(1);
						String firstName = rs.getString(2);
						String lastName = rs.getString(3);
						String email = rs.getString(4);
						String password = rs.getString(5);
						java.sql.Date dob = rs.getDate(6);
						int status = rs.getInt(7);
						String role = rs.getString(8);
						this.user = new User(id, firstName, lastName, email, password, dob, status, role);

					} else {
						this.user = null;
					}
				} // rs.close();
			} // stmt.close();
		} // con.close();
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
