package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Dao<Obj> {
	private static EntityManagerFactory	factory;
	// @PersistenceContext (unitName = "wsjpa_1127_jpa") // remplace factory dans une app tournant sur un serveur
	private EntityManager				manager;
	private EntityTransaction			transaction;
	private Class						classe;

	public void modifier (Obj obj){
		manager.merge (obj);
	}
	public void supprimer (Integer id){
		Obj obj = recuperer (id);
		supprimer (obj);
	}
	public void supprimer (Obj obj){
		manager.remove (obj);
	}
	public void creer (Obj obj){
		manager.persist (obj);
	}
	@SuppressWarnings ("unchecked")
	public Obj recuperer (Integer id){
		Obj result = (Obj) manager.find (classe, id);
		return result;
	}
	@SuppressWarnings ("unchecked")
	public List<Obj> lister (){
		// retrouver le nom de la classe
		String	nomClasse	= classe.getName ();
		int		posPoint	= nomClasse.indexOf ('.');
		posPoint	+= 1;
		nomClasse	= nomClasse.substring (posPoint);
		Query		requete	= manager.createNamedQuery (nomClasse + ".lister");
		List<Obj>	liste	= requete.getResultList ();
		return liste;
	}
	public Dao (Class classe){
		this.classe	= classe;
		factory		= Persistence.createEntityManagerFactory ("wsjpa_1127_jpa");
		manager		= factory.createEntityManager ();
		transaction	= manager.getTransaction ();
		transaction.begin ();
	}
	public void fermer (){
		transaction.commit ();
		manager.close ();
		factory.close ();
	}
}
