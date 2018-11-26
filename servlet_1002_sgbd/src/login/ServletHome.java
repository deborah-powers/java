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
		// crÃ©er la session
		HttpSession session = request.getSession (false);
		User user = (User) session.getAttribute ("user");
		// afficher le message
		response.getWriter().println ("<!DOCTYPE html><html><head><meta charset='ISO-8859-1'><title>servelet 2</title></head><body>");
		response.getWriter().println ("<h1>Bonjour "+ user.prenom +" "+ user.nom +", alias "+ user.login +"</h1>");
		response.getWriter().println ("<p>email: "+ user.email +"</p>");
		response.getWriter().println ("<p>identifiant: "+ user.id +", profil: "+ user.profil +"</p>");
		response.getWriter().println ("</body></html>");
	}
}
