package de.tekup.rst.dto.models;

import lombok.Data;

@Data
public class TicketDTO {
	
	private Integer clientId;
	private Integer tableNumero;
	private Integer[] metsIds;
	
	private Integer nbCouverts;

}
