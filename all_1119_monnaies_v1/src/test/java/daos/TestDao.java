package daos;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entities.Monney;

public class TestDao {
	public ClassPathXmlApplicationContext	cpac;
	public DaoMonney						dao;

	private int nbMonneys (){
		List<Monney>	listMonney	= dao.findAll ();
		int				nbM			= listMonney.size ();
		return nbM;
	}
	private Monney find (String code){
		return dao.findByCode (code);
	}
	@Test
	public void testSuppression (){
		System.out.println ("test de suppression");
		Monney yen = dao.findByCode ("yen");
		dao.delete (yen);
		Assert.assertEquals ("suppression ratée", 2, nbMonneys ());
	}
	@Test
	public void testUpdate (){
		System.out.println ("test de modification");
		Monney euro = dao.findByCode ("eur");
		euro.setRate (1.5);
		dao.update (euro);
		Assert.assertEquals ("update ratée", 1.5, find ("eur").getRate (), 0.0);
	}
	@Test
	public void testCreation (){
		System.out.println ("test de création");
		Monney yen = new Monney ("yen", "yen", 0.2);
		dao.create (yen);
		Assert.assertEquals ("création ratée", 3, nbMonneys ());
	}
	@After
	public void close (){
		dao.close ();
		cpac.close ();
	}
	@Before
	public void open (){
		cpac	= new ClassPathXmlApplicationContext ("spring.xml");
		dao		= cpac.getBean (DaoMonney.class);
		dao.open ();
	}

}
