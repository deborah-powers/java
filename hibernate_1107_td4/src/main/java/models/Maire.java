package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the maire database table.
 * 
 */
@Entity
@NamedQuery(name="Maire.findAll", query="SELECT m FROM Maire m")
public class Maire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_maire")
	private int idMaire;

	@Column(name="id_ville")
	private java.math.BigInteger idVille;

	private String nom;

	private String prenom;

	public Maire() {
	}

	public int getIdMaire() {
		return this.idMaire;
	}

	public void setIdMaire(int idMaire) {
		this.idMaire = idMaire;
	}

	public java.math.BigInteger getIdVille() {
		return this.idVille;
	}

	public void setIdVille(java.math.BigInteger idVille) {
		this.idVille = idVille;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}