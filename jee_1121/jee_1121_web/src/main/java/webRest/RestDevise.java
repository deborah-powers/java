package webRest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import entities.Devise;
import services.ServiceDevise;

// http://localhost:8080/jee_1121_web/restApp/devises
@Path ("/devise")
@Produces ("application/json")
public class RestDevise {
	@Inject // serviceDevise est un ejb. EJB est trop vieux pour être pris en compte par rest
	private ServiceDevise serviceDevise;
	@GET
	// http://localhost:8080/jee_1121_web/restApp/devises/codeDv
	@Path ("/{codeDev}")
	public Devise getDeviseByCode (@PathParam ("codeDev") String code){
		/*
		Devise devise = new Devise ();
		devise.setCode (code);
		devise.setName ("name-" + code);
		devise.setRate (0.5);
		*/
		Devise devise = serviceDevise.chercherParCode (code);
		System.out.println ("devise: " + devise);
		return devise; // avec produce, devise est un objet json
	}
}
