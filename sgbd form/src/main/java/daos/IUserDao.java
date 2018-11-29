package daos;

import java.sql.SQLException;
import java.util.ArrayList;

import models.User;

public interface IUserDao {
	// insersion ou update
	User saveUser(User user) throws SQLException;

	void updateUser(User user) throws SQLException;

	void removeUser(int id) throws SQLException;

	ArrayList<User> getUserList() throws SQLException;

	User getUser(int id) throws SQLException;

	User getUser(String prenom, String password) throws SQLException;
}
