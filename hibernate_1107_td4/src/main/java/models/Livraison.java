package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the livraison database table.
 * 
 */
@Entity
@NamedQuery(name="Livraison.findAll", query="SELECT l FROM Livraison l")
public class Livraison implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_livraison")
	private int idLivraison;

	@Temporal(TemporalType.DATE)
	@Column(name="date_livraison")
	private Date dateLivraison;

	@Column(name="id_facture")
	private int idFacture;

	private String mode;

	public Livraison() {
	}

	public int getIdLivraison() {
		return this.idLivraison;
	}

	public void setIdLivraison(int idLivraison) {
		this.idLivraison = idLivraison;
	}

	public Date getDateLivraison() {
		return this.dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public int getIdFacture() {
		return this.idFacture;
	}

	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}

	public String getMode() {
		return this.mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

}