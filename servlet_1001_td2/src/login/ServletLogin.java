package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet ("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// récupérer les infos du front
		String username = request.getParameter ("username");
		String password = request.getParameter ("password");
		// vérifier si l'utilisateur est bon
		if (username.equals ("Java") && password.equals ("servlet")){
			RequestDispatcher dispatcher = request.getRequestDispatcher ("/ServletHome");
			dispatcher.forward (request, response);
			/*
			HttpSession session = request.getSession (true);
			session.setAttribute ("username", username);
			response.setStatus (302);
			response.sendRedirect ("/10-01-servlet-2/ServletHome");
			*/
		}
		else{
			response.setStatus (302);
			response.sendRedirect ("/10-01-servlet-2/formulaireLogin.html");
		}
	}
}
