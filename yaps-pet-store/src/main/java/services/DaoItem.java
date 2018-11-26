package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import entities.Item;

@Stateless
public class DaoItem {
	@PersistenceContext(unitName = "yaps-pet-store")
	private EntityManager em;

	public void update(Item item) {
		em.getTransaction().begin();
		em.merge(item);
		em.getTransaction().commit();
	}

	public void add(Item item) {
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
	}

	public void remove(int id) {
		Item item = em.find(Item.class, id);
		em.getTransaction().begin();
		em.remove(item);
		em.getTransaction().commit();
	}

	public Item findById(int id) {
		return em.find(Item.class, id);
	}

	public List<Item> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Item> cq = cb.createQuery(Item.class);
		TypedQuery<Item> tq = em.createQuery(cq);
		return tq.getResultList();
	}
}
