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

@Entity
@XmlRootElement (name = "geo")
@XmlAccessorType (value = XmlAccessType.FIELD)
@NamedQuery (name = "Geo.lister", query = "SELECT g FROM Geo g")
public class Geo implements Serializable {
	private static final long	serialVersionUID	= 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer				id;
	private String				latitude;
	private String				longitude;

	@PrePersist // lancer la fonction avant une création dans la bdd
	@PreUpdate
	@PostLoad
	public void initData (){
		latitude	= latitude.trim ().toLowerCase ();
		longitude	= longitude.trim ().toLowerCase ();
	}
	@Override
	public String toString (){
		return "Geo [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	public Geo (){
		this ("15.31", "95.1");
	}
	public Geo (String latitude, String longitude){
		this.latitude	= latitude;
		this.longitude	= longitude;
	}

	public Integer getId (){
		return id;
	}

	public void setId (Integer id){
		this.id = id;
	}

	public String getLatitude (){
		return latitude;
	}

	public void setLatitude (String latitude){
		this.latitude = latitude;
	}

	public String getLongitude (){
		return longitude;
	}

	public void setLongitude (String longitude){
		this.longitude = longitude;
	}
	@Override
	public int hashCode (){
		final int	prime	= 31;
		int			result	= 1;
		result	= prime * result + id;
		result	= prime * result + ((latitude == null) ? 0 : latitude.hashCode ());
		result	= prime * result + ((longitude == null) ? 0 : longitude.hashCode ());
		return result;
	}
	@Override
	public boolean equals (Object obj){
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass () != obj.getClass ()) return false;
		Geo other = (Geo) obj;
		if (id != other.id) return false;
		if (latitude == null) {
			if (other.latitude != null) return false;
		}
		else if (!latitude.equals (other.latitude)) return false;
		if (longitude == null) {
			if (other.longitude != null) return false;
		}
		else if (!longitude.equals (other.longitude)) return false;
		return true;
	}
}
