package models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the produit database table.
 * 
 */
@Entity
@NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_produit")
	private int idProduit;

	private String libelle;

	@Column(name = "prix_unitaire")
	private BigDecimal prixUnitaire;

	private String reference;

	// uni-directional many-to-one association to Fournisseur
	@ManyToOne
	@JoinColumn(name = "id_fournisseur", insertable = false, updatable = false)
	private Fournisseur fournisseur;

	// uni-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name = "id_categorie", insertable = false, updatable = false)
	private Categorie categorie;

	public Produit() {
	}

	public int getIdProduit() {
		return this.idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public BigDecimal getPrixUnitaire() {
		return this.prixUnitaire;
	}

	public void setPrixUnitaire(BigDecimal prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Fournisseur getFournisseur() {
		return this.fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}