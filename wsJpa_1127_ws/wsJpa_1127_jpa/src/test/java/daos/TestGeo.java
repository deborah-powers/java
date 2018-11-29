package daos;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import entites.Geo;

public class TestGeo {
	// private static Dao<Geo> dao;
	private static DaoGeo	dao;
	private Geo				geo;
	private List<Geo>		geoList;

	@Test
	@Ignore
	public void recuperer (){
		geo = dao.recuperer (1);
		assertNotNull ("pb ds la récupération de la coordonnée n°" + 1, geo);
		boolean similitude = geo.getLatitude ().equals ("15.31");
		assertTrue ("mauvaise latitude", similitude);
	}
	@Test
	@Ignore
	public void lister (){
		geoList = dao.lister ();
		assertNotNull ("pb ds la récupération de la liste des coordonnées", geoList);
		int		nbGeo		= geoList.size ();
		boolean	similitude	= nbGeo == 2;
		assertTrue ("mauvaise liste", similitude);
	}
	@Test
	@Ignore
	public void creer (){
		geo = new Geo ();
		dao.creer (geo);
		geoList = dao.lister ();
		int		nbGeo		= geoList.size ();
		boolean	similitude	= nbGeo == 3;
		assertTrue ("insertion ratée", similitude);
	}
	@Test
	@Ignore
	public void modifier (){
		geo = dao.recuperer (1);
		geo.setLatitude ("15.33");
		dao.modifier (geo);
		Geo		geodeux		= dao.recuperer (1);
		boolean	similitude	= geodeux.getLatitude () == "15.33";
		assertTrue ("modification ratée", similitude);
	}
	@Test
	public void supprimer (){
		dao.supprimer (2);
		geoList = dao.lister ();
		int		nbGeo		= geoList.size ();
		boolean	similitude	= nbGeo == 1;
		assertTrue ("suppression ratée", similitude);
	}
	@Before
	public void beginSession (){
		dao = new DaoGeo ();
	}
	@After
	public void endSession (){
		dao.fermer ();
	}
}
