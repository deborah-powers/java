package daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Dao {
	protected static final SessionFactory sessionFactory;
	protected static final Session session;
	static {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); // ou bien simplement cfg.configure()
		cfg.addResource("User.hbm.xml"); // ligne spécifique de la méthode
		// sr choppe mes infos et les mets dans la fabrique
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

	public static void close() {
		session.close();
		sessionFactory.close();
	}
}
