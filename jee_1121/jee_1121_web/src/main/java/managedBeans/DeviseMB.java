package managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import entities.Devise;
import services.ServiceDevise;

@ManagedBean // jsf
@RequestScoped // SessionScoped
public class DeviseMB {
	private List<Devise>	deviseList;
	private Devise			devise;
	@EJB // injection de dépendence, initialisation automatique à partir de DSImpl. spring.Autowired, cdi.Inject
	private ServiceDevise	serviceDevise;
	private double			montantEuro;
	private double			montantFranc;

	public String update (){
		// serviceDevise.update (devise);
		// TODO créer update
		return "deviseList";
	}
	public String select (Devise devise){
		this.devise	= devise;
		deviseList	= serviceDevise.chercherDevises ();
		return "deviseUpdate";
	}
	public String recupererDevises (){
		deviseList = serviceDevise.chercherDevises ();
		return null;
	}
	public String convertEuroToFranc (){
		montantFranc = serviceDevise.euroToFranc (montantEuro);
		return null; // rester sur la même page
	}
	@PostConstruct
	public void init (){
		deviseList	= serviceDevise.chercherDevises ();
		devise		= deviseList.get (0);
	}
	public List<Devise> getDeviseList (){
		return deviseList;
	}
	public void setDeviseList (List<Devise> deviseList){
		this.deviseList = deviseList;
	}
	public double getMontantEuro (){
		return montantEuro;
	}
	public void setMontantEuro (double montantEuro){
		this.montantEuro = montantEuro;
	}
	public double getMontantFranc (){
		return montantFranc;
	}
	public void setMontantFranc (double montantFranc){
		this.montantFranc = montantFranc;
	}
	public Devise getDevise (){
		return devise;
	}
	public void setDevise (Devise devise){
		this.devise = devise;
	}

}
