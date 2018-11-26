package paiements;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "paiement_jn")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type_paiement", length = 2, columnDefinition = "char(2)")
@DiscriminatorValue("PB")
public class Paiement implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE) // ? est-ce la bonne méthode
	protected int idPaiement;
	protected float montant;
	protected String iban;

	public Paiement() {
		super();
		montant = 10.0f;
		iban = "ABCD";
	}

	public int getIdPaiement() {
		return idPaiement;
	}

	public void setIdPaiement(int idPaiement) {
		this.idPaiement = idPaiement;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

}
