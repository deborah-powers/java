package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * The persistent class for the oob database table.
 * 
 */
@Entity
@NamedQuery (name = "Oob.findAll", query = "SELECT o FROM Oob o")
public class Oob implements Serializable, Dummy {
	private static final long	serialVersionUID	= 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int					id;
	private String				message;
	/*
	@Column (name = "id_a", updatable = false, insertable = false)
	private int					idA;
	*/
	//uni-directional one-to-one association to Ooa
	@OneToOne (fetch = FetchType.LAZY, mappedBy = "oob", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	// @JoinColumn (name = "id_a", insertable = true, updatable = true, nullable = true)
	@JoinColumn (name = "id_a", nullable = false)
	private Ooa					ooa;

	public String toString (){
		String printMessage = "oob n°" + id + ": " + message + ", linked to " + ooa.toString ();
		return printMessage;
	}
	public Oob (){
		this (new Ooa ());
	}
	public Oob (Ooa ooa){
		this ("oob", ooa);
	}
	public Oob (String message){
		this (message, new Ooa ());
	}
	public Oob (String message, Ooa ooa){
		this.message	= message;
		this.ooa		= ooa;
		// this.idA		= ooa.getId ();
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

	public Ooa getOoa (){
		return this.ooa;
	}

	public void setOoa (Ooa ooa){
		this.ooa = ooa;
	}
	/*
	public int getIdA (){
		return idA;
	}
	public void setIdA (int idA){
		this.idA = idA;
	}*/

}