package services;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.Timer;
import javax.jws.WebParam;
import javax.jws.WebService;

import daos.DaoDevise;
import entities.Devise;

@Stateless
@Local
@WebService (endpointInterface = "services.ServiceDevise")
public class ServiceDeviseImpl implements ServiceDevise {
	private static final double	coeff	= 6.559;
	@EJB
	// @Inject
	private DaoDevise			dao;
	private List<Devise>		deviseListInCache;

	// @Schedule (second = "0,15", minute = "*", hour = "*")
	public void executionPeriodique (Timer automaticTimer){
		System.out.println ("Executing (toutes les 15s) ...");
		System.out.println ("Execution Time : " + new Date ());
		System.out.println ("____________________________________________");
		// actualiser le cache
		deviseListInCache = dao.chercherDevises ();
	}
	@Override
	public Devise chercherParCode (String code){
		Devise devise = dao.chercherParCode (code);
		return devise;
	}
	@Override
	public List<Devise> chercherDevises (){
		if (deviseListInCache != null) return deviseListInCache;
		else return dao.chercherDevises ();
	}
	@Override
	public double convertir (double montant, String deviseSrc, String deviseDst){
		return 1;
	}
	public double euroToFrancV1 (double montant){
		return montant * coeff;
	}
	@Override
	public double euroToFranc (@WebParam (name = "montantEuro") double montant){
		return montant * coeff;
	}
	@Override
	public double francToEuro (double montant){
		return montant / coeff;
	}
	@PostConstruct
	public void init (){
		// remplace le constructeur
		deviseListInCache = dao.chercherDevises ();
	}
	public ServiceDeviseImpl (){
		/*
		dao					= new DaoDeviseImpl ();
		deviseListInCache	= dao.chercherDevises ();
		*/
	}
}
