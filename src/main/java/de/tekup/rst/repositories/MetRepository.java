package de.tekup.rst.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.rst.entities.MetEntity;

public interface MetRepository extends JpaRepository<MetEntity, Integer>{

}
