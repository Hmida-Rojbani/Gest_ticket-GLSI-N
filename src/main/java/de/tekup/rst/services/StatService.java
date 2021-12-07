package de.tekup.rst.services;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.tekup.rst.dto.models.ClientResDTO;
import de.tekup.rst.dto.models.MetDTO;
import de.tekup.rst.entities.ClientEntity;
import de.tekup.rst.entities.MetEntity;
import de.tekup.rst.entities.Plat;
import de.tekup.rst.entities.TicketEntity;
import de.tekup.rst.repositories.ClientRepository;
import de.tekup.rst.repositories.MetRepository;
import de.tekup.rst.repositories.TicketRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatService {

	private MetRepository metRepository;
	private ClientRepository clientRepository;
	private TicketRepository ticketRepository;
	private ModelMapper mapper;

	public MetDTO platPlusAcheteeWithQuery(LocalDate debut, LocalDate fin) {

		MetEntity entity = metRepository.platPlutAcheter(debut, fin);

		MetDTO dto = mapper.map(entity, MetDTO.class);
		dto.setType("Plat");
		return dto;
	}

	public MetDTO platPlusAchetee(LocalDate debut, LocalDate fin) {

		List<MetEntity> mets = metRepository.findAll();
		System.out.println(mets);
		// locate Plat objects
		mets.removeIf(met -> !(met instanceof Plat));
		System.out.println(mets);

		for (MetEntity metEntity : mets) {
			// remove tickets out of period
			metEntity.getTickets().removeIf(
					t -> t.getDateTime().toLocalDate().isBefore(debut) || t.getDateTime().toLocalDate().isAfter(fin));
		}

		int max = -1;
		MetEntity entity = null;

		for (MetEntity metEntity : mets) {
			if (metEntity.getTickets().size() > max) {
				max = metEntity.getTickets().size();
				entity = metEntity;
			}
		}
		MetDTO dto = mapper.map(entity, MetDTO.class);
		dto.setType("Plat");
		return dto;
	}
	
	public ClientResDTO clientFidele() {
		
		List<ClientEntity> clientEntities = clientRepository.findAll();
		
		Optional<ClientEntity> opt= clientEntities.stream()
		.max(Comparator.comparing(client-> client.getTickets().size()));
		ClientEntity entity = null;
		if(opt.isPresent())
			entity = opt.get();
		return mapper.map(entity, ClientResDTO.class);
	}
	
	public String jourClient(int id) {
		
		ClientEntity clientEntity = clientRepository.findById(id).get();
		List<TicketEntity> tickets = clientEntity.getTickets();
		
		List<DayOfWeek> days = tickets.stream()
								.map(t -> t.getDateTime().getDayOfWeek())
								.collect(Collectors.toList());
		System.out.println(days);
		
		Map<DayOfWeek, Long> map = days.stream()
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(map);
		
		Entry<DayOfWeek,Long> ent = map.entrySet().stream()
					.max(Map.Entry.comparingByValue())
					.get();
		System.out.println(ent);
		DayOfWeek day = ent.getKey();
		
		
		return day.getDisplayName(TextStyle.FULL, new Locale("fr"));
	}
	
	
	public Map<String, Double> revenue(){
		List<TicketEntity> tickets = ticketRepository.findAll();
		LocalDate today = LocalDate.now();
		
		double todayAddition = tickets.stream()
					.filter(t -> t.getDateTime().toLocalDate().isEqual(today))
					.mapToDouble( t -> t.getAddition())
					.sum();
		
		double monthAddition = tickets.stream()
					.filter(t -> t.getDateTime().getMonthValue() == today.getMonthValue() 
					&& t.getDateTime().getYear() == today.getYear())
					.mapToDouble(TicketEntity::getAddition)
					.sum();
		
		TemporalField weekOfYear = WeekFields.ISO.weekOfWeekBasedYear();
		
		double weekAddition = tickets.stream()
				.filter(t -> t.getDateTime().get(weekOfYear) == today.get(weekOfYear) 
				&& t.getDateTime().getYear() == today.getYear())
				.mapToDouble(TicketEntity::getAddition)
				.sum();
		
		Map<String, Double> map = new HashMap<>();
		
		map.put("Jour", todayAddition);
		map.put("Semaine", weekAddition);
		map.put("Mois", monthAddition);
		
		return map;
	}

}
