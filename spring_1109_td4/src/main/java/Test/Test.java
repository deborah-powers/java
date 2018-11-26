package Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
			Client client1 = clientRepository.findOneByNumeroV1 ("12347");
			System.out.println ("paramètre anonyme	" + client1);
			Client client2 = clientRepository.findOneByNumeroV2 ("12347");
			System.out.println ("paramètre nommé		" + client2);

			List<Client> clientList1 = clientRepository.findAllSortedByNomPrenom ();
			// je ne comprend pas comment le sort est effectué
			System.out.println ("liste de clients");
			for (Client client : clientList1) System.out.println ("	" + client);

			List<Client> clientList2 = clientRepository.findAllByNomAndDepartement ("dessard", "75");
			// je ne comprend pas comment le sort est effectué
			System.out.println ("liste de clients");
			for (Client client : clientList2) System.out.println ("	" + client);

			// fermer le contexte une fois que je n'ai plus besoin des objets
			ctxt.close ();
			System.out.println ("Done.");
		}
		catch (Exception e) {
			e.printStackTrace ();
		}
	}
}
