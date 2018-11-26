package daos;

import java.util.List;

import org.hibernate.query.Query;

import models.CommandeProduitPK;

public class DaoCommandeProduitPK extends Dao {
	// supprimer des éléments
	public void supprimerParCommande(int idCommande) {
		List<CommandeProduitPK> cppkList = trouverParCommande(idCommande);
		for (CommandeProduitPK cppk : cppkList)
			supprimer(cppk);
	}

	public void supprimerParProduit(int idProduit) {
		List<CommandeProduitPK> cppkList = trouverParProduit(idProduit);
		for (CommandeProduitPK cppk : cppkList)
			supprimer(cppk);
	}

	private void supprimer(CommandeProduitPK cppk) {
		if (cppk != null) {
			session.getTransaction().begin();
			session.delete(cppk);
			session.getTransaction().commit();
		}
	}

	// trouver des éléments
	@SuppressWarnings("unchecked")
	public List<CommandeProduitPK> trouverParCommande(int idCommande) {
		Query<CommandeProduitPK> cppkQuery = session
				.createQuery("SELECT c FROM CommandeProduitPK c WHERE c.idCommande= :idc");
		cppkQuery.setParameter("idc", idCommande);
		List<CommandeProduitPK> cppkList = cppkQuery.list();
		return cppkList;
	}

	@SuppressWarnings("unchecked")
	public List<CommandeProduitPK> trouverParProduit(int idProduit) {
		Query<CommandeProduitPK> cppkQuery = session
				.createQuery("SELECT c FROM CommandeProduitPK c WHERE c.idProduit= :idp");
		cppkQuery.setParameter("idp", idProduit);
		List<CommandeProduitPK> cppkList = cppkQuery.list();
		return cppkList;
	}

	@SuppressWarnings("unchecked")
	public CommandeProduitPK trouver(int idProduit, int idCommande) {
		Query<CommandeProduitPK> cppkQuery = session
				.createQuery("SELECT c FROM CommandeProduitPK c WHERE c.idProduit= :idp AND c.idCommande= :idc");
		cppkQuery.setParameter("idp", idProduit);
		cppkQuery.setParameter("idc", idCommande);
		// au cas où plusieurs cppk auraient les mêmes identifiants
		List<CommandeProduitPK> cppkList = cppkQuery.list();
		CommandeProduitPK cppk = cppkList.get(0);
		return cppk;
	}
}
