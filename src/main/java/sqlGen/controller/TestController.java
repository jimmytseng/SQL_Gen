package sqlGen.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestController {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/test")
	public Map<String, Object> test() {
		return jdbcTemplate.queryForMap("SELECT * FROM Customer");
	}


}
