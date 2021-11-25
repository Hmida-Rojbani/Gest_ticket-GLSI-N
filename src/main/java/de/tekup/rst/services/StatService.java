package de.tekup.rst.services;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.tekup.rst.dto.models.MetDTO;
import de.tekup.rst.entities.MetEntity;
import de.tekup.rst.entities.Plat;
import de.tekup.rst.repositories.MetRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatService {

	private MetRepository metRepository;
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

}
