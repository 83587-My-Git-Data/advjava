package com.sunbeam.beans;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class RegistrationBean {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String dob;
	private int status;
	private String role;
	private User user;

	public RegistrationBean() {
	}

	public RegistrationBean(String firstName, String lastName, String email, String password, String dob, int status,
			String role, User user) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.status = status;
		this.role = role;
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void register() {
		String date = dob;
		Date dob = Date.valueOf(date);
		 this.user = new User(firstName, lastName, email, password, status, role);
		try (UserDao userDao = new UserDaoImpl()) {
			userDao.save(user, dob);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
