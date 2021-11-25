package de.tekup.rst.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@ToString(exclude = "tickets")
public abstract class MetEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	
	private double prix;
	@ManyToMany(mappedBy = "mets")
	private List<TicketEntity> tickets;
}
