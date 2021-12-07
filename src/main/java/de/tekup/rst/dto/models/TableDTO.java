package de.tekup.rst.dto.models;

import de.tekup.rst.entities.TableType;
import lombok.Data;

@Data
public class TableDTO {
	
	private Integer numero;
	private int nbCouverts;
	private TableType type;
	private double supplement;
}
