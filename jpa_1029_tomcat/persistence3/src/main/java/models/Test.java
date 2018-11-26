package models;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {
		Test myTest = new Test();
		// myTest.createTables();
		// myTest.requestSetData();
		myTest.requestGetData();
	}

	void requestSetData() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence3");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Adress adresseJ = new Adress("la Défense", "place de l'Ellipse");
		LocalDate naissanceJ = LocalDate.of(1975, 5, 14);
		Utilisateur joachim = new Utilisateur("Joachim", naissanceJ, adresseJ, "123");
		em.persist(joachim);

		Adress adresseL = new Adress("Paris", "place de la Contre-escarpe");
		LocalDate naissanceL = LocalDate.of(1991, 6, 22);
		Utilisateur lou = new Utilisateur("Lou", naissanceL, adresseL, "123");
		em.persist(lou);

		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	void requestGetData() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence3");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Utilisateur lou = em.find(Utilisateur.class, 3);
		System.out.println("utilisateur " + lou.getPrenom());

		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	void createTables() {
		Persistence.generateSchema("persistence3", null);
	}
}
