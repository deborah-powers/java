package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the commande_produit database table.
 * 
 */
@Embeddable
public class CommandeProduitPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_produit", insertable=false, updatable=false)
	private int idProduit;

	@Column(name="id_commande", insertable=false, updatable=false)
	private int idCommande;

	public CommandeProduitPK() {
	}
	public int getIdProduit() {
		return this.idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public int getIdCommande() {
		return this.idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CommandeProduitPK)) {
			return false;
		}
		CommandeProduitPK castOther = (CommandeProduitPK)other;
		return 
			(this.idProduit == castOther.idProduit)
			&& (this.idCommande == castOther.idCommande);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idProduit;
		hash = hash * prime + this.idCommande;
		
		return hash;
	}
}