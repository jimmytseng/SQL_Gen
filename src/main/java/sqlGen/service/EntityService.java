package sqlGen.service;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import genClassUtils.ClazzBuilder;
import genClassUtils.DataType;
import genClassUtils.Field;
import sqlGen.dao.CommonTableDAO;

@Service
public class EntityService {

	@Autowired
	private CommonTableDAO tableDAO;

	public void genNativeEntity(String tableName) {
		Map<String, String> metaDataMap = this.tableDAO.getTabelMetaData(tableName);
		ClazzBuilder entityClzBuilder = new ClazzBuilder(tableName);
		for (Entry<String, String> mapEntry : metaDataMap.entrySet()) {
			entityClzBuilder = entityClzBuilder
					.addField(new Field(mapEntry.getKey(), DataType.getDataType(mapEntry.getValue())));
		}
		System.out.print(entityClzBuilder.buildClazz().genCode());
	}

}
