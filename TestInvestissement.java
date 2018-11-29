final class Investissement {
	private float tauxCroissance = 1.013f;
	private float tauxPrelevement = 1-0.03f;
	private int ajoutDepart = prelevement (5000);
	private int ajoutAnnuel = prelevement (6000);
	int dureeAnnees = 30;

	public void setTauxCroissance (float taux){
		// taux est un nb à virgule
		if (taux >=0){
			if (taux <=1) taux +=1;
			tauxCroissance = taux;
		}
	}
	public void setTauxPrelevement (float taux){
		// taux est un nb à virgule
		if (taux <1 && taux >-1){
			if (taux <0) taux +=1;
			else taux = 1- taux;
			tauxPrelevement = taux;
		}
	}
	public void setAjoutAnnuel (int ajout){
		ajoutAnnuel = prelevement (ajout);
	}

	private int prelevement (int montant){
		montant *= tauxPrelevement;
		return montant;
	}
	private int croissanceTauxNul(){
		int montantFinal = ajoutDepart;
		for (int an=0; an< dureeAnnees; an++){
			montantFinal += ajoutAnnuel;
		}
		return montantFinal;
	}
	private int croissance (int nbAnnees){
		int montantFinal = ajoutDepart;
		for (int an=0; an< nbAnnees; an++){
			montantFinal += ajoutAnnuel;
			montantFinal *= tauxCroissance;
		}
		return montantFinal;
	}
	public int croissance(){
		int montantFinal = croissance (dureeAnnees);
		return montantFinal;
	}
	public void gainDuTaux(){
		int gainTauxNul = croissanceTauxNul();
		int gainTaux = croissance();
		int gain = gainTaux - gainTauxNul;
		float taux = tauxCroissance -1;
		System.out.println ("gain au bout de "+ dureeAnnees +" ans avec un taux d'interet de "+ taux +": "+ gain);
	}
	public void gainAnnuel(){
		int montantAvantDerniereAnnee = croissance (dureeAnnees -1);
		int montantDerniereAnnee = montantAvantDerniereAnnee + ajoutAnnuel;
		montantDerniereAnnee *= tauxCroissance;
		int gainAnnuel = montantDerniereAnnee - montantAvantDerniereAnnee;
		float taux = tauxCroissance -1;
		System.out.println ("gain annuel au bout de "+ dureeAnnees +" avec un taux de "+ taux +": "+ gainAnnuel);
	}
}
public class TestInvestissement{
	public static void main (String[] args) {
		Investissement invest = new Investissement();
		invest.setTauxCroissance (0.04f);
		invest.setTauxPrelevement (8000);
		invest.gainAnnuel();
		invest.gainDuTaux();
	}
}