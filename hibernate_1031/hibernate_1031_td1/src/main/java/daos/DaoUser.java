package daos;

import models.User;

public class DaoUser extends Dao {

	public static void main(String[] args) {
		User user = DaoUser.findById(2);
		System.out.println(user);
		Dao.close();
	}

	public static void persist(User transientUser) {
		session.getTransaction().begin();
		session.persist(transientUser);
		session.getTransaction().commit();
	}

	public static User findById(int id) {
		User user = (User) session.get(User.class, id);
		return user;
	}
}
