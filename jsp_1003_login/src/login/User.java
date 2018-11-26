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
	private int id;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private String email;
	private int profil;
	/*
	bdd = formation
	table = user
	*/

	public boolean fromDb (Connection connection, String login, String password) throws SQLException {
		boolean userExists = false;

		// récupérer les infos dans la bdd
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
	public int getId(){ return id; }
	public void setId(int id){ this.id = id; }
	public String getNom(){ return nom; }
	public void setNom(String nom){ this.nom = nom; }
	public String getPrenom(){ return prenom; }
	public void setPrenom(String prenom){ this.prenom = prenom; }
	public String getLogin(){ return login; }
	public void setLogin(String login){ this.login = login; }
	public String getPassword(){ return password; }
	public void setPassword(String password){ this.password = password; }
	public String getEmail(){ return email; }
	public void setEmail(String email){ this.email = email; }
	public int getProfil(){ return profil; }
	public void setProfil(int profil){ this.profil = profil; }
	public User (String nom, String prenom, String login, String password, String email, int profil){
		this.nom = nom; this.prenom = prenom;
		this.login = login; this.password = password; this.email = email;
		this.profil = profil;
	}
	public User(){
		this ("Dumas", "Roland", "roro", "root", "rd@gmail.com", 1); }
}
