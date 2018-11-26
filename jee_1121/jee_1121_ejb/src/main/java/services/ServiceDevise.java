package services;

import java.util.List;

import javax.jws.WebService;

import entities.Devise;

@WebService
public interface ServiceDevise {
	public List<Devise> chercherDevises ();
	public Devise chercherParCode (String code);
	public double euroToFranc (double montant);
	public double francToEuro (double montant);
	public double convertir (double montant, String deviseSrc, String deviseDst);
}
