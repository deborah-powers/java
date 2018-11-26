package paiements;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "paiement_tpc_ch")
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
