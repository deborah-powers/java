package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the omb database table.
 * 
 */
@Entity
@NamedQuery (name = "Omb.findAll", query = "SELECT o FROM Omb o")
public class Omb implements Serializable {
	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int					id;

	private String				message;

	//uni-directional many-to-one association to Oma
	@ManyToOne
	@JoinColumn (name = "id_a")
	private Oma					oma;

	public Omb (){
		message = "omb";
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

	public Oma getOma (){
		return this.oma;
	}

	public void setOma (Oma oma){
		this.oma = oma;
	}

}