package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

/**
 * Entity implementation class for Entity: Country
 *
 */
@Entity
public class Pays {
	@Id
	private String	code;
	private String	name;
	private String	capitale;
	@JoinColumn (name = "devise")
	private String	devise;
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
	public String getCapitale (){
		return capitale;
	}

	public void setCapitale (String capitale){
		this.capitale = capitale;
	}
}
