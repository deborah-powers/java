package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ResourceConfig;

import models.Stagiaire;

@Path ("stagiaires")
//@Produces (MediaType.APPLICATION_XML)
// besoin d'une librairie pour le json, jersey-media-json-binding
@Produces (MediaType.APPLICATION_JSON)
@Consumes (MediaType.APPLICATION_JSON)
/*
http://localhost:8080/app/rest/stagiaires
*/
public class RestStagiaire extends ResourceConfig {
	private static Map<Integer, Stagiaire>	dbStagiaire;
	private static AtomicInteger			idCompteur;
	static {
		dbStagiaire	= new HashMap<Integer, Stagiaire> ();
		idCompteur	= new AtomicInteger ();
		Stagiaire deborah = new Stagiaire (idCompteur.incrementAndGet (), "Deborah", "d@gmail.com", 21);
		dbStagiaire.put (deborah.getId (), deborah);
		Stagiaire anne = new Stagiaire (idCompteur.incrementAndGet (), "anne", "d@gmail.com", 21);
		dbStagiaire.put (anne.getId (), anne);
	}
	@DELETE
	@Path ("{ id }")
	public void delete (@PathParam ("id") Integer id){
		dbStagiaire.remove (id);
	}
	@PUT
	@Path ("{ id }")
	public void update (@PathParam ("id") Integer id, Stagiaire stagiaire){
		dbStagiaire.put (id, stagiaire);
	}
	@POST
	public void create (Stagiaire stagiaire){
		Integer id = idCompteur.incrementAndGet ();
		stagiaire.setId (id);
		dbStagiaire.put (id, stagiaire);
	}
	@GET
	@Path ("{ id }")
	public Stagiaire getOne (@PathParam ("id") Integer id){
		Stagiaire stagiaire = dbStagiaire.get (id);
		return stagiaire;
	}
	@GET // accessible via une requête get
	public List<Stagiaire> getAll (){
		return new ArrayList<Stagiaire> (dbStagiaire.values ());
	}
}
