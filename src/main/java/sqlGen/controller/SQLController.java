package sqlGen.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sqlGen.core.GenSQLService;
import sqlGen.dto.GenSqlDTO;
import sqlGen.service.CommonTableService;

@Controller
@RequestMapping(value="/sql")
public class SQLController {
	
	@Autowired
	private CommonTableService tableService;
	
	@RequestMapping("/native")
	public String handler(@ModelAttribute("sqlGenDTO")GenSqlDTO sqlGenDTO,ModelMap modelMap) {
		return "sql/native";
	}
	@RequestMapping("/genNativeSql")
	public String genSql(@ModelAttribute("sqlGenDTO")GenSqlDTO sqlGenDTO,ModelMap modelMap) {
		GenSQLService genService = new GenSQLService();
		String result = genService.genSQLStr(sqlGenDTO);
		sqlGenDTO.setSqlResult(result);
		return "sql/native";
	}
	
	@ModelAttribute
	public void getTableOption(ModelMap modelMap){
		Map<String, String> tableOption = tableService.getAllTableOption();
		modelMap.addAttribute("tableOption", tableOption);
	}
}
