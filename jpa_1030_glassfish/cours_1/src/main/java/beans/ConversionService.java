package beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import dao.ConversionDao;
import models.Conversion;

@Named("conversion")
@SessionScoped
public class ConversionService implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ConversionDao dao;
	// private Conversion conv;
	private List<Conversion> history;

	public ConversionService() {
		history = dao.getHistory();
		System.out.println("history2 " + history);
	}

}
