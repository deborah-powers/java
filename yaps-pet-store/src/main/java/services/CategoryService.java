package services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import entities.Category;
import entities.Product;

@Named("categoryService")
@SessionScoped
public class CategoryService implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private DaoCategory dao;
	// one category
	private Category category;
	// category list
	private List<Category> categories;

	// variable ajouté
	private String name;
	private String description;
	private List<Product> products;
	private int id;

	public String update(Category category) {
		dao.update(category);
		// nous sommes dans le formulaire d'update, revenir à la liste de catégories
		return "categoryList.xhtml";
	}

	public String readyUpdate(Category category) {
		// lancé dans la page de la liste
//		this.category.set;
		category = new Category();
		// arrivée vers le formulaire
		return "categoryForm.xhtml";
	}

	public String add() {
		// lancé dans la page du formulaire
		category = new Category(name, description, products);
		dao.add(category);
		// retour vers la liste
		return "categoryList.xhtml";
	}

	public String readyAdd() {
		// lancé dans la page de la liste
		category = new Category();
		// arrivée vers le formulaire
		return "categoryForm.xhtml";
	}

	public String delete() {
		dao.remove(id);
		return null;
	}

	public String findById() {
		category = dao.findById(category.getId());
		return null;
	}

	public CategoryService() {
		categories = dao.findAll();
		category = new Category();
	}
}
