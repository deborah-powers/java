package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@NamedQuery (name = "Country.findAll", query = "SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long	serialVersionUID	= 1L;

	@Id
	private String				code;
	private String				capital;
	private String				name;
	private int					population;
	//uni-directional many-to-one association to Monney
	@ManyToOne
	@JoinColumn (name = "monney")
	private Monney				monney;

	public Country (){}

	public String getCode (){
		return this.code;
	}

	public void setCode (String code){
		this.code = code;
	}

	public String getCapital (){
		return this.capital;
	}

	public void setCapital (String capital){
		this.capital = capital;
	}

	public String getName (){
		return this.name;
	}

	public void setName (String name){
		this.name = name;
	}

	public int getPopulation (){
		return this.population;
	}

	public void setPopulation (int population){
		this.population = population;
	}

	public Monney getMonney (){
		return this.monney;
	}

	public void setMonney (Monney monney){
		this.monney = monney;
	}

}