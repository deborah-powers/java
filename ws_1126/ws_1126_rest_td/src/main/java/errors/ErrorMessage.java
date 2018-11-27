package errors;

import javax.ws.rs.core.Response.Status;

// reconnue automatiquement par json-b
public class ErrorMessage {
	private String	code;
	private String	description;
	private String	url;
	private Status	status;

	public ErrorMessage (String code, String description, String url, Status status){
		this.code			= code;
		this.description	= description;
		this.url			= url;
		this.status			= status;
	}
	public String getCode (){
		return code;
	}
	public void setCode (String code){
		this.code = code;
	}
	public String getDescription (){
		return description;
	}
	public void setDescription (String description){
		this.description = description;
	}
	public String getUrl (){
		return url;
	}
	public void setUrl (String url){
		this.url = url;
	}
	public Status getStatus (){
		return status;
	}
	public void setStatus (Status status){
		this.status = status;
	}
}
