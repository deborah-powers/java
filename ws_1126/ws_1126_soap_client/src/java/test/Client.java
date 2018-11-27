package test;

import seller.ConverterService;
import seller.ConverterServiceLocator;
import seller.IConverter;

public class Client {
	public static void main (String[] args){
		try {
			ConverterService	service		= new ConverterServiceLocator ();
			IConverter			converter	= service.getConverterPort ();
			double				res			= converter.cToF (10.0);
			System.out.println (res);
			System.out.println ("publication ok");
		}
		catch (Exception e) {
			System.out.println ("publication nok");
			e.printStackTrace ();
		}
	}
}
