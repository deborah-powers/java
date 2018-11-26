

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet ("/MyServlet1")
public class MyServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void action (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// rÃ©cupÃ©rer les infos du front
		String nom = req.getParameter ("nom");
		String prenom = req.getParameter ("prenom");
		// crÃ©er la session
		HttpSession session = req.getSession (true);
		session.setAttribute ("prenom", prenom);
		session.setAttribute ("nom", nom);
		// afficher un second formulaire
		Date today = new Date();
		res.getWriter().println ("<!DOCTYPE html><html><head><meta charset='ISO-8859-1'><title>servelet 2</title></head><body>");
		res.getWriter().println ("<h1>Bonjour "+ prenom +" "+ nom +"</h1>");
		res.getWriter().println ("<p>date: "+ today.toString() +"</p>");
		res.getWriter().println ("<h1>exemple de servlet, page 3</h1><form method='get' action='MyServlet2' name='servlet-form'>");
		res.getWriter().println ("<h2>Comment ça va ?</h2><p>Bien</p><input type='radio' name='va' value='bien'><p>Mal</p><input type='radio' name='va' value='mal'><br><input type='submit' value='envoyez'>");
		res.getWriter().println ("</form></body></html>");
	}
	public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().println ("<p>get utilisé</p>");
		action (req, res);
	}
	public void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().println ("<p>post utilisé</p>");
		action (req, res);
	}
}
