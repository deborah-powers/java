
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;			// classe mÃ¨re
// communiquer avec le serveur
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/servlet-3")				// url de la page d'Ã©change
public class MaServlet3 extends HttpServlet {
	public void service (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().println ("<p>service utilis�</p>");
		// d�terminer la m�thode
		String method = req.getMethod();
		res.getWriter().println ("<p>m�thode: "+ method +"</p>");
		if (method.equals ("POST")) doPost (req, res);
		else if (method.equals ("GET")) doGet (req, res);
		else res.getWriter().println ("<p>m�thode inconnue: "+ method +"</p>");
		// tester des fonctions
		Date today = new Date();
		res.getWriter().println ("<p>date: "+ today.toString() +"</p>");
	}
	public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().println ("<p>get utilis�</p>");
		String nomSociete = req.getParameter ("societe");
		String nomVille = req.getParameter ("ville");
		res.getWriter().println ("<p>Entreprise "+ nomSociete +" � "+ nomVille +"</p>");
	}
	public void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().println ("<p>post utilis�</p>");
		String nomSociete = req.getParameter ("societe");
		String nomVille = req.getParameter ("ville");
		res.getWriter().println ("<p>"+ nomSociete +" � "+ nomVille +"</p>");
	}
}
/*
http://localhost:8080/10-01-servlet-1/maPremiereServlet?societe=cgi&ville=Paris
donner le nom de la soci�t� et de la ville manuellement
*/
