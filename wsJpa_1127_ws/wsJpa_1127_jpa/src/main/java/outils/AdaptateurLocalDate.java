package outils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AdaptateurLocalDate extends XmlAdapter<String, LocalDate> {
	DateTimeFormatter formatteur = DateTimeFormatter.ofPattern ("yyyy-mm-dd");

	@Override
	public LocalDate unmarshal (String date) throws Exception{
		return LocalDate.parse (date, formatteur);
	}

	@Override
	public String marshal (LocalDate date) throws Exception{
		return date.format (formatteur);
	}

}
