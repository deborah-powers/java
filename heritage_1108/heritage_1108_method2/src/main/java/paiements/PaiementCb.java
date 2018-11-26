package paiements;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "paiement_tpc_cb")
public class PaiementCb extends Paiement {
	private static final long serialVersionUID = 1L;
	private String numero;
	private int code; // ode à 3 chiffre au dos
	private LocalDate dateExpiration;
	private String type;// Visa, CB, ...

	public PaiementCb() {
		super();
		numero = "0003";
		code = 377;
		dateExpiration = LocalDate.now().plusYears(1);
		type = "CB";
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public LocalDate getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(LocalDate dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
