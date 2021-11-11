package de.tekup.rst.services;

import org.springframework.stereotype.Service;

import de.tekup.rst.entities.ClientEntity;
import de.tekup.rst.repositories.ClientRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService {
	
	private ClientRepository clientRepository;
	
	public ClientEntity saveToDB(ClientEntity clientEntity) {
		return clientRepository.save(clientEntity);
	}

}
