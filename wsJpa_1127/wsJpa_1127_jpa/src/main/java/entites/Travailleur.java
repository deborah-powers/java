package entites;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import outils.AdaptateurLocalDate;
import outils.OutilsJpa;

@Entity
@XmlRootElement (name = "travailleur")
@XmlAccessorType (value = XmlAccessType.FIELD)
@NamedQuery (name = "Travailleur.lister", query = "SELECT t FROM Travailleur t")
public class Travailleur implements Serializable {
	private static final long	serialVersionUID	= 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int					id;
	private String				nom;
	private String				prenom;
	private String				couriel;
	@XmlJavaTypeAdapter (AdaptateurLocalDate.class) // classe à créer
	private LocalDate			naissance;
	@Transient
	private int					age;
	@ManyToOne (cascade = CascadeType.PERSIST)
	@JoinColumn (name = "adresse")
	private Adresse				adresse;
	private String				telephone;
	@Column (name = "site")
	private String				siteWeb;
	@ManyToOne (cascade = CascadeType.PERSIST)
	@JoinColumn (name = "entreprise")
	private Entreprise			entreprise;

	@PrePersist // lancer la fonction avant une création dans la bdd
	@PreUpdate
	@PostLoad
	public void initData (){
		nom		= OutilsJpa.majuscule (nom);
		prenom	= OutilsJpa.majuscule (prenom);
		couriel	= couriel.trim ().toLowerCase ();
		age		= OutilsJpa.calculAge (naissance);
	}

	@Override
	public String toString (){
		return "Travailleur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", naissance=" + naissance + ", age=" + age + ", adresse=" + adresse + ", entreprise=" + entreprise + "]";
	}

	public Travailleur (){
		this ("Deborah", "Powers", LocalDate.now (), new Adresse (), "d@gmail", "0600000000", "http://deborah-powers.fr/", new Entreprise ());
	}

	public Travailleur (String prenom, String nom, LocalDate naissance, Adresse adresse, String couriel, String telephone, String siteWeb, Entreprise entreprise){
		this.nom		= OutilsJpa.majuscule (nom);
		this.prenom		= OutilsJpa.majuscule (prenom);
		this.couriel	= couriel.trim ().toLowerCase ();
		this.naissance	= naissance;
		this.adresse	= adresse;
		this.telephone	= telephone;
		this.siteWeb	= siteWeb;
		this.entreprise	= entreprise;
		this.age		= OutilsJpa.calculAge (naissance);
	}
	public int getId (){
		return id;
	}

	public void setId (int id){
		this.id = id;
	}

	public String getNom (){
		return nom;
	}

	public void setNom (String nom){
		this.nom = nom;
	}

	public String getPrenom (){
		return prenom;
	}

	public void setPrenom (String prenom){
		this.prenom = prenom;
	}

	public String getCouriel (){
		return couriel;
	}

	public void setCouriel (String couriel){
		this.couriel = couriel;
	}

	public LocalDate getNaissance (){
		return naissance;
	}

	public void setNaissance (LocalDate naissance){
		this.naissance = naissance;
	}

	public int getAge (){
		return age;
	}

	public void setAge (int age){
		this.age = age;
	}

	public Adresse getAdresse (){
		return adresse;
	}

	public void setAdresse (Adresse adresse){
		this.adresse = adresse;
	}

	public String getTelephone (){
		return telephone;
	}

	public void setTelephone (String telephone){
		this.telephone = telephone;
	}

	public String getSiteWeb (){
		return siteWeb;
	}

	public void setSiteWeb (String siteWeb){
		this.siteWeb = siteWeb;
	}

	public Entreprise getEntreprise (){
		return entreprise;
	}

	public void setEntreprise (Entreprise entreprise){
		this.entreprise = entreprise;
	}

	@Override
	public int hashCode (){
		final int	prime	= 31;
		int			result	= 1;
		result	= prime * result + ((adresse == null) ? 0 : adresse.hashCode ());
		result	= prime * result + age;
		result	= prime * result + ((couriel == null) ? 0 : couriel.hashCode ());
		result	= prime * result + ((entreprise == null) ? 0 : entreprise.hashCode ());
		result	= prime * result + id;
		result	= prime * result + ((naissance == null) ? 0 : naissance.hashCode ());
		result	= prime * result + ((nom == null) ? 0 : nom.hashCode ());
		result	= prime * result + ((prenom == null) ? 0 : prenom.hashCode ());
		result	= prime * result + ((siteWeb == null) ? 0 : siteWeb.hashCode ());
		result	= prime * result + ((telephone == null) ? 0 : telephone.hashCode ());
		return result;
	}

	@Override
	public boolean equals (Object obj){
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass () != obj.getClass ()) return false;
		Travailleur other = (Travailleur) obj;
		if (adresse == null) {
			if (other.adresse != null) return false;
		}
		else if (!adresse.equals (other.adresse)) return false;
		if (age != other.age) return false;
		if (couriel == null) {
			if (other.couriel != null) return false;
		}
		else if (!couriel.equals (other.couriel)) return false;
		if (entreprise == null) {
			if (other.entreprise != null) return false;
		}
		else if (!entreprise.equals (other.entreprise)) return false;
		if (id != other.id) return false;
		if (naissance == null) {
			if (other.naissance != null) return false;
		}
		else if (!naissance.equals (other.naissance)) return false;
		if (nom == null) {
			if (other.nom != null) return false;
		}
		else if (!nom.equals (other.nom)) return false;
		if (prenom == null) {
			if (other.prenom != null) return false;
		}
		else if (!prenom.equals (other.prenom)) return false;
		if (siteWeb == null) {
			if (other.siteWeb != null) return false;
		}
		else if (!siteWeb.equals (other.siteWeb)) return false;
		if (telephone == null) {
			if (other.telephone != null) return false;
		}
		else if (!telephone.equals (other.telephone)) return false;
		return true;
	}
}
