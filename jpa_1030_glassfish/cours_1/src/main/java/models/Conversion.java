package models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

@Entity
public class Conversion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private LocalDate date;
	private Double valueEuro;
	@Transient
	private Double valueFranc;

	public void toFranc() {
		valueFranc = valueEuro * 6.559;
	}

	public void toEuro() {
		valueEuro = valueFranc / 6.559;
	}

	@PostLoad
	private void initDatas() {
		toFranc();
	}

	public Conversion() {
		this(LocalDate.now());
	}

	public Conversion(LocalDate date) {
		super();
		this.date = date;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getValueEuro() {
		return valueEuro;
	}

	public void setValueEuro(double valueEuro) {
		this.valueEuro = valueEuro;
	}

	public double getValueFranc() {
		return valueFranc;
	}

	public void setValueFranc(double valueFranc) {
		this.valueFranc = valueFranc;
	}

	public int getId() {
		return id;
	}

	public void setValueEuro(Double valueEuro) {
		this.valueEuro = valueEuro;
	}

	public void setValueFranc(Double valueFranc) {
		this.valueFranc = valueFranc;
	}
}
