package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery (name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_user")
	private int id;
	private String email;
	private String login;
	private String nom;
	private String password;
	private String prenom;
	private boolean profil;

	public User (){}
	public int getId (){
		return this.id;
	}
	public void setId (int id){
		this.id = id;
	}
	public String getEmail (){
		return this.email;
	}
	public void setEmail (String email){
		this.email = email;
	}
	public String getLogin (){
		return this.login;
	}
	public void setLogin (String login){
		this.login = login;
	}
	public String getNom (){
		return this.nom;
	}
	public void setNom (String nom){
		this.nom = nom;
	}
	public String getPassword (){
		return this.password;
	}
	public void setPassword (String password){
		this.password = password;
	}
	public String getPrenom (){
		return this.prenom;
	}
	public void setPrenom (String prenom){
		this.prenom = prenom;
	}
	public boolean getProfil (){
		return this.profil;
	}
	public void setProfil (boolean profil){
		this.profil = profil;
	}
}