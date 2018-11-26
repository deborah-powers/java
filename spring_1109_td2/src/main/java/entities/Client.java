package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery (name = "Client.findAll", query = "SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column (name = "id_client")
	private int idClient;

	private String adresse;
	private String civilite;

	@Temporal (TemporalType.DATE)
	@Column (name = "date_naissance")
	private Date dateNaissance;

	private String nom;

	private String numero;

	private String prenom;

	//uni-directional many-to-one association to Ville
	@ManyToOne
	@JoinColumn (name = "id_ville")
	private Ville ville;
	public String toString (){
		String message = "Client n°" + idClient + " " + prenom + " " + nom;
		return message;
	}
	public Client (){}

	public int getIdClient (){
		return this.idClient;
	}

	public void setIdClient (int idClient){
		this.idClient = idClient;
	}

	public String getAdresse (){
		return this.adresse;
	}

	public void setAdresse (String adresse){
		this.adresse = adresse;
	}

	public String getCivilite (){
		return this.civilite;
	}

	public void setCivilite (String civilite){
		this.civilite = civilite;
	}

	public Date getDateNaissance (){
		return this.dateNaissance;
	}

	public void setDateNaissance (Date dateNaissance){
		this.dateNaissance = dateNaissance;
	}

	public String getNom (){
		return this.nom;
	}

	public void setNom (String nom){
		this.nom = nom;
	}

	public String getNumero (){
		return this.numero;
	}

	public void setNumero (String numero){
		this.numero = numero;
	}

	public String getPrenom (){
		return this.prenom;
	}

	public void setPrenom (String prenom){
		this.prenom = prenom;
	}

	public Ville getVille (){
		return this.ville;
	}

	public void setVille (Ville ville){
		this.ville = ville;
	}

}