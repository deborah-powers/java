package jsf_1026_calculatrice;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "calcul")
@RequestScoped
public class ManagerOperation {
	private String nb1;
	private String nb2;
	private double res;

	public void add() {
		double nbDb1 = convert(nb1);
		double nbDb2 = convert(nb2);
		res = nbDb1 + nbDb2;
	}

	public void sub() {
		double nbDb1 = convert(nb1);
		double nbDb2 = convert(nb2);
		res = nbDb1 - nbDb2;
	}

	public void mul() {
		double nbDb1 = convert(nb1);
		double nbDb2 = convert(nb2);
		res = nbDb1 * nbDb2;
	}

	public void divide() {
		double nbDb1 = convert(nb1);
		double nbDb2 = convert(nb2);
		res = nbDb1 / nbDb2;
	}

	private double convert(String nbStr) {
		double nbDb = Double.parseDouble(nbStr);
		return nbDb;
	}

	public ManagerOperation() {
		nb1 = "4";
		nb2 = "3";
	}

	public String getNb1() {
		return nb1;
	}

	public void setNb1(String nb1) {
		this.nb1 = nb1;
	}

	public String getNb2() {
		return nb2;
	}

	public void setNb2(String nb2) {
		this.nb2 = nb2;
	}

	public double getRes() {
		return res;
	}

	public void setRes(double res) {
		this.res = res;
	}
}
