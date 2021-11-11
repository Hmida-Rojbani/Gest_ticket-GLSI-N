package de.tekup.rst.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.tekup.rst.dto.models.ClientReqDTO;
import de.tekup.rst.dto.models.ClientResDTO;
import de.tekup.rst.entities.ClientEntity;
import de.tekup.rst.repositories.ClientRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService {
	
	private ClientRepository clientRepository;
	
	public ClientResDTO saveToDB(ClientReqDTO clientReqDTO) {
		ModelMapper mapper = new ModelMapper();
		ClientEntity clientEntity = mapper.map(clientReqDTO, ClientEntity.class);
		clientRepository.save(clientEntity);
		ClientResDTO clientResDTO = mapper.map(clientEntity, ClientResDTO.class);
		return clientResDTO;
	}

}
