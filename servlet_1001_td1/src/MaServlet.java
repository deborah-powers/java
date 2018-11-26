
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;			// classe mÃ¨re
// communiquer avec le serveur
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/maPremiereServlet")				// url de la page d'Ã©change
public class MaServlet extends HttpServlet {
	public void service (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().println ("servlet invoqu�");
		doGet (req, res);
	}
	public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String nomSociete = req.getParameter ("societe");
		String nomVille = req.getParameter ("ville");
		res.getWriter().println (nomSociete +" � "+ nomVille);
	}
}
/*
http://localhost:8080/10-01-servlet-1/maPremiereServlet?societe=cgi&ville=Paris
donner le nom de la soci�t� et de la ville manuellement
*/
