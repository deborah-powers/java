package client;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import models.Stagiaire;

public class ClientStagiaire {
	private Client	client	= ClientBuilder.newClient ();
	private String	url		= "http://localhost:8080/ws_1126_rest_td/rest/stagiaires/";
	public Stagiaire getOne (Integer id){
		Stagiaire stagiaire = client.target (url).path (String.valueOf (id)).request (MediaType.APPLICATION_JSON).get (Stagiaire.class);
		return stagiaire;
	}
	@SuppressWarnings ("unchecked")
	public List<Stagiaire> getAll (){
		List<Stagiaire>	stagiaireList	= new ArrayList<Stagiaire> ();
		List<HashMap>	mapList			= client.target (url).request (MediaType.APPLICATION_JSON).get (List.class);
		for (Map protoStagiaire : mapList) {
			BigDecimal	idTmp	= (BigDecimal) protoStagiaire.get ("id");
			Integer		id		= idTmp.intValueExact ();
			String		nom		= (String) protoStagiaire.get ("nom");
			String		email	= (String) protoStagiaire.get ("couriel");
			BigDecimal	ageTmp	= (BigDecimal) protoStagiaire.get ("age");
			int			age		= ageTmp.intValueExact ();
			stagiaireList.add (new Stagiaire (id, nom, email, age));
		}
		return stagiaireList;
	}
}
