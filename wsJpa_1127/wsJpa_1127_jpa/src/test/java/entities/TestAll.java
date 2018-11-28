package entities;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entites.Adresse;
import entites.Entreprise;
import entites.Geo;
import entites.Travailleur;

public class TestAll {
	private static EntityManagerFactory	factory;
	// @PersistenceContext (unitName = "wsjpa_1127_jpa") // remplace factory dans une app tournant sur un serveur
	private static EntityManager		manager;
	private static EntityTransaction	transaction;

	@Test
	public void insert (){
		Geo			geoJoachim	= new Geo ("15.31", "95.1");
		Adresse		chezJoachim	= new Adresse ("73", "bd Dessière", "Paris", "75017", geoJoachim);
		Entreprise	j4l			= new Entreprise ("j4l technologies", "informatique", "être au service de l'automatisation de l'information");
		Travailleur	joachim		= new Travailleur ("joachim", "zadi", LocalDate.of (1982, 03, 20), chezJoachim, "joachim@gmail", "06 07 08 09 10", "http://joachim.fr/", j4l);
		manager.persist (geoJoachim);
		manager.persist (chezJoachim);
		manager.persist (j4l);
		manager.persist (joachim);
		assertNotNull ("pb ds la création du tveur", joachim.getId ());
	}
	@Test
	public void createTable (){}
	@Before // au début de chaque test
	public void beginTest (){
		manager		= factory.createEntityManager ();
		transaction	= manager.getTransaction ();
		transaction.begin ();
	}
	@After
	public void endTest (){
		transaction.commit ();
		manager.close ();
		factory.close ();
	}
	@BeforeClass // au début de la session de test
	public static void beginSession (){
		factory		= Persistence.createEntityManagerFactory ("wsjpa_1127_jpa");
		manager		= factory.createEntityManager ();
		transaction	= manager.getTransaction ();
		transaction.begin ();
	}
	@AfterClass
	public static void endSession (){
		factory.close ();
	}
}
