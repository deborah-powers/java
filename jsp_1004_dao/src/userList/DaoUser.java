package userList;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DaoUser {
	public ConnectionDb connection = new ConnectionDb ("formation");
	protected String dbName = "formation";
	protected String tableName = "user";

	public ArrayList<User> getAll() throws SQLException {
		// récupérer les infos
		ArrayList<HashMap<String, String>> objectList = connection.tableToMap (tableName);
		// liste des utilisateurs
		ArrayList<User> userList = new ArrayList<User>();
		for (HashMap<String, String> userData: objectList) userList.add (toUser (userData));
		return userList;
	}
	protected User toUser (HashMap<String, String> UserData){
		User user = new User();
		// récupérer les valeurs de la HashMap
		String nom = UserData.get ("nom");
		String prenom = UserData.get ("prenom");
		String strProfil = UserData.get ("profil");
		int profil = Integer.parseInt (strProfil);
		String strId = UserData.get ("id_user");
		int id = Integer.parseInt (strId);
		// les mettre dans l'user
		user.setNom (nom);
		user.setPrenom (prenom);
		user.setId (id);
		user.setProfil (profil);
		return user;
	}
}
