package daos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Monney;

public class DaoMonney {
	private SessionFactory	sessionFactory;
	private Session			session;
	private Transaction		tx;

	// crud
	public void delete (Monney monney){
		// vérifier si une devise avec le même code est ds la bdd
		Monney otherMonney = findByCode (monney.getCode ());
		if (otherMonney != null) session.delete (monney);
	}
	public void update (Monney monney){
		// vérifier si une devise avec le même code est ds la bdd
		Monney otherMonney = findByCode (monney.getCode ());
		if (otherMonney != null) session.merge (monney);
	}
	public void create (Monney monney){
		// vérifier si une devise avec le même code est ds la bdd
		Monney otherMonney = findByCode (monney.getCode ());
		if (otherMonney == null) session.persist (monney);
	}
	public Monney findByCode (String code){
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
	public void setSessionFactory (SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
}
