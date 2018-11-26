package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the ville database table.
 * 
 */
@Entity

@NamedQueries({ @NamedQuery(name = "Ville.getAll", query = "SELECT v FROM Ville v"),
		@NamedQuery(name = "Ville.getByCc", query = "SELECT v FROM Ville v WHERE v.codeCommune= :cc") })

public class Ville implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "code_commune")
	private String codeCommune;
	@Column(name = "code_postal")
	private String codePostal;
	@Column(name = "coordonnees_gps")
	private String coordonneesGps;
	private String libelle_acheminement;
	@Column(name = "ligne_5")
	private String ligne5;
	private String nom;

	public String toString() {
		String message = "Ville de " + nom + ",	cp " + codePostal + ",	index " + codeCommune + ",	";
		if (ligne5.equals(""))
			message += "pas sur la ligne 5";
		else
			message += "arrêt " + ligne5;
		return message;
	}

	public Ville() {
	}

	public String getCodeCommune() {
		return this.codeCommune;
	}

	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getCoordonneesGps() {
		return this.coordonneesGps;
	}

	public void setCoordonneesGps(String coordonneesGps) {
		this.coordonneesGps = coordonneesGps;
	}

	public String getLibelle_acheminement() {
		return this.libelle_acheminement;
	}

	public void setLibelle_acheminement(String libelle_acheminement) {
		this.libelle_acheminement = libelle_acheminement;
	}

	public String getLigne5() {
		return this.ligne5;
	}

	public void setLigne5(String ligne5) {
		this.ligne5 = ligne5;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}