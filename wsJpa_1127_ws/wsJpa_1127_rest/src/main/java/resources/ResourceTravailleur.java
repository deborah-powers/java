package resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import daos.DaoTravailleur;
import entites.Travailleur;
import errors.ErrorMessage;
import errors.ExceptionNotFound;

@Path ("travailleurs")
@Produces (MediaType.APPLICATION_JSON)
@Consumes (MediaType.APPLICATION_JSON)
public class ResourceTravailleur {
	private DaoTravailleur	dao;
	private String			url	= "http://localhost:8080/wsJpa_1127_rest/travailleurs/";

	@POST
	public void creer (Travailleur travailleur){
		dao.creer (travailleur);
	}
	@DELETE
	@Path ("{id}")
	public void supprimer (@PathParam ("id") Integer id){
		dao.supprimer (id);
	}
	@PUT
	@Path ("{id}")
	public void modifier (@PathParam ("id") Integer id, Travailleur travailleur){
		dao.modifier (travailleur);
	}
	@GET
	@Path ("{id}")
	public Travailleur recuperer (@PathParam ("id") Integer id){
		return trouverTravailleur (id);
	}
	@GET
	public List<Travailleur> lister (){
		List<Travailleur> tvList = dao.lister ();
		if (tvList == null) {
			ErrorMessage erreur = new ErrorMessage ("la liste de travailleurs n'a pas été récupée", url);
			throw new ExceptionNotFound (erreur);
		}
		else return tvList;
	}
	private Travailleur trouverTravailleur (Integer id){
		Travailleur travailleur = dao.recuperer (id);
		if (travailleur == null) {
			ErrorMessage erreur = new ErrorMessage ("le travailleur n°" + id + " n'est pas en bdd", url + id);
			throw new ExceptionNotFound (erreur);
		}
		else return travailleur;
	}
	public ResourceTravailleur (){
		dao = new DaoTravailleur ();
	}
}
