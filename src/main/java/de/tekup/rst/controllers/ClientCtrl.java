package de.tekup.rst.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.rst.dto.models.ClientReqDTO;
import de.tekup.rst.dto.models.ClientResDTO;
import de.tekup.rst.services.ClientService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ClientCtrl {
	
	private ClientService clientService;
	
	@PostMapping("/api/clients")
	public ClientResDTO addClient(@RequestBody ClientReqDTO clientReqDTO) {
		return clientService.saveToDB(clientReqDTO);
	}

}
