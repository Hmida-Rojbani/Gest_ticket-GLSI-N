package de.tekup.rst.services;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.tekup.rst.dto.models.TableDTO;
import de.tekup.rst.entities.TableEntity;
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
	
	public List<TableDTO> getAllTables(){
		return tableRepository.findAll()
					.stream()
					.map(te -> mapper.map(te, TableDTO.class))
					.collect(Collectors.toList());
	}
 
}
