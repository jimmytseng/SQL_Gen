package sqlGen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sqlGen.dto.GenSqlDTO;

@Controller
public class CommonController {
     
	@RequestMapping("/")
	public String handler(@ModelAttribute("sqlGenDTO")GenSqlDTO sqlGenDTO,ModelMap modelMap) {
		return "index";
	} 
}
