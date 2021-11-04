package de.tekup.rst.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class ClientEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	private String prenom;
	private LocalDate dateDeNaissance;
	private String courrier;
	private String telephone;
	
	@OneToMany(mappedBy = "client")
	private List<TicketEntity> tickets;
}
