package sqlGen.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sqlGen.dao.CommonTableDAO;

@Service
public class CommonTableService {

	@Autowired
	private CommonTableDAO tableDAO;
	
	public Map<String, String> getAllTableOption(){
		return tableDAO.getAllTableOption();
	}

	public List<String> getTableColumns(String tableName) {
		return tableDAO.getTableColumns(tableName);
	}

	public Map<String, String> getTableByFilterName(String filterName) {
		return tableDAO.getTableByFilterName(filterName);
	}
}
