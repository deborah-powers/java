package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import paiements.Paiement;

public class Dao {
	private static final String JPA_UNIT_NAME = "heritage_1108_method3";
	static protected EntityManagerFactory emf = Persistence.createEntityManagerFactory(JPA_UNIT_NAME);
	static protected EntityManager em = emf.createEntityManager();

	public void add(Paiement p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}

	public void close() {
		em.close();
		emf.close();
	}
}
