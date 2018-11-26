package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * The persistent class for the ville database table.
 * 
 */
@Entity
@NamedQuery(name = "Ville.findAll", query = "SELECT v FROM Ville v")
public class Ville implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_ville")
	private int idVille;

	@Column(name = "code_postal")
	private String codePostal;

	@Column(name = "id_maire")
	private int idMaire;

	private String nom;

	// uni-directional many-to-one association to Pays
	@ManyToOne
	@JoinColumn(name = "code_pays")
	private Pays pays;

	// uni-directional one-to-one association to Maire
	@OneToOne
	@JoinColumn(name = "id_ville")
	private Maire maire;

	public Ville() {
	}

	public int getIdVille() {
		return this.idVille;
	}

	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public int getIdMaire() {
		return this.idMaire;
	}

	public void setIdMaire(int idMaire) {
		this.idMaire = idMaire;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Pays getPay() {
		return this.pays;
	}

	public void setPay(Pays pays) {
		this.pays = pays;
	}

	public Maire getMaire() {
		return this.maire;
	}

	public void setMaire(Maire maire) {
		this.maire = maire;
	}

}