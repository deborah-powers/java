

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet ("/MyServlet2")
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void action (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// r√©cup√©rer les infos du front
		String humeur = req.getParameter ("va");
		String message = "Tant mieux";
		if (humeur.equals ("mal")) message = "T'en fait pas Áa ira mieux demain";
		// cr√©er la session
		HttpSession session = req.getSession (false);
		String prenom = (String) session.getAttribute ("prenom");
		String nom = (String) session.getAttribute ("nom");
		// afficher un second formulaire
		res.getWriter().println ("<!DOCTYPE html><html><head><meta charset='ISO-8859-1'><title>servelet 2</title></head><body><h1>");
		res.getWriter().println (message +", "+ prenom +" "+ nom);
		res.getWriter().println ("</h1></body></html>");
	}
	public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().println ("<p>get utilisÈ</p>");
		action (req, res);
	}
	public void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().println ("<p>post utilisÈ</p>");
		action (req, res);
	}
}
