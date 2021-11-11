package de.tekup.rst.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.rst.entities.TicketEntity;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer>{

}
