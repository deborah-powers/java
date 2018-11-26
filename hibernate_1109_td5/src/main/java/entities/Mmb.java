package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the mmb database table.
 * 
 */
@Entity
@NamedQuery (name = "Mmb.findAll", query = "SELECT m FROM Mmb m")
public class Mmb implements Serializable {
	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int					id;

	private String				message;

	//uni-directional many-to-many association to Mma
	@ManyToMany
	@JoinTable (name = "mmab", joinColumns = { @JoinColumn (name = "id_b") }, inverseJoinColumns = { @JoinColumn (name = "id_a") })
	private List<Mma>			mmas;

	public Mmb (){
		message = "mmb";
	}

	public int getId (){
		return this.id;
	}

	public void setId (int id){
		this.id = id;
	}

	public String getMessage (){
		return this.message;
	}

	public void setMessage (String message){
		this.message = message;
	}

	public List<Mma> getMmas (){
		return this.mmas;
	}

	public void setMmas (List<Mma> mmas){
		this.mmas = mmas;
	}

}