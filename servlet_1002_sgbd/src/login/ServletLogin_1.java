package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet ("/ServletLogin_1")
public class ServletLogin_1 extends HttpServlet {
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
	protected ArrayList<String> findUser (String login, String password) throws SQLException {
		// récupérer l'utilisateur dans la bdd
		Connection connection = makeConnection();
		String strGetUser = "SELECT * FROM user WHERE login=? AND password=?";
		PreparedStatement requestGetUser = connection.prepareStatement (strGetUser);
		requestGetUser.setString (1, login);
		requestGetUser.setString (2, password);
		ResultSet resultGetUser = requestGetUser.executeQuery();
		/*
		ResultSetMetaData metadata = resultGetUser.getMetaData();
		int nbColumns = metadata.getColumnCount();
		*/
		// récupérer les données dans un array
		ArrayList<String> userData =null;
		if (resultGetUser.next()){
			userData = new ArrayList<String>();
			userData.add (resultGetUser.getString ("prenom"));
			userData.add (resultGetUser.getString ("nom"));
		//	for (int i=1; i<= nbColumns; i++) userData.add (resultGetUser.getString (i));
		}
		return userData;
	}
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// récupérer les infos du front
		String username = request.getParameter ("username");
		String password = request.getParameter ("password");
		// récupérer l'utilisateur dans la bdd
		try{
			ArrayList<String> userData = findUser (username, password);
			if (userData ==null){
				response.setStatus (302);
				response.sendRedirect ("/10-02-servlet-sgbd/formulaireLogin.html");
			}
			else{
				// crÃ©er la session
				HttpSession session = request.getSession (true);
				session.setAttribute ("prenom", userData.get(0));
				session.setAttribute ("nom", userData.get(1));
				RequestDispatcher dispatcher = request.getRequestDispatcher ("/ServletHome_1");
				dispatcher.forward (request, response);
			}
		}
		catch (SQLException e){ e.printStackTrace(); }
	}
}
