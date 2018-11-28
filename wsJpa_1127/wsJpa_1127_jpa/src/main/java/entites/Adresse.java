package entites;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import outils.OutilsJpa;

@Entity
@XmlRootElement (name = "adresse")
@XmlAccessorType (value = XmlAccessType.FIELD)
@NamedQuery (name = "Adresse.lister", query = "SELECT a FROM Adresse a")
public class Adresse implements Serializable {
	private static final long	serialVersionUID	= 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int					id;
	private String				numero;
	private String				voie;
	private String				ville;
	@Column (name = "code_postal")
	private String				codePostal;
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "geo")
	private Geo					geo;

	@PrePersist // lancer la fonction avant une création dans la bdd
	@PreUpdate
	@PostLoad
	public void initData (){
		voie		= OutilsJpa.majuscule (voie);
		ville		= OutilsJpa.majuscule (ville);
		numero		= numero.trim ().toLowerCase ();
		codePostal	= codePostal.trim ().toLowerCase ();
	}
	@Override
	public String toString (){
		return "Adresse [id=" + id + ", numero=" + numero + ", voie=" + voie + ", ville=" + ville + ", codePostal=" + codePostal + ", geo=" + geo + "]";
	}
	public Adresse (){
		this ("4", "rue des écoles", "Paris", "75005", new Geo ());
	}

	public Adresse (String numero, String voie, String ville, String codePostal, Geo geo){
		this.numero		= numero;
		this.voie		= voie;
		this.ville		= ville;
		this.codePostal	= codePostal;
		this.geo		= geo;
	}

	public int getId (){
		return id;
	}

	public void setId (int id){
		this.id = id;
	}

	public String getNumero (){
		return numero;
	}

	public void setNumero (String numero){
		this.numero = numero;
	}

	public String getVoie (){
		return voie;
	}

	public void setVoie (String voie){
		this.voie = voie;
	}

	public String getVille (){
		return ville;
	}

	public void setVille (String ville){
		this.ville = ville;
	}

	public String getCodePostal (){
		return codePostal;
	}

	public void setCodePostal (String codePostal){
		this.codePostal = codePostal;
	}

	public Geo getGeo (){
		return geo;
	}

	public void setGeo (Geo geo){
		this.geo = geo;
	}

	@Override
	public int hashCode (){
		final int	prime	= 31;
		int			result	= 1;
		result	= prime * result + ((codePostal == null) ? 0 : codePostal.hashCode ());
		result	= prime * result + ((geo == null) ? 0 : geo.hashCode ());
		result	= prime * result + id;
		result	= prime * result + ((numero == null) ? 0 : numero.hashCode ());
		result	= prime * result + ((ville == null) ? 0 : ville.hashCode ());
		result	= prime * result + ((voie == null) ? 0 : voie.hashCode ());
		return result;
	}
	@Override
	public boolean equals (Object obj){
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass () != obj.getClass ()) return false;
		Adresse other = (Adresse) obj;
		if (codePostal == null) {
			if (other.codePostal != null) return false;
		}
		else if (!codePostal.equals (other.codePostal)) return false;
		if (geo == null) {
			if (other.geo != null) return false;
		}
		else if (!geo.equals (other.geo)) return false;
		if (id != other.id) return false;
		if (numero == null) {
			if (other.numero != null) return false;
		}
		else if (!numero.equals (other.numero)) return false;
		if (ville == null) {
			if (other.ville != null) return false;
		}
		else if (!ville.equals (other.ville)) return false;
		if (voie == null) {
			if (other.voie != null) return false;
		}
		else if (!voie.equals (other.voie)) return false;
		return true;
	}

}
