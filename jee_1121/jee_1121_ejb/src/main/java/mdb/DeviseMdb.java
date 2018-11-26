package mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven (activationConfig = { @ActivationConfigProperty (propertyName = "destinationType", propertyValue = "javax.jms.Queue"), @ActivationConfigProperty (propertyName = "destination", propertyValue = "queue/devise") })
public class DeviseMdb implements MessageListener {
	@Override
	public void onMessage (Message message){
		System.out.println ("message: " + message);
	}
}
