package sqlGen.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sqlGen.dto.GenSqlDTO;
import sqlGen.service.CommonTableService;

@Controller
@RequestMapping(value="/sql")
public class SQLController {
	
	@Autowired
	private CommonTableService tableService;
	
	@RequestMapping("/native")
	public String handler(@ModelAttribute("sqlGenDTO")GenSqlDTO sqlGenDTO) {
		Map<String, String> tableOption = tableService.getAllTableOption();
		return "sql/native";
	}
	@RequestMapping("/genSql")
	public String handler(ModelAndView viewModel,GenSqlDTO dto) {
		return "myView";
	}
}
