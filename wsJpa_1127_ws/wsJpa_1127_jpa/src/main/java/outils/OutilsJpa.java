package outils;

import java.time.LocalDate;
import java.time.Period;

public class OutilsJpa {
	public static boolean vide (String mot){
		boolean wordSense = true;
		if (mot == null) wordSense = false;
		else if (mot.trim ().isEmpty ()) wordSense = false;
		return wordSense;
	}
	public static String majuscule (String mot){
		Character	initiale	= mot.charAt (0);
		String		queue		= mot.substring (1);
		String		nvMot		= Character.toUpperCase (initiale) + queue.toLowerCase ();
		return nvMot;
	}
	public static int calculAge (LocalDate naissance){
		LocalDate	maintenant	= LocalDate.now ();
		Period		ageTmp		= Period.between (naissance, maintenant);
		int			age			= ageTmp.getYears ();
		return age;
	}
}
