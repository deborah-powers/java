package daos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import entities.Monney;

public class DaoMonney {
	@Autowired
	private SessionFactory	sessionFactory;
	private Session			session;
	private Transaction		tx;
	// find by field
	public Monney findByName (String name){
		Query query = session.createQuery ("FROM Monney WHERE name=:name");
		query.setParameter ("name", name);
		List<Monney>	monneyList	= query.getResultList ();
		Monney			monney		= null;
		if (monneyList.size () > 0) monney = monneyList.get (0);
		return monney;
	}
	// crud
	public void delete (Monney monney){
		// vérifier si une devise avec le même code est ds la bdd
		Monney otherMonney = findOne (monney.getCode ());
		if (otherMonney != null) session.delete (monney);
	}
	public void update (Monney monney){
		// vérifier si une devise avec le même code est ds la bdd
		Monney otherMonney = findOne (monney.getCode ());
		if (otherMonney != null) session.merge (monney);
	}
	public void create (Monney monney){
		// vérifier si une devise avec le même code est ds la bdd
		Monney otherMonney = findOne (monney.getCode ());
		if (otherMonney == null) session.persist (monney);
	}
	public Monney findOne (String code){
		Query query = session.createQuery ("FROM Monney WHERE code=:code");
		query.setParameter ("code", code);
		List<Monney>	monneyList	= query.getResultList ();
		Monney			monney		= null;
		if (monneyList.size () > 0) monney = monneyList.get (0);
		return monney;
	}
	public List<Monney> findAll (){
		Query			query		= session.createQuery ("FROM Monney");
		List<Monney>	monneyList	= query.getResultList ();
		return monneyList;
	}
	public void close (){
		tx.commit ();
		session.close ();
	}
	public void open (){
		session	= sessionFactory.openSession ();
		tx		= session.beginTransaction ();
	}
}
