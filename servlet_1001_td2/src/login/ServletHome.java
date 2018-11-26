package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet ("/ServletHome")
public class ServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// récupérer le nom d'utilisateur
		String username = request.getParameter ("username");
		/*
		HttpSession session = request.getSession (false);
		String username = (String) session.getAttribute ("username");
		*/
		// afficher un message
		response.getWriter().println ("<!DOCTYPE html><html><head><meta charset='ISO-8859-1'><title>login page 2</title></head><body>");
		response.getWriter().println ("<h1>Bonjour "+ username +"</h1>");
		response.getWriter().println ("</body></html>");
	}
}
