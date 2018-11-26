package models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the commande_produit database table.
 * 
 */
@Entity
@Table(name = "commande_produit")
@NamedQuery(name = "CommandeProduit.findAll", query = "SELECT c FROM CommandeProduit c")
public class CommandeProduit implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CommandeProduitPK id;

	@Column(name = "prix_unitaire")
	private BigDecimal prixUnitaire;

	private int quantite;

	@Column(name = "taux_remise")
	private int tauxRemise;

	// uni-directional many-to-one association to Commande
	@ManyToOne
	@JoinColumn(name = "id_commande", insertable = false, updatable = false)
	private Commande commande;

	// uni-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name = "id_produit", insertable = false, updatable = false)
	private Produit produit;

	public CommandeProduit() {
	}

	public CommandeProduitPK getId() {
		return this.id;
	}

	public void setId(CommandeProduitPK id) {
		this.id = id;
	}

	public BigDecimal getPrixUnitaire() {
		return this.prixUnitaire;
	}

	public void setPrixUnitaire(BigDecimal prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getTauxRemise() {
		return this.tauxRemise;
	}

	public void setTauxRemise(int tauxRemise) {
		this.tauxRemise = tauxRemise;
	}

	public Commande getCommande() {
		return this.commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}