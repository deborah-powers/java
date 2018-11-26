package services;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import entities.Adress;
import entities.Customer;

@Named("service")
@SessionScoped
public class CustomerService implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	@EJB
	private DaoCustomer daoCustomer;
	private Customer customer;
	private String lastname;
//	private String text;
	private String firstname;
	private String password;
	private String email;
	private String login;
	private String telephone;
	private LocalDate birth;

	// adress

	private Adress adress;
	private String city;
	private String street;
	private String zipCode;
	private String country;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public String update(Customer customer) {
//		daoCustomer.update(customer);
//		return "productList.xhtml";
//	}

	public DaoCustomer getDaoCustomer() {
		return daoCustomer;
	}

	public void setDaoCustomer(DaoCustomer daoCustomer) {
		this.daoCustomer = daoCustomer;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String add() {

		adress = new Adress();
		customer = new Customer(lastname, firstname, password, email, login, telephone, LocalDate.now(), adress);
//		adress = new Adress(city, street, zipCode, country);
		adress.setCity(city);
		adress.setStreet(street);
		adress.setZipCode(zipCode);
		adress.setCountry(country);
		adress.setId(customer.getId());
		daoCustomer.add(customer, adress);
		return null;

//		return "productList.xhtml";
	}

	public String delete(int id) {
		daoCustomer.remove(id);
		return null;
	}

	public String findById() {
		customer = daoCustomer.findById(customer.getId());
		return null;
	}

	public List<Customer> findAll() {
		return daoCustomer.findAll();
	}

	public String redirect(Customer cust) {
		customer = new Customer();
		if (cust.getId() != 0) {
			customer = cust;
		}
		return "custom";
	}

	public void update(Customer customer) {
		daoCustomer.update(customer);
	}
}
