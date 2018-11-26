package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import entities.Adress;
import entities.Customer;

@Stateless
public class DaoCustomer {
	@PersistenceContext(unitName = "yaps-pet-store")
	private EntityManager em;

	public void add(Customer customer, Adress adress) {
		em.persist(customer);
		em.persist(adress);
	}

	public Customer findById(int id) {
		return em.find(Customer.class, id);
	}

	public void remove(int id) {
//		em.getTransaction().begin();
		Customer customer = em.find(Customer.class, id);
		em.remove(customer);
//		em.getTransaction().commit();
	}

	public List<Customer> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		Root<Customer> usr = cq.from(Customer.class);
		TypedQuery<Customer> tq = em.createQuery(cq);
		return tq.getResultList();
	}

	public void update(Customer customer) {
		em.getTransaction().begin();
		em.merge(customer);
		em.getTransaction().commit();
	}

}
