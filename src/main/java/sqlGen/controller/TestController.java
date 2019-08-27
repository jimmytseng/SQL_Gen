package sqlGen.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@RequestMapping(value = "/test")
	public Map<String, Object> test() {
		String queryStr = "SELECT * FROM Customer";
		logger.debug(queryStr);
		logger.info(queryStr);
		logger.error(queryStr);
		return jdbcTemplate.queryForMap(queryStr);
	}

}
