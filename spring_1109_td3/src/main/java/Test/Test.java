package Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import configuration.CfgRepo;
import entities.Client;
import repository.ClientRepository;

public class Test {

	public static void main (String[] args){
		try {
			System.out.println ("Début ….");
			// le contexte, qui contient les objets, se base sur ma classe de configuration
			AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext (CfgRepo.class);
			// l'interface repository, qui appelle les fonctions de JpaRepository
			ClientRepository clientRepository = ctxt.getBean (ClientRepository.class);
			// retrouver un client grâce aux fonctions de l'interface
			Client client = clientRepository.findById (4).orElse (null);
			System.out.println (client);
			final List<Client> clients = clientRepository.findByNomStartingWith ("D", new Sort (Direction.DESC, "nom"));
			System.out.println (clients);
			// fermer le contexte une fois que je n'ai plus besoin des objets
			ctxt.close ();
			System.out.println ("Done.");
		}
		catch (Exception e) {
			e.printStackTrace ();
		}
	}
}
