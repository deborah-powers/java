
public class Adress {
	int numero;
	String rue;
	String ville;

	public String toString(){
		return numero +" rue "+ rue +", "+ ville;
	}
	public void setNumero (int numero){ this.numero = numero; }
	public void setRue (String rue){ this.rue = rue; }
	public void setVille (String ville){ this.ville = ville; }
	public int getNumero(){ return numero; }
	public String getRue(){ return rue; }
	public String getVille(){ return ville; }
	public Adress(){
		numero =70;
		rue = "Mouffetard";
		ville = "Paris";
	}
}
