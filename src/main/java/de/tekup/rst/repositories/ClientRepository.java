package de.tekup.rst.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.rst.entities.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer>{

}
