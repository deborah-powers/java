package models;

public class User {
	/*
	private Integer id;
	private String prenom;
	private String civilite;
	private String pays;
	private String description;
	private boolean inMailingList;
	private String password;
	private String role;
	*/

	private String name;
	private String email;
	private int age;
	public String toString (){
		String message = "Je suis " + name + ", j'ai " + age + " ans. Mon couriel est " + email;
		return message;
	}

	public String getName (){
		return name;
	}
	public void setName (String name){
		this.name = name;
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
