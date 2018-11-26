package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pays database table.
 * 
 */
@Entity
@Table(name="pays")
@NamedQuery(name="Pays.findAll", query="SELECT p FROM Pays p")
public class Pays implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="code_pays")
	private String codePays;

	private String nom;

	public Pays() {
	}

	public String getCodePays() {
		return this.codePays;
	}

	public void setCodePays(String codePays) {
		this.codePays = codePays;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}