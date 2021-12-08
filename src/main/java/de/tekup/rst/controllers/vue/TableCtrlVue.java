package de.tekup.rst.controllers.vue;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.rst.dto.models.TableDTO;
import de.tekup.rst.services.TableService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@SuppressWarnings("deprecation")
public class TableCtrlVue {
	
		private TableService tableService;
	
	  @GetMapping("/tables/add")
	  @SuppressWarnings({"unchecked","deprecation"})
	  public String getAddTable( Model model) {		
		  Integer t = new Integer(0);
		 
		  
		  model.addAttribute("table", new TableDTO());
		  return "tables/add-table";
	  }
	  
	  
	  
	  @PostMapping("/tables/add")
	  public String postAddTable(@ModelAttribute("table") TableDTO tableDTO) {
		  tableService.addTable(tableDTO);
		  return "redirect:/tables/show";
	  }

	  
	  @GetMapping("/tables/show")
	  public String getShowTable(Model model) {
		  model.addAttribute("listTable", tableService.getAllTables());
		  return "tables/show-table";
	  }
}
