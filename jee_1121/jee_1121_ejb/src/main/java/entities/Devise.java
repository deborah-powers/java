package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Devise implements Serializable {
	private static final long	serialVersionUID	= 1L;
	@Id
	private String				code;
	private String				name;
	private double				rate;
	@OneToMany (mappedBy = "devise", fetch = FetchType.LAZY)
	@JsonIgnore // ignorer les infos des pays en récupérant la devise avec un service rest. évite les lazy-exception et les boucles infinies (quand pays a un champ devise)
	private List<Pays>			paysList;
	public String toString (){
		return "devise " + code + ", " + name;
	}
	public String getCode (){
		return code;
	}
	public void setCode (String code){
		this.code = code;
	}
	public String getName (){
		return name;
	}
	public void setName (String name){
		this.name = name;
	}
	public double getRate (){
		return rate;
	}
	public void setRate (double rate){
		this.rate = rate;
	}
	public List<Pays> getPaysList (){
		return paysList;
	}
	public void setPaysList (List<Pays> paysList){
		this.paysList = paysList;
	}
}
