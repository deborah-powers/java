package services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import entities.Category;
import entities.Item;
import entities.Product;

@Named("ProductService")
@SessionScoped
public class ProductService implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private DaoProduct dao;
	// one Product
	private Product product;
	// Product list
	private List<Product> products;

	// variable ajouté
	private String name;
	private String description;
	private Category categorie;
	private List<Item> items;
	private int id;

	public String update(Product product) {
		dao.update(product);
		return "productList.xhtml";
	}

	public String add() {
		product = new Product(name, description, categorie, items);
		dao.add(product);
		return "productList.xhtml";
	}

	public String delete() {
		dao.remove(id);
		return null;
	}

	public String findById() {
		product = dao.findById(product.getId());
		return null;
	}

	public ProductService() {
		products = dao.findAll();
		product = new Product();
	}
}
