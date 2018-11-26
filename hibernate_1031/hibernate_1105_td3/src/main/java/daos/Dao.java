package daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import model.Ville;

public class Dao {

	protected static SessionFactory sessionFactory;
	protected static Session session;

	public List<Ville> getByNom(String nom) {
		// SQLQuery<Ville> villeQuery = session.createSQLQuery("SELECT * FROM Ville
		// where nom='" + nom + "'");
		// villeQuery.addEntity(Ville.class);
		Query<Ville> villeQuery = session.createQuery("FROM Ville v where v.nom LIKE :nom", Ville.class);
		villeQuery.setParameter("nom", "%" + nom + "%");
		List<Ville> villeList = villeQuery.getResultList();
		return villeList;
	}

	public List<Ville> getByDpt(String departement) {
		Query<Ville> villeQuery = session.createQuery("SELECT v FROM Ville v where v.codePostal LIKE :dpt",
				Ville.class);
		villeQuery.setParameter("dpt", departement + "___");
		List<Ville> villeList = villeQuery.getResultList();
		return villeList;
	}

	public List<Ville> getByCp(String codePostal) {
		Query<Ville> villeQuery = session.createQuery("SELECT v FROM Ville v where v.codePostal= :cp", Ville.class);
		villeQuery.setParameter("cp", codePostal);
		List<Ville> villeList = villeQuery.getResultList();
		return villeList;
	}

	public Ville getByCc(String codeCommune) {
		Ville ville = (Ville) session.get(Ville.class, codeCommune);
		return ville;
	}

	public static void close() {
		session.close();
		sessionFactory.close();
	}

	public Dao() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Ville.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
				.build();
		try {
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
			session = sessionFactory.openSession();
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(serviceRegistry);
			e.printStackTrace();
			throw new IllegalStateException("Could not create SessionFactory");
		}
	}
}
