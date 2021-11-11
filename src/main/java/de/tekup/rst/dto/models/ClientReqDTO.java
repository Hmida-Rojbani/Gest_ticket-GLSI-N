package de.tekup.rst.dto.models;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ClientReqDTO {
	
	private String nom;
	private String prenom;
	private LocalDate dateDeNaissance;
	private String courriel;
	private String telephone;

}
