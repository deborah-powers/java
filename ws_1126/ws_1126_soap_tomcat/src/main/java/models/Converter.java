package models;

import javax.jws.WebService;

@WebService (endpointInterface = "models.IConverter")
public class Converter implements IConverter {

	@Override
	public double cToF (double tmp){
		return (tmp + 32) * 9 / 5;
	}

	@Override
	public double fToC (double tmp){
		return (tmp - 32) * 5 / 9;
	}
}
