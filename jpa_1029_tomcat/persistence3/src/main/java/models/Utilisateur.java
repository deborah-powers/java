package models;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

// classe à transformer en table de ma bdd
@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String prenom;
	// l'âge ne sera pas stoqué en bdd
	@Transient
	private int age;
	private LocalDate naissance;
	private String mdp;
	// une adresse peut corespondre à plusieurs personnes
	// création d'un champ adresse_id
	@ManyToOne(cascade = CascadeType.ALL)
	private Adress adresse;

	// méthode de rappel. des trucs qui causent des erreurs si ds le constructeur
	@PostLoad
	private void initDatas() {
		Period period = Period.between(naissance, LocalDate.now());
		age = period.getYears();
	}

	public Utilisateur(String prenom, LocalDate naissance, Adress adresse, String mdp) {
		super();
		this.prenom = prenom;
		this.naissance = naissance;
		this.mdp = mdp;
		this.adresse = adresse;
	}

	public Utilisateur() {
		this(null, null, null, null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Adress getAdresse() {
		return adresse;
	}

	public void setAdresse(Adress adresse) {
		this.adresse = adresse;
	}
}
