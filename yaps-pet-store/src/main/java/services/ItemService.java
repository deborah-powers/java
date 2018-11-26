package services;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import entities.Item;
import entities.Product;

@Named("ItemService")
@SessionScoped
public class ItemService implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private DaoItem dao;
	// one Item
//	private List<Item> item;
	// Item list

	// variable ajouté

	private String name;
	private String description;
	private Item item;
	private int id;
	private float unitCoast;
	private String imagePath;
	private Product product;

	public String update(Item item) {
		dao.update(item);
		return "itemList.xhtml";
	}

//	(int id, String name, float unitCost, String imagePath, Product product)
	public String add() {
		// lancé dans la page du formulaire
		item = new Item(id, name, unitCoast, imagePath, product);
		dao.add(item);
		// retour vers la liste
		return "itemList.xhtml";
	}

	public String readyAdd() {
		// lancé dans la page de la liste
		// arrivée vers le formulaire
		return null;
	}

	public String delete() {
		dao.remove(id);
		return null;
	}

	public String findById() {
		item = dao.findById(item.getId());
		return null;
	}

//	public ItemService() {
//		item = dao.findAll();
////		item = new item();
//	}
}
