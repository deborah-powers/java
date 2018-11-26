package exceptions;

public class ExceptionEmptyPassword extends Exception {
	static final long serialVersionUID = 1L;

	public ExceptionEmptyPassword (String message){
		super (message);
	}

}
