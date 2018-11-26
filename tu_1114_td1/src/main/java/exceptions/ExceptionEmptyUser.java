package exceptions;

public class ExceptionEmptyUser extends Exception {
	static final long serialVersionUID = 1L;
	public ExceptionEmptyUser (String message){
		super (message);
	}
}
