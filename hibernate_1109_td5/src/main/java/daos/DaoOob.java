package daos;

import org.hibernate.query.Query;

import entities.Ooa;
import entities.Oob;

public class DaoOob extends Dao<Oob> {
	Dao<Ooa> daoa;
	public Oob findByA (int ida){
		Ooa ooa = daoa.find (ida);
		return findByA (ooa);
	}/*
		public void delete (int id, boolean delA){
		Oob oob = find (id);
		delete (oob, delA);
		}
		public void delete (Oob oob, boolean delA){
		if (delA) {
			daoa.delete (oob.getOoa ());
		}
		super.delete (oob);
		}*/
	@SuppressWarnings ("unchecked")
	public Oob findByA (Ooa ooa){
		Query<Oob> query = session.createQuery ("FROM Oob WHERE ooa=:ooa");
		query.setParameter ("ooa", ooa);
		Oob oob = query.getSingleResult ();
		return oob;
	}
	public DaoOob (){
		super (Oob.class);
		// daoa = new Dao<Ooa> (Ooa.class);
	}
}
