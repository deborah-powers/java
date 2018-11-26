package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the oma database table.
 * 
 */
@Entity
@NamedQuery (name = "Oma.findAll", query = "SELECT o FROM Oma o")
public class Oma implements Serializable {
	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int					id;

	private String				message;

	public Oma (){
		message = "oma";
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