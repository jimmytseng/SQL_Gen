package sqlGen.service;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import genClassUtils.ClazzBuilder;
import genClassUtils.annotation.Annotation;
import genClassUtils.annotation.ClazzAnnotation;
import genClassUtils.annotation.FieldAnnotation;
import genClassUtils.enums.DataType;
import genClassUtils.field.Field;
import genClassUtils.method.Method;
import genClassUtils.utility.GenStringUtil;
import genClassUtils.utility.GenUtil;
import sqlGen.core.entity.EntityMetaData;
import sqlGen.core.entity.jpa.annotation.ColumnAnnotation;
import sqlGen.dao.CommonTableDAO;

@Service
public class EntityService {

	@Autowired
	private CommonTableDAO tableDAO;

	public void genNativeEntity(String tableName) {
		String fileName = GenStringUtil.firstToUpper(tableName) + ".java";
		Map<String, String> metaDataMap = this.tableDAO.getTabelColumnMetaData(tableName);
		ClazzBuilder entityClzBuilder = new ClazzBuilder(tableName);
		for (Entry<String, String> mapEntry : metaDataMap.entrySet()) {
			Field columnField = new Field(mapEntry.getKey().toLowerCase(), DataType.getDataType(mapEntry.getValue()));
			entityClzBuilder = entityClzBuilder.buildGetterSetter(columnField);
		}

		GenUtil.genFileToPackage(fileName, entityClzBuilder.buildClazz().genCode());
	}

	public void genJpaEntity(String tableName) {
		String fileName = GenStringUtil.firstToUpper(tableName) + "Entity.java";
		EntityMetaData entityMetaData = this.tableDAO.getEntityMetaData(tableName);
		ClazzBuilder clazzBuilder = new ClazzBuilder(tableName);
		Set<Field> entityColumn = entityMetaData.getEntityColumns();
		Set<String> keys = entityMetaData.getPrimaryKeys();
		if (keys.size() == 1) {
			String keyColumn = keys.iterator().next();
			clazzBuilder.addAnnotation(new ClazzAnnotation("Entity"));
			entityColumn.stream().filter(field -> field.getFieldName().equals(keyColumn))
					.forEach(field -> field.getAnnotation().add(new FieldAnnotation("Id")));
			entityColumn.stream().forEach(field -> {
				field.getAnnotation().add(new ColumnAnnotation("\"" + field.getFieldName() + "\""));
			});
			clazzBuilder.buildAllGetterSetter(entityColumn);
		}
		if (keys.size() > 1) {
		}
		GenUtil.genFileToPackage(fileName, clazzBuilder.buildClazz().genCode());
	}

}
