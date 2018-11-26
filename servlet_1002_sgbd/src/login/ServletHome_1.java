package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet ("/ServletHome_1")
public class ServletHome_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// récupérer le nom d'utilisateur
		String username = request.getParameter ("username");
		// crÃ©er la session
		HttpSession session = request.getSession (false);
		String prenom = (String) session.getAttribute ("prenom");
		String nom = (String) session.getAttribute ("nom");
		// afficher le message
		response.getWriter().println ("<!DOCTYPE html><html><head><meta charset='ISO-8859-1'><title>servelet 2</title></head><body><h1>Bonjour ");
		response.getWriter().println (prenom +" "+ nom +", alias "+ username);
		response.getWriter().println ("</h1></body></html>");
	}
}
