package daos;

import java.util.List;

import org.hibernate.query.Query;

import models.Commande;

public class DaoCommande extends Dao {
	public void test() {
		System.out.println("je suis le test");
		Commande cmd1 = trouver(2);
		System.out.println("1) " + cmd1);
		cmd1.setNumero("00003");
		// modifier(cmd1);
		supprimer(1);
		// Commande cmd2 = new Commande();
		// System.out.println("2) " + cmd2.getNumero());
		// Commande cmd3 = add(cmd2);
		// System.out.println("2) " + cmd2);
	}

	// crud + get all

	public Commande ajouter(Commande cmd) {
		int id = cmd.getIdCommande();
		if (id == 0) {
			session.getTransaction().begin();
			id = (int) session.save(cmd);
			cmd.setIdCommande(id);
			session.getTransaction().commit();
		}
		return cmd;
	}

	public void modifier(Commande cmd) {
		int id = cmd.getIdCommande();
		if (id > 0) {
			session.getTransaction().begin();
			session.update(cmd);
			session.getTransaction().commit();
		}
	}

	public void supprimer(int id) {
		Commande cmd = trouver(id);
		if (cmd != null) {
			// supprimer les CommandeProduit correspondant à ma commande
			DaoCommandeProduit daocp = new DaoCommandeProduit();
			daocp.supprimerParCommande(cmd);
			session.getTransaction().begin();
			session.delete(cmd);
			session.getTransaction().commit();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Commande> lister() {
		Query<Commande> cmdQuery = session.createNamedQuery("Commande.findAll");
		List<Commande> cmdList = cmdQuery.list();
		return cmdList;
	}

	public Commande trouver(int id) {
		Commande cmd = (Commande) session.get(Commande.class, id);
		return cmd;
	}

}
