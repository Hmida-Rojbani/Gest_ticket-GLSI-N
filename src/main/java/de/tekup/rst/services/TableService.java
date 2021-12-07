package de.tekup.rst.services;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.tekup.rst.dto.models.TableDTO;
import de.tekup.rst.entities.TableEntity;
import de.tekup.rst.entities.TableType;
import de.tekup.rst.repositories.TableRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TableService {
	
	private TableRepository tableRepository;
	private ModelMapper mapper;
	
	public void addTable(TableDTO dto) {
		tableRepository.save(mapper.map(dto, TableEntity.class));
	}
 
}
