package de.tekup.rst.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import de.tekup.rst.entities.TableEntity;

public interface TableRepository extends JpaRepository<TableEntity, Integer>{

}
