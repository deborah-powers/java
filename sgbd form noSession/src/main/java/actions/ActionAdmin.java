package actions;

import com.opensymphony.xwork2.ActionSupport;
import daos.UserDao;
import models.User;

import java.sql.SQLException;

public class ActionAdmin extends ActionSupport {
	private String action;
	private int uhId;
	private User userHandled;
	private int ucId;
	private User userConnected;

	@Override
	public String execute() throws Exception {
		UserDao dao = new UserDao();
		switch (action){
			case "showUpdatePage": return showUser (dao);
			case "update": return update (dao);
			default: return INPUT;
		}
	}

	private String showUser (UserDao dao) throws SQLException {
		System.out.println ("user id= "+ uhId);
		userHandled = dao.getUser (uhId);
		userConnected = dao.getUser (ucId);
		return SUCCESS;
	}
	private String update (UserDao dao) throws SQLException {
        dao.updateUser(userHandled);
        return SUCCESS;
		/*
	    try {
            dao.updateUser(userHandled);
            return SUCCESS;
        }
        catch (SQLException e){
            System.out.println ("pb de connexion à la bdd");
            e.printStackTrace();
            return INPUT;
        }
		userConnected = dao.getUser (ucId);
		dao.getUserList();
		action = ""
		*/
	}
	public ActionAdmin(){
		action = "update";
	}
	public ActionAdmin(String action, int uhId, User userHandled, int ucId, User userConnected) {
		this.action = action;
		this.uhId = uhId;
		this.userHandled = userHandled;
		this.ucId = ucId;
		this.userConnected = userConnected;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getUhId() {
		return uhId;
	}

	public void setUhId(int uhId) {
		this.uhId = uhId;
	}

	public User getUserHandled() {
		return userHandled;
	}

	public void setUserHandled(User userHandled) {
		this.userHandled = userHandled;
	}

	public int getUcId() {
		return ucId;
	}

	public void setUcId(int ucId) {
		this.ucId = ucId;
	}

	public User getUserConnected() {
		return userConnected;
	}

	public void setUserConnected(User userConnected) {
		this.userConnected = userConnected;
	}
}
