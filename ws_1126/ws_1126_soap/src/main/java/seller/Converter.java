package seller;

import javax.jws.WebService;

@WebService (endpointInterface = "seller.IConverter")
public class Converter implements IConverter {

	@Override
	public double cToF (double tmp){
		return 32 + tmp * 9 / 5;
	}

	@Override
	public double fToC (double tmp){
		return tmp * 5 / 9 - 32;
	}
	public Converter (){}
}
