package paiements;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CH")
public class PaiementCheque extends Paiement implements Serializable {
	private static final long serialVersionUID = 1L;
	private String numero;
	private LocalDate dateSignature;

	public PaiementCheque() {
		super();
		numero = "0003";
		dateSignature = LocalDate.now();
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getDateSignature() {
		return dateSignature;
	}

	public void setDateSignature(LocalDate dateSignature) {
		this.dateSignature = dateSignature;
	}

}
