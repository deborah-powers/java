package repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	public List<Client> findByNomStartingWith (String nom, Sort ordreTri);
}
