package daos;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import entities.Devise;

@Stateless
@Local
public interface DaoDevise {
	public List<Devise> chercherDevises ();
	public Devise chercherParCode (String code);
}
