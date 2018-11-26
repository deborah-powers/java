package seller;

import javax.xml.ws.Endpoint;

public class Publisher {

	public static void main (String[] args){
		String url = "http://localhost:4701/ws/converter";
		try {
			Endpoint.publish (url, new Converter ());
			System.out.println ("publication ok");
		}
		catch (Exception e) {
			System.out.println ("publication nok");
			e.printStackTrace ();
		}
		// rechercher http://localhost:4701/ws/converter?wsdl
	}

}
