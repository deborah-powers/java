package daos;

import java.util.List;
import java.util.Optional;

import org.hibernate.Filter;
import org.hibernate.NonUniqueResultException;
import org.hibernate.SQLQuery;
import org.hibernate.query.Query;

import hibernate_1031_td2.User;

public class DaoUser extends Dao {

	public static void main(String[] args) {
		getTableSql();
		Dao.close();
	}

	public static void getTableSql() {
		SQLQuery<Object> userQuery = session.createSQLQuery("SELECT * FROM User");
		userQuery.addScalar("id_user");
		userQuery.addScalar("prenom");
		userQuery.addScalar("nom");
		List<Object> userList = userQuery.getResultList();
		for (Object user : userList) {
			for (Object obj : (Object[]) user)
				System.out.print(obj + " ");
			System.out.println("");
		}
	}

	public static void getTableProfil() {
		List<User> userList = findByProfil(false);
		for (User user : userList)
			System.out.println(user);
	}

	public static void getTableConcat() {
		Query<Object> userQuery = session.createNamedQuery("User.concat");
		userQuery.setParameter("log", "p%");
		List<Object> userList = userQuery.getResultList();
		for (Object user : userList) {
			for (Object obj : (Object[]) user)
				System.out.print(obj + " ");
			System.out.println("");
		}
	}

	public static void getTableOption() {
		Query<User> userQuery = session.createQuery("SELECT u FROM User u where u.login like :login", User.class);
		userQuery.setParameter("login", "p%");
		userQuery.setMaxResults(1);
		try {
			Optional<User> userOptional = userQuery.uniqueResultOptional();
			Boolean presence = userOptional.isPresent();
			User userFromOptional = userOptional.get();
			System.out.println(userFromOptional);
		} catch (NonUniqueResultException e) {
			System.out.println("la recherche a retourné plusieurs elements");
		}
	}

	public static void getTableUnique() {
		Query<User> userQuery = session.createQuery("SELECT u FROM User u", User.class);
		userQuery.setMaxResults(1);
		try {
			User user = userQuery.uniqueResult();
			System.out.println("unique " + user.toString());
		} catch (NonUniqueResultException e) {
			System.out.println("la recherche a retourné plusieurs elements");
		}
	}

	public static void getTableLike() {
		Query<User> userQuery = session.createQuery("SELECT u FROM User u where u.login like :login", User.class);
		userQuery.setParameter("login", "p%");
		List<User> userList = userQuery.getResultList();
		for (User user : userList)
			System.out.println(user);
	}

	public static void getTableLimit() {
		Query<User> userQuery = session.createQuery("SELECT u FROM User u");
		userQuery.setFirstResult(2); // récupérer à partir de l'élement en position posMin ds la table, sans
										// prendre en compte les id
		userQuery.setMaxResults(2); // récupérer posMax lignes
		List<User> userList = userQuery.getResultList();
		for (User user : userList)
			System.out.println(user);
	}

	public static void getTable() {
		List<User> userList = session.createQuery("SELECT u FROM User u").getResultList();
		for (User user : userList)
			System.out.println(user);
	}

	public static void getTableNamed() {
		List<User> userList = session.createNamedQuery("User.findAll").list();
		for (User user : userList)
			System.out.println(user.getNomComplet());
	}

	public static void persist(User transientUser) {
		session.getTransaction().begin();
		session.persist(transientUser);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public static List<User> findByProfil(boolean profil) {
		Filter filter = session.enableFilter("profilFilter");
		filter.setParameter("unProfil", profil);
		List<User> users = session.createNamedQuery("User.findAll").list();
		session.disableFilter("profilFilter");
		return users;
	}

	public static User findById(int id) {
		User user = (User) session.get(User.class, id);
		return user;
	}

	public static User add(User user) {
		int id = user.getIdUser();
		if (id == 0) {
			session.getTransaction().begin();
			id = (int) session.save(user);
			user.setIdUser(id);
			session.getTransaction().commit();
		} else {
			System.out.println("l'user existe déjà " + id);
			// update (user);
		}
		return user;
	}

	public static void update(User user) {
		int id = user.getIdUser();
		if (id == 0) {
			System.out.println("l'user n'existe pas");
			// user = add(user);
		} else {
			session.getTransaction().begin();
			session.update(user);
			session.getTransaction().commit();
		}
	}

	public static void delete(int id) {
		User user = findById(id);
		if (user != null) {
			session.getTransaction().begin();
			session.delete(user);
			session.getTransaction().commit();
		}
	}
}
