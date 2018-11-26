package tests;

import java.util.List;

import daos.Dao;
import daos.DaoOob;
import entities.Ooa;
import entities.Oob;

public class Test {
	public static void main (String[] args){
		oob ();
	}
	public static void oob (){
		DaoOob dao = new DaoOob ();
		oobCreate (dao);
		dao.close ();
	}
	public static void oobDelete (DaoOob dao){
		// dao.delete (4);
		dao.delete (2);
	}
	public static void oobFind (DaoOob dao){
		Oob oob = dao.find (3);
		System.out.println (oob);
		System.out.println (oob.getOoa ());
	}
	public static void oobCreate (Dao<Oob> dao){
		Oob oob = new Oob ();
		dao.create (oob);
	}
	public static void ooa (){
		Dao<Ooa> dao = new Dao<Ooa> (Ooa.class);
		ooaAll (dao);
		dao.close ();
	}
	public static void ooaAll (Dao<Ooa> dao){
		List<Ooa> looa = dao.list ();
		for (Ooa ooa : looa) System.out.println (ooa);
	}
	public static void ooaUpdate (Dao<Ooa> dao){
		Ooa ooa = dao.find (14);
		ooa.setMessage ("ooa n°" + ooa.getId ());
		dao.update (ooa);
	}
	public static void ooaDelete (Dao<Ooa> dao){
		dao.delete (13);
	}
	public static void ooaFind (Dao<Ooa> dao){
		Ooa ooa = dao.find (4);
		System.out.println (ooa);
	}
	public static void ooaCreate (Dao<Ooa> dao){
		Ooa ooa = new Ooa ();
		dao.create (ooa);
	}
}
