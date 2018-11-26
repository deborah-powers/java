package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String city;
	private String street;
	/*
	 * @OneToMany private ArrayList<Utilisateur> utilisateurs;
	 */

	public Adress(String city, String street) {
		this.city = city;
		this.street = street;
	}

	public Adress() {
		this(null, null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}
