package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the paiement database table.
 * 
 */
@Entity
@NamedQuery(name="Paiement.findAll", query="SELECT p FROM Paiement p")
public class Paiement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_paiement")
	private int idPaiement;

	@Temporal(TemporalType.DATE)
	@Column(name="date_paiement")
	private Date datePaiement;

	@Column(name="id_facture")
	private int idFacture;

	@Column(name="type_paiement")
	private String typePaiement;

	public Paiement() {
	}

	public int getIdPaiement() {
		return this.idPaiement;
	}

	public void setIdPaiement(int idPaiement) {
		this.idPaiement = idPaiement;
	}

	public Date getDatePaiement() {
		return this.datePaiement;
	}

	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}

	public int getIdFacture() {
		return this.idFacture;
	}

	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}

	public String getTypePaiement() {
		return this.typePaiement;
	}

	public void setTypePaiement(String typePaiement) {
		this.typePaiement = typePaiement;
	}

}