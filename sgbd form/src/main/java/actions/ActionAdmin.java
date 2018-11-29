package actions;

import com.opensymphony.xwork2.ActionSupport;
import daos.UserDao;
import models.User;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.SQLException;
import java.util.Map;

public class ActionAdmin extends ActionSupport implements SessionAware {
	private String action;
	private int uhId;
	private User userHandled;
	private Map<String, Object> session;

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
	}

	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
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
