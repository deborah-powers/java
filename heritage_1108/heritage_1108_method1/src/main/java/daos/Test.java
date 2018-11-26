package daos;

import paiements.Paiement;
import paiements.PaiementCb;
import paiements.PaiementCheque;

public class Test {

	public static void main(String[] args) {
		Paiement p = new Paiement();
		PaiementCb pcb = new PaiementCb();
		PaiementCheque pch = new PaiementCheque();
		Dao dao = new Dao();
		dao.add(p);
		dao.add(pcb);
		dao.add(pch);
		dao.close();
	}
}
