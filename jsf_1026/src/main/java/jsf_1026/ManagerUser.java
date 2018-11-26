package jsf_1026;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

// le nom du bean sera passé aux vues
@ManagedBean(name = "managerUser")
@RequestScoped
public class ManagerUser {
	private String prenom;

	public String salut() {
		return "Coucou " + prenom;
	}

	public ManagerUser(String prenom) {
		this.prenom = prenom;
	}

	public ManagerUser() {
		prenom = "Doudou";
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
