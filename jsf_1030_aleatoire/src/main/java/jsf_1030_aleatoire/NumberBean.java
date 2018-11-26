package jsf_1030_aleatoire;

public class NumberBean {
	private String strGuessed;
	private int nbRandom;
	private int nbGuessed;
	private String message;
	private static int nbGuess;

	private String computeResponse() {
		int nbGuessed = Integer.parseInt(strGuessed);
		if (nbGuessed == nbRandom) {
			message = "Vous avez retrouvé le nombre";
			return "result";
		} else if (nbGuess > 2) {
			message = "Vous avez manqué le nombre";
			return "result";
		} else if (nbGuessed > nbRandom) {
			message = "Votre nombre est trop grand";
			nbGuess++;
			return null;
		} else if (nbGuessed < nbRandom) {
			message = "Votre nombre est trop petit";
			nbGuess++;
			return null;
		} else {
			nbGuess++;
			return null;
		}
	}

	public NumberBean() {
		super();
		double nbTmp = Math.random() * 10;
		nbRandom = (int) nbTmp;
	}

	public String getStrGuessed() {
		return strGuessed;
	}

	public void setStrGuessed(String strGuessed) {
		this.strGuessed = strGuessed;
	}

	public int getNbRandom() {
		return nbRandom;
	}

	public void setNbRandom(int nbRandom) {
		this.nbRandom = nbRandom;
	}

	public int getNbGuessed() {
		return nbGuessed;
	}

	public void setNbGuessed(int nbGuessed) {
		this.nbGuessed = nbGuessed;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static int getNbGuess() {
		return nbGuess;
	}

	
	public void setNbGuess(int nbGuess) {
		this.nbGuess = nbGuess;
	}

}
