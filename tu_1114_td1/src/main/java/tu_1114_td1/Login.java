package tu_1114_td1;

import exceptions.ExceptionEmptyPassword;
import exceptions.ExceptionEmptyUser;

public class Login {
	private String username;
	private String password;

	public boolean isValid (String username, String password, String confirmation) throws ExceptionEmptyUser, ExceptionEmptyPassword{
		boolean result = true;
		if (username.length () == 0)
			throw new ExceptionEmptyUser ("Le nom d'utilisateur est requis");
		if (password.length () == 0)
			throw new ExceptionEmptyPassword ("Le mot de passe est requis");
		if (username.length () < 5)
			result = false;
		if (password != confirmation)
			result = false;
		return result;
	}
	public String getUsername (){
		return username;
	}
	public void setUsername (String username){
		this.username = username;
	}
	public String getPassword (){
		return password;
	}
	public void setPassword (String password){
		this.password = password;
	}
	public Login (){
		super ();
	}
	public Login (String username, String password){
		this.username = username;
		this.password = password;
	}
}
