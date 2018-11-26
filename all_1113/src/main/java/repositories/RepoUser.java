package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.User;

public interface RepoUser extends JpaRepository<User, Integer> {}
