package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import entities.Product;

@Stateless
public class DaoProduct {
	@PersistenceContext(unitName = "yaps-pet-store")
	private EntityManager em;

	public void update(Product product) {
		em.getTransaction().begin();
		em.merge(product);
		em.getTransaction().commit();
	}

	public void add(Product product) {
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
	}

	public void remove(int id) {
		Product product = em.find(Product.class, id);
		em.getTransaction().begin();
		em.remove(product);
		em.getTransaction().commit();
	}

	public Product findById(int id) {
		return em.find(Product.class, id);
	}

	public List<Product> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		TypedQuery<Product> tq = em.createQuery(cq);
		return tq.getResultList();
	}
}
