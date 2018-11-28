package errors;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class ExceptionNotFound extends WebApplicationException {
	private static final long serialVersionUID = 1L;

	public ExceptionNotFound (ErrorMessage error){
		super (Response.status (Status.NOT_FOUND).entity (error).type (MediaType.APPLICATION_JSON).build ());
	}

}
