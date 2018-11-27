package models;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

/* nécéssaires pour récupérer du xml
@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
*/
@JsonbPropertyOrder ({ "id", "nom", "age", "email" })
public class Stagiaire {
	private Integer	id;
	private String	nom;
	@JsonbProperty ("couriel")
	private String	email;
	private int		age;

	public Stagiaire (Integer id, String nom, String email, int age){
		this.id		= id;
		this.nom	= nom;
		this.email	= email;
		this.age	= age;
	}
	public Stagiaire (String nom, String email, int age){
		this (null, nom, email, age);
	}
	public Stagiaire (){
		this (null, null, 10);
	}
	public Integer getId (){
		return id;
	}
	public void setId (Integer id){
		this.id = id;
	}
	public String getNom (){
		return nom;
	}
	public void setNom (String nom){
		this.nom = nom;
	}
	public String getEmail (){
		return email;
	}
	public void setEmail (String email){
		this.email = email;
	}
	public int getAge (){
		return age;
	}
	public void setAge (int age){
		this.age = age;
	}
}
