package jpa_1107;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DaoUser extends Dao {
	public static List<User> findByProfil(boolean profil) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> rootUsr = cq.from(User.class);
		cq.where(cb.equal(rootUsr.get("profil"), profil));
		return em.createQuery(cq).getResultList();
	}

	public User get(int idUser) {
		return em.find(User.class, idUser);
	}

	public void remove(int idUser) {
		em.getTransaction().begin();
		em.remove(em.find(User.class, idUser));
		em.getTransaction().commit();// fait em.flush();
	}

	public List<User> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> usr = cq.from(User.class);
		TypedQuery<User> tq = em.createQuery(cq);
		return tq.getResultList();
	}
}
