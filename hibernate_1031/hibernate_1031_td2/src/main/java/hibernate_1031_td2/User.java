package hibernate_1031_td2;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Where;

@Entity
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
		@NamedQuery(name = "User.concatSimple", query = "SELECT CONCAT(prenom, ' ', nom), id FROM User u where login like 'p%'"),
		@NamedQuery(name = "User.concat", query = "SELECT CONCAT(prenom, ' ', nom), id FROM User u where login like :log") })
@Where(clause = "id_user <8") // on ne récupère jamais les éléments dont l'id >=8
@FilterDef(name = "profilFilter", parameters = { @ParamDef(name = "unProfil", type = "boolean") })
@Filter(name = "profilFilter", condition = "profil = :unProfil")
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
	@Formula("CONCAT(prenom, ' ', nom)")
	private String nomComplet;

	public String toString() {
		String message = "user n°" + idUser + ", " + prenom + " " + nom + ", " + login + " " + email + " " + password
				+ ", ";
		if (profil)
			message += "in list";
		else
			message += "not in list";
		return message;
	}

	public User(String prenom, String nom, String login, String email, String password, boolean profil) {
		super();
		this.email = email;
		this.login = login;
		this.nom = nom;
		this.password = password;
		this.prenom = prenom;
		this.profil = profil;
	}

	public User(String email, String login, String nom, String password, String prenom, boolean profil, int idUser) {
		this(prenom, nom, login, email, password, profil);
		this.idUser = idUser;
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

	public String getNomComplet() {
		return nomComplet;
	}

}