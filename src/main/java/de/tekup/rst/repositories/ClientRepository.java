package de.tekup.rst.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.tekup.rst.entities.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer>{

	@Query("Select c from ClientEntity c where c.id = :id")
	ClientEntity chercheClient(@Param("id")Integer id);
	
	ClientEntity findByDateDeNaissance(LocalDate date);
}
