package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ville database table.
 * 
 */
@Entity
@NamedQuery(name="Ville.findAll", query="SELECT v FROM Ville v")
public class Ville implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ville")
	private String idVille;

	@Column(name="code_pays")
	private String codePays;

	@Column(name="code_postal")
	private String codePostal;

	@Column(name="id_maire")
	private int idMaire;

	private String nom;

	public Ville() {
	}

	public String getIdVille() {
		return this.idVille;
	}

	public void setIdVille(String idVille) {
		this.idVille = idVille;
	}

	public String getCodePays() {
		return this.codePays;
	}

	public void setCodePays(String codePays) {
		this.codePays = codePays;
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

}