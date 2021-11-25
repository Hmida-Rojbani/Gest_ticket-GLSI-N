package de.tekup.rst.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
	@Column(unique = true)
	private String courriel;
	
	private String telephone;
	
	@OneToMany(mappedBy = "client")
	private List<TicketEntity> tickets;
	
	public String getNomComplet() {
		return prenom +" "+nom;
	}
	
	public int getAge() {
		return (int)ChronoUnit.YEARS.between(dateDeNaissance
				, LocalDate.now());
	}
	
}
