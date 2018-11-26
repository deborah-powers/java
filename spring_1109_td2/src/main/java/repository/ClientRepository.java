package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
