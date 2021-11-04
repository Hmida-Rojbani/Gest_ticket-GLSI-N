package de.tekup.rst.entities;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@javax.persistence.Table(name = "tableRest")
public class Table {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;
	
	private int nbCouverts;
	@Enumerated(EnumType.STRING)
	private TableType type;
	
	private double supplements;

}
