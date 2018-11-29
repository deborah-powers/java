package entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import outils.OutilsJpa;

@Entity
@XmlRootElement (name = "entreprise")
@XmlAccessorType (value = XmlAccessType.FIELD)
@NamedQuery (name = "Entreprise.lister", query = "SELECT e FROM Entreprise e")
public class Entreprise implements Serializable {
	private static final long	serialVersionUID	= 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int					id;
	private String				nom;
	private String				activite;
	private String				slogan;

	@PrePersist // lancer la fonction avant une création dans la bdd
	@PreUpdate
	@PostLoad
	public void initData (){
		nom			= OutilsJpa.majuscule (nom);
		activite	= OutilsJpa.majuscule (activite);
		slogan		= OutilsJpa.majuscule (slogan);
	}
	@Override
	public String toString (){
		return "Entreprise [id=" + id + ", nom=" + nom + ", activite=" + activite + ", slogan=" + slogan + "]";
	}
	public Entreprise (){
		this ("Wold Compagny");
	}

	public Entreprise (String nom){
		this (nom, "immobilier", "random slogan");
	}

	public Entreprise (String nom, String activite, String slogan){
		this.nom		= nom;
		this.activite	= activite;
		this.slogan		= slogan;
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

	public String getActivite (){
		return activite;
	}

	public void setActivite (String activite){
		this.activite = activite;
	}

	public String getSlogan (){
		return slogan;
	}

	public void setSlogan (String slogan){
		this.slogan = slogan;
	}

	@Override
	public int hashCode (){
		final int	prime	= 31;
		int			result	= 1;
		result	= prime * result + ((activite == null) ? 0 : activite.hashCode ());
		result	= prime * result + id;
		result	= prime * result + ((nom == null) ? 0 : nom.hashCode ());
		result	= prime * result + ((slogan == null) ? 0 : slogan.hashCode ());
		return result;
	}

	@Override
	public boolean equals (Object obj){
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass () != obj.getClass ()) return false;
		Entreprise other = (Entreprise) obj;
		if (activite == null) {
			if (other.activite != null) return false;
		}
		else if (!activite.equals (other.activite)) return false;
		if (id != other.id) return false;
		if (nom == null) {
			if (other.nom != null) return false;
		}
		else if (!nom.equals (other.nom)) return false;
		if (slogan == null) {
			if (other.slogan != null) return false;
		}
		else if (!slogan.equals (other.slogan)) return false;
		return true;
	}
}
