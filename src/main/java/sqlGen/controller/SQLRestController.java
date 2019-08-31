package sqlGen.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sqlGen.service.CommonTableService;

@RestController
@RequestMapping("/sqlRest")
public class SQLRestController {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	private CommonTableService tableService;

	private static final Logger logger = LoggerFactory.getLogger(SQLRestController.class);

	@RequestMapping(value = "/test")
	public Map<String, Object> test() {
		String queryStr = "SELECT * FROM Customer";
		logger.debug(queryStr);
		logger.info(queryStr);
		logger.error(queryStr);
		return jdbcTemplate.queryForMap(queryStr);
	}

	@RequestMapping(value = "/getColumns")
	public List<String> getColumns(@RequestParam String tableName) {
		List<String> columnNames = this.tableService.getTableColumns(tableName);
		return columnNames;
	}

	@RequestMapping(value = "/getTables")
	public Map<String, String> getTables(@RequestParam String filterName) {
		Map<String, String> tableNames = this.tableService.getTableByFilterName(filterName);
		return tableNames;
	}

}
