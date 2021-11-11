package de.tekup.rst.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.rst.entities.Table;

public interface TableRepository extends JpaRepository<Table, Integer>{

}
