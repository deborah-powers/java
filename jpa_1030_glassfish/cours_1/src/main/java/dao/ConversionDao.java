package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import models.Conversion;

@Stateless
public class ConversionDao {
	@PersistenceContext(unitName = "cours_1")
	private EntityManager em;

	public List<Conversion> getHistory() {
		Query query = em.createQuery("SELECT e FROM Conversion e");
		List<Conversion> history = (List<Conversion>) query.getResultList();
		System.out.println("historique " + history);
		return history;
	}

	public void setConversion(Conversion conv) {
		em.persist(conv);
	}
}
