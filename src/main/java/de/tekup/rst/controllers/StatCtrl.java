package de.tekup.rst.controllers;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.rst.dto.models.MetDTO;
import de.tekup.rst.services.StatService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class StatCtrl {
	
	private StatService statService;
	
	@GetMapping("/api/stats/plat/{deb}/{fin}")
	public MetDTO getPlatPlusAchetee(@PathVariable String deb,@PathVariable String fin) {
		LocalDate debDate = LocalDate.parse(deb);
		LocalDate finDate = LocalDate.parse(fin);
		//return statService.platPlusAchetee(debDate, finDate);
		return statService.platPlusAcheteeWithQuery(debDate, finDate);
	}

	@GetMapping("/api/stats/client/jour/{id}")
	public String clientJour(@PathVariable int id) {
		return statService.jourClient(id);
	}
}
