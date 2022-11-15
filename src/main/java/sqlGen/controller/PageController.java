package sqlGen.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sqlGen.service.CommonTableService;
import sqlGen.service.EntityService;

@Controller
@RequestMapping(value = "/entity")
public class PageController {

	@Autowired
	private CommonTableService tableService;
	
	@Autowired
	private EntityService entityService;

	
	@RequestMapping("/jpa")
	public String handler_jpa(ModelMap modelMap) {
		return "entity/jpa";
	}
	
	@RequestMapping("/genJpaEntity")
	public String genJpaEntity(@RequestParam String tableName) {
		this.entityService.genJpaEntity(tableName);
		return "entity/jpa";
	}
	
	@ModelAttribute
	public void getTableOption(ModelMap modelMap){
		Map<String, String> tableOption = tableService.getAllTableOption();
		modelMap.addAttribute("tableOption", tableOption);
	}
}
