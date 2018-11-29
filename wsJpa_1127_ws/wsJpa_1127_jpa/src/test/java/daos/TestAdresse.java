package daos;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import entites.Adresse;

public class TestAdresse {
	private static DaoAdresse	dao;
	private Adresse				adresse;
	private List<Adresse>		adresseList;
	private Adresse				adresseRef;

	@Test
	@Ignore
	public void recuperer (){
		adresse = dao.recuperer (3);
		assertNotNull ("récupération de l'entité n°" + 3 + ", objet nulle", adresse);
		assertNotNull ("récupération de l'entité n°" + 3 + ", Geo nulle", adresse.getGeo ());
		System.out.println ("entité récupérée: " + adresse);
		boolean similitude = equals (adresse, adresseRef);
		assertTrue ("récupération de l'entité n°" + 3 + ", mauvais objet", similitude);
	}
	@Test
	@Ignore
	public void lister (){
		adresseList = dao.lister ();
		assertNotNull ("récupération de la liste des entités, liste nulle", adresseList);
		int		nbAdresse	= adresseList.size ();
		boolean	similitude	= nbAdresse == 1;
		assertTrue ("récupération de la liste des entités, mauvaise liste", similitude);
	}
	@Test
	@Ignore
	public void creer (){
		adresse = new Adresse ();
		dao.creer (adresse);
		adresseList = dao.lister ();
		int		nbAdresse	= adresseList.size ();
		boolean	similitude	= nbAdresse == 2;
		assertTrue ("insertion ratée", similitude);
	}
	@Test
	@Ignore
	public void modifier (){
		adresse = dao.recuperer (1);
		adresse.setCodePostal ("77210");
		dao.modifier (adresse);
		Adresse	adresseBis	= dao.recuperer (1);
		boolean	similitude	= adresseBis.getCodePostal () == "77210";
		assertTrue ("modification de l'entité n°" + 1, similitude);
	}
	@Test
	public void supprimer (){
		dao.supprimer (5);
		adresseList = dao.lister ();
		int		nbAdresse	= adresseList.size ();
		boolean	similitude	= nbAdresse == 2;
		assertTrue ("suppression de l'entité n°" + 5, similitude);
	}
	public boolean equals (Adresse adresse1, Adresse adresse2){
		boolean similitude = false;
		if (toStringNoId (adresse1) == toStringNoId (adresse2)) similitude = true;
		System.out.println ("similitude: " + similitude);
		return similitude;
	}
	public String toStringNoId (Adresse adresse){
		return "Adresse [numero=" + adresse.getNumero () + ", voie=" + adresse.getVoie () + ", ville=" + adresse.getVille () + ", codePostal=" + adresse.getCodePostal () + ", geo= (" + adresse.getGeo ().getLatitude () + ","
			+ adresse.getGeo ().getLongitude () + ")]";
	}
	@Before
	public void beginSession (){
		dao			= new DaoAdresse ();
		adresseRef	= new Adresse ();
		System.out.println ("référence: " + adresseRef);
	}
	@After
	public void endSession (){
		dao.fermer ();
	}
}
