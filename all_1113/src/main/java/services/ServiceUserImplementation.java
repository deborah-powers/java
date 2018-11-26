package services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entities.User;
import repositories.RepoUser;

@Service
public class ServiceUserImplementation implements ServiceUser {
	@Resource // retrouver une dépendence
	private RepoUser ru;

	@Override
	@Transactional
	public void update (User user){
		User user2 = ru.getOne (user.getId ());
		if (user2 != null) {
			user2.setEmail (user.getEmail ());
			user2.setLogin (user.getLogin ());
			user2.setNom (user.getNom ());
			user2.setPassword (user.getPassword ());
			user2.setPrenom (user.getPrenom ());
			user2.setProfil (user.getProfil ());
		}
	}

	@Override
	@Transactional
	public User create (User user){
		User user2 = ru.save (user);
		return user2;
	}

	@Override
	@Transactional
	public void delete (int id){
		User user = ru.getOne (id);
		if (user != null)
			ru.delete (user);
	}

	@Override
	@Transactional
	public User findById (int id){
		User user = ru.getOne (id);
		return user;
	}

	@Override
	@Transactional
	public List<User> findAll (){
		return ru.findAll ();
	}

}
