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
public class EntityController {

	@Autowired
	private CommonTableService tableService;
	
	@Autowired
	private EntityService entityService;

	@RequestMapping("/native")
	public String handler(ModelMap modelMap) {
		return "entity/native";
	}
	
	@RequestMapping("/genNativeEntity")
	public String genNativeEntity(@RequestParam String tableName) {
		this.entityService.genNativeEntity(tableName);
		return "entity/native";
	}
	
	@ModelAttribute
	public void getTableOption(ModelMap modelMap){
		Map<String, String> tableOption = tableService.getAllTableOption();
		modelMap.addAttribute("tableOption", tableOption);
	}
}
