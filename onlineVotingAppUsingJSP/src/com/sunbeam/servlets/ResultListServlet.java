package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class ResultListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Candidate> list = new ArrayList<Candidate>();
		try (CandidateDao candDao = new CandidateDaoImpl()) {
			list = candDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Result</title>");
		out.println("</head>");
		out.println("<body>");
		ServletContext app = this.getServletContext();
		String appTitle = app.getInitParameter("AppTitle");
		out.printf("<h3>%s</h3>", appTitle);
		out.println("<table border='1'>");
		out.println("<th>Name</th>");
		out.println("<th>Party</th>");
		out.println("<th>Votes</th>");
		out.println("<th>Action</th>");
		for (Candidate c : list) {
			out.printf(
					"<tr>  <td>%s</td> <td>%s</td> <td>%d</td> <td> <a href='editcand?id=%d'><img width='24' height='24' src='images/edit.png'/></a> <a href='delcand?id=%d'><img width='24' height='24' src='images/delete.png'/></a> </td> </tr> \n",
					c.getName(), c.getParty(), c.getVotes(), c.getId(), c.getId());
		}
		out.println("</table>");
		String msg = (String) req.getAttribute("message");
		if(msg != null)
			out.println("<br/> <br/>" +  msg + "<br/> <br/>");
		out.println("<br/><a href='announcement.html'>Announcement</a>");
		out.println("<a href='logout'>Sign Out</a>");
		out.println("</body>");
		out.println("</html>");
	}
}
