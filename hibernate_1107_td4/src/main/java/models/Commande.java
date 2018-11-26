package models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the commande database table.
 * 
 */
@Entity
@NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_commande")
	private int idCommande;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_commande")
	private Date dateCommande;

	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;

	private String numero;

	public String toString() {
		String message = "commande n°" + idCommande + ", passée le " + dateCommande + " par " + client.toStringRecap();
		return message;
	}

	public Commande() {
	}

	public int getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return this.dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Client geClient() {
		return this.client;
	}

	public void setIdClient(Client client) {
		this.client = client;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}