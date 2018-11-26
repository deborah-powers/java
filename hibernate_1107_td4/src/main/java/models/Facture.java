package models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the facture database table.
 * 
 */
@Entity
@NamedQuery(name = "Facture.findAll", query = "SELECT f FROM Facture f")
public class Facture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_facture")
	private int idFacture;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_facture")
	private Date dateFacture;

	@Column(name = "id_commande")
	private int idCommande;

	private String numero;

	// uni-directional one-to-one association to Paiement
	@OneToOne
	@JoinColumn(name = "id_paiement")
	private Paiement paiement;

	// uni-directional one-to-one association to Livraison
	@OneToOne
	@JoinColumn(name = "id_facture")
	private Livraison livraison;

	public Facture() {
	}

	public int getIdFacture() {
		return this.idFacture;
	}

	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}

	public Date getDateFacture() {
		return this.dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	public int getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Paiement getPaiement() {
		return this.paiement;
	}

	public void setPaiement1(Paiement paiement) {
		this.paiement = paiement;
	}

	public Livraison getLivraison() {
		return this.livraison;
	}

	public void setLivraison(Livraison livraison) {
		this.livraison = livraison;
	}

}