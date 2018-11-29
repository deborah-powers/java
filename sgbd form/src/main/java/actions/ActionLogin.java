package actions;

import com.opensymphony.xwork2.ActionSupport;
import models.User;
import daos.UserDao;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;


public class ActionLogin extends ActionSupport implements SessionAware {
    private String action;
    private String prenom;
    private String mdp;
    private User userConnected;
    private int id;
    private ArrayList<User> userList;
    private Map<String, Object> session;

    private String extractUserList (UserDao dao) throws SQLException {
        /* cas simple qui marche
        if (prenom.equals ("deborah")) return SUCCESS;
        else return INPUT;
        */
        // me connecter à la bdd pour récupérer l'utilisateur
        userConnected = dao.getUser (prenom, mdp);
        if (userConnected == null) return INPUT;
        else {
            session.put ("userConnected", userConnected);
            userList = dao.getUserList();
            return SUCCESS;
        }
    }
    @Override
    public String execute() throws Exception {
        System.out.println ("action = "+ action);
        UserDao dao = new UserDao();
        if (action.equals ("delete")) delete (dao);
        return extractUserList (dao);
    }
    private void delete (UserDao dao) throws SQLException {
        dao.removeUser (id);
    }
    @Override
    public void validate() {
        // le prénom manque
        if (prenom.trim().isEmpty())
            addFieldError ("prenom", "Vous devez entrer votre prénom");
    }

    public ActionLogin(String action, int id, User userConnected, String prenom, String mdp, ArrayList<User> userList) {
        this.action = action;
        this.id = id;
        this.userConnected = userConnected;
        this.prenom = prenom;
        this.mdp = mdp;
        this.userList = userList;
    }
    public ActionLogin(){
        this ("del", 0, new User(), "lou", "pomeranie", null);
    }
    public Map<String, Object> getSession() {
        return session;
    }
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public User getUserConnected() {
        return userConnected;
    }
    public void setUserConnected(User userConnected) {
        this.userConnected = userConnected;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public ArrayList<User> getUserList() {
        return userList;
    }
    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }
}
