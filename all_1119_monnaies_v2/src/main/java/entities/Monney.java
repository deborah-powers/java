package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the monney database table.
 * 
 */
@Entity
@NamedQuery (name = "Monney.findAll", query = "SELECT m FROM Monney m")
public class Monney implements Serializable {
	private static final long	serialVersionUID	= 1L;

	@Id
	private String				code;
	private String				name;
	private double				rate;
	public double convert (Monney otherMonney){
		// convertir otherMonney en monney
		double rateConvertion = otherMonney.getRate () / rate;
		return rateConvertion;
	}
	public String toString (){
		String message = "code: " + code + "\tname: " + name + "\tdollar change: " + rate;
		return message;
	}
	public Monney (String code, String name, double rate){
		this.code	= code;
		this.name	= name;
		this.rate	= rate;
	}

	public Monney (){
		this (null, null, 0.0);
	}

	public String getCode (){
		return this.code;
	}

	public void setCode (String code){
		this.code = code;
	}

	public String getName (){
		return this.name;
	}

	public void setName (String name){
		this.name = name;
	}

	public double getRate (){
		return this.rate;
	}

	public void setRate (double rate){
		this.rate = rate;
	}

}