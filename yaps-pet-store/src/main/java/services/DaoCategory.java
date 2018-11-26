package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import entities.Category;

@Stateless
public class DaoCategory {
	@PersistenceContext(unitName = "yaps-pet-store")
	private EntityManager em;

	public void update(Category category) {
		em.getTransaction().begin();
		em.merge(category);
		em.getTransaction().commit();
	}

	public void add(Category category) {
		em.getTransaction().begin();
		em.persist(category);
		em.getTransaction().commit();
	}

	public void remove(int id) {
		Category Category = em.find(Category.class, id);
		em.getTransaction().begin();
		em.remove(Category);
		em.getTransaction().commit();
	}

	public Category findById(int id) {
		return em.find(Category.class, id);
	}

	public List<Category> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Category> cq = cb.createQuery(Category.class);
		TypedQuery<Category> tq = em.createQuery(cq);
		return tq.getResultList();
	}
}
