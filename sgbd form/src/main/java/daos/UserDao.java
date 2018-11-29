package daos;

import java.sql.*;
import java.util.ArrayList;

import models.User;

public class UserDao implements IUserDao {
	private Connection connection;

	@Override
	public User saveUser (User user) throws SQLException {
		String request = "insert into users (prenom, civilite, pays, description, inMaillingList, mdp, role) values (?, ?, ?, ?, ?, ?, ?)";
		setRequestParameters (request, user);
		// retrouver l'identifiant
		int id = 0;
		String requestFindId = "select id from users where prenom=? and mdp=?";
		PreparedStatement psFindId = connection.prepareStatement(requestFindId);
		psFindId.setString(1, user.getPrenom());
		psFindId.setString(2, user.getMdp());
		ResultSet rsFindId = psFindId.executeQuery();
		if (rsFindId.next())
			id = rsFindId.getInt("id");
		user.setId(id);
		return user;
	}
	@Override
	public void updateUser (User user) throws SQLException {
		String request = "update users set prenom=?, civilite=?, pays=?, description=?, inMaillingList=?, mdp=?, role=? where id=" + user.getId();
		setRequestParameters (request, user);
	}

	@Override
	public void removeUser(int id) throws SQLException {
		String request = "delete from users where id=?";
		getConnection();
		PreparedStatement ps = connection.prepareStatement(request);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

	@Override
	public ArrayList<User> getUserList() throws SQLException {
		ArrayList<User> userList = new ArrayList<User>();
		getConnection();
		String request = "select * from users";
		Statement s = connection.createStatement();
		ResultSet rs = s.executeQuery(request);
		while (rs.next()) {
			User user = createUser(rs);
			userList.add(user);
		}
		return userList;
	}

	@Override
	public User getUser(int id) throws SQLException {
		User user = null;
		String request = "select * from users where id=?";
		getConnection();
		PreparedStatement ps = connection.prepareStatement(request);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			user = createUser(rs);
		return user;
	}

	@Override
	public User getUser(String prenom, String password) throws SQLException {
		User user = null;
		String request = "select * from users where prenom=? and mdp=?";
		getConnection();
		PreparedStatement ps = connection.prepareStatement(request);
		ps.setString(1, prenom);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			user = createUser(rs);
		return user;
	}

	private void setRequestParameters (String request, User user) throws SQLException {
		getConnection();
		PreparedStatement ps = connection.prepareStatement(request);
		ps.setString(1, user.getPrenom());
		ps.setString(2, user.getCivilite());
		ps.setString(3, user.getPays());
		ps.setString(4, user.getDescription());
		ps.setBoolean(5, user.isInMailingList());
		ps.setString(6, user.getMdp());
		ps.setString(7, user.getRole());
		ps.executeUpdate();
	}
	private User createUser(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String prenom = rs.getString("prenom");
		String civilite = rs.getString("civilite");
		String pays = rs.getString("pays");
		String description = rs.getString("description");
		boolean inMailingList = rs.getBoolean("inMaillingList");
		String password = rs.getString("mdp");
		String role = rs.getString("role");
		User user = new User(prenom, civilite, pays, description, inMailingList, password, role, id);
		return user;
	}
	private void getConnection(){
		if (connection == null) createConnection();
	}
	private void createConnection(){
		// récupérer les valeurs
		try {
			final String DRIVER = "com.mysql.cj.jdbc.Driver";
			Class.forName(DRIVER);
			String URL = "jdbc:mysql://localhost/m2idb?serverTimezone=UTC";
			String USER = "root";
			String PASSWORD = "root";
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			System.out.println("le driver n'a pas été trouvé");
		} catch (SQLException e) {
			System.out.println("la connection à la base de donnée s'est mal passée");
			e.printStackTrace();
		}
	}
}
