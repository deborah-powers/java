package daos;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Devise;

@Stateless
@Local
@TransactionManagement (TransactionManagementType.CONTAINER)
public class DaoDeviseImpl implements DaoDevise {
	@PersistenceContext (unitName = "jee_1121_ejb")
	private EntityManager em;
	@Override
	@SuppressWarnings ("unchecked")
	public List<Devise> chercherDevises (){
		Query			query		= em.createQuery ("SELECT d FROM Devise d", Devise.class);
		List<Devise>	deviseList	= query.getResultList ();
		return deviseList;
	}
	@Override
	@SuppressWarnings ("unchecked")
	public Devise chercherParCode (String code){
		Query query = em.createQuery ("SELECT d FROM Devise d WHERE d.code=:code", Devise.class);
		query.setParameter ("code", code);
		// Devise devise = (Devise) query.getSingleResult ();
		List<Devise>	deviseList	= query.getResultList ();
		Devise			devise		= null;
		if (deviseList.size () > 0) devise = deviseList.get (0);
		return devise;
	}
}
