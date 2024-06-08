package myfirstapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/hi", loadOnStartup = 9, initParams = { @WebInitParam(name = "color", value = "blue"),
		@WebInitParam(name = "course", value = "DAC") })
public class Hello extends HttpServlet {
	private String color = "";

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init Called");
		color = config.getInitParameter("color");
	}

	@Override
	public void destroy() {
		System.out.println("Destroy Called");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		proposedStatement(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		proposedStatement(req, resp);
	}

	protected void proposedStatement(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("myfirstapp");
		out.print("</title>");
		out.print("</head>");
		out.printf("<body bgcolor='%s' > \n", color);
		out.printf("<h1 color='%s'> Its Your boy!</h1>", color);
		out.print("</body>");
		out.print("</html>");
	}
}
