package jpa_1107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao {
	// nom de l'unité de persistance, ds jpa content/persistence.xml
	private static final String JPA_UNIT_NAME = "jpa_1107";
	static protected EntityManagerFactory emf = Persistence.createEntityManagerFactory(JPA_UNIT_NAME);
	static protected EntityManager em = emf.createEntityManager();

	static public void close() {
		em.close();
		emf.close();
	}
}
