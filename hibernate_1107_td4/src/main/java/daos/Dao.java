package daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import models.Categorie;
import models.Client;
import models.Commande;
import models.CommandeProduit;
import models.CommandeProduitPK;
import models.Facture;
import models.Fournisseur;
import models.Livraison;
import models.Maire;
import models.Paiement;
import models.Pays;
import models.Produit;
import models.Utilisateur;
import models.Ville;

public class Dao {

	protected static SessionFactory sessionFactory;
	protected static Session session;

	public static void close() {
		session.close();
		sessionFactory.close();
	}

	public Dao() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Categorie.class);
		cfg.addAnnotatedClass(Client.class);
		cfg.addAnnotatedClass(Commande.class);
		cfg.addAnnotatedClass(CommandeProduit.class);
		cfg.addAnnotatedClass(CommandeProduitPK.class);
		cfg.addAnnotatedClass(Facture.class);
		cfg.addAnnotatedClass(Fournisseur.class);
		cfg.addAnnotatedClass(Livraison.class);
		cfg.addAnnotatedClass(Maire.class);
		cfg.addAnnotatedClass(Paiement.class);
		cfg.addAnnotatedClass(Pays.class);
		cfg.addAnnotatedClass(Produit.class);
		cfg.addAnnotatedClass(Utilisateur.class);
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
