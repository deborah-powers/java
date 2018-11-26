package login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
*/

public class User {
	public int id;
	public String nom;
	public String prenom;
	public String login;
	public String password;
	public String email;
	public int profil;
	/*
	bdd = formation
	table = user
	*/

	public boolean fromDb (Connection connection, String login, String password) throws SQLException {
		boolean userExists = false;
		// rÈcupÈrer les infos dans la bdd
		String strGetUser = "SELECT * FROM user WHERE login=? AND password=?";
		PreparedStatement requestGetUser = connection.prepareStatement (strGetUser);
		requestGetUser.setString (1, login);
		requestGetUser.setString (2, password);
		ResultSet resultGetUser = requestGetUser.executeQuery();
		// remplir l'user
		if (resultGetUser.next()){
			this.login = login;
			this.password = password;
			email = resultGetUser.getString ("email");
			nom = resultGetUser.getString ("nom");
			prenom = resultGetUser.getString ("prenom");
			id = resultGetUser.getInt ("id_user");
			profil = resultGetUser.getInt ("profil");
			userExists = true;
		}
		return userExists;
	}
	/*
	public void fromRequest (HttpServletRequest request, Connection connection) throws IOException, SQLException {
		// r√©cup√©rer les donn√©es d'user
		String username = request.getParameter ("username");
		String password = request.getParameter ("password");
		boolean userExists = fromDb (connection, username, password);
		// mettre user dans la session
		HttpSession session = request.getSession (true);
		if (userExists) session.setAttribute ("user", this);
		else session.setAttribute ("user", null);
	}*/
	public User (String nom, String prenom, String login, String password, String email, int profil){
		this.nom = nom; this.prenom = prenom;
		this.login = login; this.password = password; this.email = email;
		this.profil = profil;
	}
	public User(){
		this ("Dumas", "Roland", "roro", "root", "rd@gmail.com", 1); }
}
