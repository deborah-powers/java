package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	public static Connection makeConnection(){
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
	public static User findUser (String login, String password) throws SQLException {
		// récupérer l'utilisateur dans la bdd
		Connection connection = makeConnection();
		User user = new User();
		boolean userExists = user.fromDb (connection, login, password);
		if (userExists) return user;
		else return null;
	}
}
