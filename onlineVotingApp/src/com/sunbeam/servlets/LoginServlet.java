package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		String email = req.getParameter("email");
		String password = req.getParameter("passwd");
		try (UserDao userdao = new UserDaoImpl()) {
			User user = userdao.findByEmail(email);
			if (user != null && user.getPassword().equals(password)) {
				System.out.println("Login successfull: " + user);
				if (user.getRole().equals("voter")) {
					resp.sendRedirect("candlist");
				} else {
					resp.sendRedirect("reslist");
				}
			} else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login Error</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("There was Error Logging in.");
				out.println("<a href='index.html'>Login again</a>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
