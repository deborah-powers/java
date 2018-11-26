package daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import entities.Dummy;
import entities.Ooa;
import entities.Oob;

public class Dao<Item extends Dummy> {
	protected static SessionFactory	sessionFactory;
	protected static Session		session;
	protected Class					classItem;

	public void update (Item obj){
		int id = obj.getId ();
		if (id > 0) session.update (obj);
	}
	public Item create (Item obj){
		int id = (int) session.save (obj);
		obj.setId (id);
		/*
		int id = obj.getId ();
		if (id == 0) {
			id = (int) session.save (obj);
			obj.setId (id);
		}*/
		return obj;
	}
	public void delete (int id){
		Item obj = find (id);
		if (obj != null) session.delete (obj);
	}
	public void delete (Item obj){
		session.delete (obj);
		/*
		Item otherObj = find (obj.getId ());
		if (otherObj != null) session.delete (obj);
		*/
	}
	@SuppressWarnings ("unchecked")
	public Item find (int id){
		Item obj = (Item) session.get (classItem, id);
		return obj;
	}
	@SuppressWarnings ("unchecked")
	public List<Item> list (){
		// retrouver le nom de la classe
		String	className	= classItem.getName ();
		int		dotPos		= className.indexOf ('.');
		dotPos		+= 1;
		className	= className.substring (dotPos);
		Query<Item>	query	= session.createNamedQuery (className + ".findAll");
		List<Item>	list	= query.list ();
		return list;
	}

	public void close (){
		session.getTransaction ().commit ();
		session.close ();
		sessionFactory.close ();
	}

	public Dao (Class classItem){
		this.classItem = classItem;
		Configuration cfg = new Configuration ();
		cfg.configure ();
		cfg.addAnnotatedClass (Ooa.class);
		cfg.addAnnotatedClass (Oob.class);
		/*
		cfg.addAnnotatedClass (Oma.class);
		cfg.addAnnotatedClass (Omb.class);
		cfg.addAnnotatedClass (Mma.class);
		cfg.addAnnotatedClass (Mmb.class);
		*/
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder ().applySettings (cfg.getProperties ()).build ();
		try {
			sessionFactory	= cfg.buildSessionFactory (serviceRegistry);
			session			= sessionFactory.openSession ();
			session.getTransaction ().begin ();
		}
		catch (Exception e) {
			StandardServiceRegistryBuilder.destroy (serviceRegistry);
			e.printStackTrace ();
			throw new IllegalStateException ("Could not create SessionFactory");
		}
	}
}
