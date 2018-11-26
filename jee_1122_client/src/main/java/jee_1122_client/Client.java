package jee_1122_client;

import java.util.Properties;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

/*
connection vers la file deviseQueue de wildfly
y envoyer un message pour déclencher un traitement en différé de mdb/DeviseMdb
*/
public class Client {

	public static void main (String[] args){
		Properties jndiProps = new Properties ();
		jndiProps.put (Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		// jndiProps.put (Context.PROVIDER_URL, "remote://localhost:8080");
		jndiProps.put (Context.PROVIDER_URL, "http-remoting://localhost:8080");
		jndiProps.put (Context.SECURITY_PRINCIPAL, "admin");
		jndiProps.put (Context.SECURITY_CREDENTIALS, "pwd");
		try {
			Context					ic		= new InitialContext (jndiProps);
			QueueConnectionFactory	factory	= (QueueConnectionFactory) ic.lookup ("jms/RemoteConnectionFactory");
			Queue					queue	= (Queue) ic.lookup ("jms/queue/devise");
			QueueConnection			cnn		= factory.createQueueConnection (jndiProps.getProperty (Context.SECURITY_PRINCIPAL), jndiProps.getProperty (Context.SECURITY_CREDENTIALS));
			QueueSession			session	= cnn.createQueueSession (false, QueueSession.AUTO_ACKNOWLEDGE);
			TextMessage				msg		= session.createTextMessage ();
			msg.setText ("<msg>message in the bottle</msg>");
			QueueSender sender = session.createSender (queue);
			sender.send (msg);
			System.out.println ("Message sent successfully to remote queue.");
		}
		catch (Exception e) {
			e.printStackTrace ();
		}
	}
}
