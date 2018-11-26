package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

	protected Connection makeConnection(){
		String user = "root";
		String password = "";
		String urlBase = "jdbc:mysql://localhost/";
		String driver = "com.mysql.cj.jdbc.Driver";
		String database = "formation";
		Connection connection = null;
		String url = urlBase + database + "?serverTimezone=UTC";
		try {
			Class.forName (driver);
			connection = DriverManager.getConnection (url, user, password);
		}
		catch (ClassNotFoundException e){ System.err.println ("manque peut-être le mysql-connector.jar: "+ e.getMessage()); }
		catch (SQLException e){ System.err.println ("echec de connection: "+ e.getMessage()); }
		return connection;
	}
	protected User findUser (String login, String password) throws SQLException {
		// récupérer l'utilisateur dans la bdd
		Connection connection = makeConnection();
		User user = new User();
		boolean userExists = user.fromDb (connection, login, password);
		if (userExists) return user;
		else return null;
	}
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// récupérer les infos du front
		String username = request.getParameter ("username");
		String password = request.getParameter ("password");
		// récupérer l'utilisateur dans la bdd
		try{
			User user = findUser (username, password);
			if (user ==null){
				response.setStatus (302);
				response.sendRedirect ("/10-02-servlet-sgbd/formulaireLogin.html");
			}
			else{
				// crÃ©er la session
				HttpSession session = request.getSession (true);
				session.setAttribute ("user", user);
				RequestDispatcher dispatcher = request.getRequestDispatcher ("/ServletHome");
				dispatcher.forward (request, response);
			}
		}
		catch (SQLException e){ e.printStackTrace(); }
	}
}
