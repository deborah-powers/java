package services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

//@Stateless
public class Dao {
//	@PersistenceContext(name = "yaps-pet-store")
//	@Entity

	protected static final SessionFactory sessionFactory;
	protected static final Session session;

	static {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure()

				.build();
		try {
			sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
			session = sessionFactory.openSession();
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(serviceRegistry);
			e.printStackTrace();
			throw new IllegalStateException("Could not create SessionFactory");
		}
	}

	public void close() {
		session.close();
		sessionFactory.close();
	}

}
