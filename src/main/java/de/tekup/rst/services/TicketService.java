package de.tekup.rst.services;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import de.tekup.rst.dto.models.TicketDTO;
import de.tekup.rst.entities.ClientEntity;
import de.tekup.rst.entities.MetEntity;
import de.tekup.rst.entities.TableEntity;
import de.tekup.rst.entities.TicketEntity;
import de.tekup.rst.repositories.ClientRepository;
import de.tekup.rst.repositories.MetRepository;
import de.tekup.rst.repositories.TableRepository;
import de.tekup.rst.repositories.TicketRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TicketService {
	private ClientRepository clientRepository;
	private TableRepository tableRepository;
	private MetRepository metRepository;
	private TicketRepository ticketRepository;
	
	public double createTicket(TicketDTO ticketDTO) {
		ClientEntity clientEntity = clientRepository
						.findById(ticketDTO.getClientId()).get();
		TableEntity table = tableRepository
				.findById(ticketDTO.getTableNumero()).get();
		List<MetEntity> mets = metRepository
				.findAllById(Arrays.asList(ticketDTO.getMetsIds()));
		
		double addition=mets.stream()
						.mapToDouble(met-> met.getPrix())
						.sum()+table.getSupplement();
		
		TicketEntity ticketEntity = new TicketEntity();
		ticketEntity.setClient(clientEntity);
		ticketEntity.setTable(table);
		ticketEntity.setMets(mets);
		ticketEntity.setNbCouverts(ticketDTO.getNbCouverts());
		ticketEntity.setAddition(addition);
		ticketEntity.setDateTime(LocalDateTime.now());
		
		ticketRepository.save(ticketEntity);
		return addition;
	}

}
