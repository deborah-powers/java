package tests;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import daos.DaoMonney;
import entities.Monney;

class UseDao {
	public ClassPathXmlApplicationContext	cpac;
	public DaoMonney						dao;

	public void testFindAll (){
		List<Monney> monneyList = dao.findAll ();
		for (Monney monney : monneyList) System.out.println (monney);
	}
	public void testDelete (){
		Monney dollar = dao.findByCode ("dol");
		dao.delete (dollar);
	}

	public void testUpdate (){
		Monney euro = dao.findByCode ("eur");
		euro.setRate (0.6);
		dao.update (euro);
	}
	public void testSave (){
		Monney	dollar	= new Monney ("dol", "dollar", 1);
		Monney	euro	= new Monney ("eur", "euro", 1.5);
		dao.create (dollar);
		dao.create (euro);
	}
	public void close (){
		dao.close ();
		cpac.close ();
	}
	public UseDao (){
		cpac	= new ClassPathXmlApplicationContext ("spring.xml");
		dao		= cpac.getBean (DaoMonney.class);
		dao.open ();
	}
}

public class Test {
	public static void main (String[] args){
		UseDao ud = new UseDao ();
		ud.testSave ();
		ud.testFindAll ();
		ud.close ();
	}

}
