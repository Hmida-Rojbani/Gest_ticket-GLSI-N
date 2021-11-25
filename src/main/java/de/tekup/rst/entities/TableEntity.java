package de.tekup.rst.entities;

import java.util.List;

import javax.persistence.*;


import lombok.Data;
@Entity
@Data
public class TableEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;
	
	private int nbCouverts;
	@Enumerated(EnumType.STRING)
	private TableType type;
	
	private double supplement;
	
	@OneToMany(mappedBy = "table")
	private List<TicketEntity> ticktes;

}
