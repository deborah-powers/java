package jpa_1107;

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
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int idUser;
	private String email;
	private String login;
	private String nom;
	private String password;
	private String prenom;
	private boolean profil;

	public String toString() {
		String message = "user n°" + idUser + ", " + prenom + " " + nom + ", " + login + " " + email + " " + password
				+ ", ";
		if (profil)
			message += "in list";
		else
			message += "not in list";
		return message;
	}

	public User(String email, String login, String nom, String password, String prenom, boolean profil) {
		super();
		this.email = email;
		this.login = login;
		this.nom = nom;
		this.password = password;
		this.prenom = prenom;
		this.profil = profil;
	}

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public boolean getProfil() {
		return this.profil;
	}

	public void setProfil(boolean profil) {
		this.profil = profil;
	}

}