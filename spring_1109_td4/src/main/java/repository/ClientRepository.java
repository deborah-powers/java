package repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	public List<Client> findByNomStartingWith (String nom, Sort ordreTri);
	public List<Client> findAllSortedByNomPrenom ();
	// paramètre anonyme
	public Client findOneByNumeroV1 (String numero);
	// paramètre nommé
	public Client findOneByNumeroV2 (@Param ("numero") String numero);
	public List<Client> findAllByNomAndDepartement (@Param ("nom") String nom, @Param ("codeDep") String codeDepartement);
	/* requête simple directement écrite ds l'interface
	en cas de surcharge, c'est la version de l'interface qui l'emporte
	 */
	@Query ("FROM Client")
	public List<Client> getAll ();
}
