package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the ooa database table.
 * 
 */
@Entity
@NamedQuery (name = "Ooa.findAll", query = "SELECT o FROM Ooa o")
public class Ooa implements Serializable, Dummy {
	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int					id;
	private String				message;

	public String toString (){
		String printMessage = "ooa n°" + id + ": " + message;
		return printMessage;
	}
	public Ooa (){
		this ("ooa");
	}
	public Ooa (String message){
		this.message = message;
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

}