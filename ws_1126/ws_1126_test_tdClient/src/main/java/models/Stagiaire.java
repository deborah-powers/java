package models;

public class Stagiaire {
	private Integer	id;
	private String	nom;
	private String	couriel;
	private int		age;

	@Override
	public String toString (){
		return "Stagiaire [id=" + id + ", nom=" + nom + ", email=" + couriel + ", age=" + age + "]";
	}
	public Stagiaire (Integer id, String nom, String email, int age){
		this.id			= id;
		this.nom		= nom;
		this.couriel	= email;
		this.age		= age;
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
	public int getAge (){
		return age;
	}
	public void setAge (int age){
		this.age = age;
	}
	public String getCouriel (){
		return couriel;
	}
	public void setCouriel (String couriel){
		this.couriel = couriel;
	}
}
