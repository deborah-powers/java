package models;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IConverter {
	@WebMethod
	public double cToF (double tmp);
	@WebMethod
	public double fToC (double tmp);
}
