package client;

import java.util.List;

import models.Stagiaire;

public class Test {
	private static ClientStagiaire client;
	public static void main (String[] args){
		client = new ClientStagiaire ();
		Stagiaire		moi		= client.getOne (1);
		List<Stagiaire>	nous	= client.getAll ();
		System.out.println ("moi: " + moi);
		for (Stagiaire stagiaire : nous) System.out.println (stagiaire);
	}
}
