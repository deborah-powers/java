package services;

import java.util.List;

import entities.User;

public interface ServiceUser {
	public void update (User user);
	public User create (User user);
	public void delete (int id);
	public User findById (int id);
	public List<User> findAll ();
}
