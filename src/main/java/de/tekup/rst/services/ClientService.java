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
//		ClientEntity clientEntity = new ClientEntity();
//		clientEntity.setNom(clientReqDTO.getNom());
//		clientEntity.setPrenom(clientReqDTO.getPrenom());
//		clientEntity.setDateDeNaissance(clientReqDTO.getDateDeNaissance());
//		clientEntity.setCourriel(clientReqDTO.getCourriel());
//		clientEntity.setTelephone(clientReqDTO.getTelephone());
		clientRepository.save(clientEntity);
		ClientResDTO clientResDTO = mapper.map(clientEntity, ClientResDTO.class);
//		ClientResDTO clientResDTO = new ClientResDTO();
//		clientResDTO.setId(clientEntity.getId());
//		clientResDTO.setNomComplet(clientEntity.getPrenom()
//				+" "+clientEntity.getNom());
//		clientResDTO.setAge((int)ChronoUnit.YEARS
//		.between(clientEntity.getDateDeNaissance(), LocalDate.now()));
		return clientResDTO;
	}

}
