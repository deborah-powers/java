package daos;

import java.util.List;

import org.hibernate.query.Query;

import models.Commande;
import models.CommandeProduit;
import models.CommandeProduitPK;
import models.Produit;

public class DaoCommandeProduit extends Dao {
	// supprimer des éléments
	public void supprimerParProduit(Produit prd) {
		List<CommandeProduit> cpList = trouverParProduit(prd);
		for (CommandeProduit cp : cpList)
			supprimer(cp);
	}

	public void supprimerParCommande(Commande cmd) {
		List<CommandeProduit> cpList = trouverParCommande(cmd);
		for (CommandeProduit cp : cpList)
			supprimer(cp);
	}

	public void supprimerParId(CommandeProduitPK id) {
		CommandeProduit cp = trouver(id);
		supprimer(cp);
	}

	private void supprimer(CommandeProduit cp) {
		if (cp != null) {
			// supprimer le CommandeProduitPK correspondant à ma commande
			DaoCommandeProduitPK daopk = new DaoCommandeProduitPK();
			CommandeProduitPK cmdId = cp.getId();
			int cppkId = cmdId.getIdCommande();
			daopk.supprimerParCommande(cppkId);
			session.getTransaction().begin();
			session.delete(cp);
			session.getTransaction().commit();
		}
	}

	// trouver des éléments
	@SuppressWarnings("unchecked")
	public List<CommandeProduit> trouverParProduit(Produit prd) {
		Query<CommandeProduit> cpQuery = session.createQuery("SELECT c FROM CommandeProduit c WHERE c.produit= :prd");
		cpQuery.setParameter("prd", prd);
		List<CommandeProduit> cpList = cpQuery.list();
		return cpList;
	}

	@SuppressWarnings("unchecked")
	public List<CommandeProduit> trouverParCommande(Commande cmd) {
		Query<CommandeProduit> cpQuery = session.createQuery("SELECT c FROM CommandeProduit c WHERE c.commande= :cmd");
		cpQuery.setParameter("cmd", cmd);
		List<CommandeProduit> cpList = cpQuery.list();
		return cpList;
	}

	public CommandeProduit trouver(CommandeProduitPK id) {
		CommandeProduit cmd = (CommandeProduit) session.get(CommandeProduit.class, id);
		return cmd;
	}

}
