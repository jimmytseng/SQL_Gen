package sqlGen.service;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import genClassUtils.ClazzBuilder;
import genClassUtils.DataType;
import genClassUtils.Field;
import genClassUtils.GenStringUtil;
import genClassUtils.GenUtil;
import sqlGen.dao.CommonTableDAO;

@Service
public class EntityService {

	@Autowired
	private CommonTableDAO tableDAO;

	public void genNativeEntity(String tableName) {
		String fileName = GenStringUtil.firstToUpper(tableName) + ".java";
		Map<String, String> metaDataMap = this.tableDAO.getTabelMetaData(tableName);
		ClazzBuilder entityClzBuilder = new ClazzBuilder(tableName);
		for (Entry<String, String> mapEntry : metaDataMap.entrySet()) {
			Field columnField = new Field(mapEntry.getKey().toLowerCase(), DataType.getDataType(mapEntry.getValue()));
			entityClzBuilder = entityClzBuilder.buildGetterSetter(columnField);
		}

		File file = new File("");
		System.out.println(file.getAbsolutePath() + "\\src\\main\\java\\entity");
		String packeagePath = file.getAbsolutePath() + "\\\\src\\\\main\\\\java\\\\entity";
		File destPath = new File(packeagePath);
		if (!destPath.exists()) {
			destPath.mkdirs();
		}
		GenUtil.writefile(destPath + "\\" + fileName, entityClzBuilder.buildClazz().genCode());
	}

	public void genJpaEntity(String tableName) {
		String fileName = GenStringUtil.firstToUpper(tableName) + "Entity.java";
		Map<String, String> metaDataMap = this.tableDAO.getTabelMetaData(tableName);
		ClazzBuilder entityClzBuilder = new ClazzBuilder(tableName);
		for (Entry<String, String> mapEntry : metaDataMap.entrySet()) {
			Field columnField = new Field(mapEntry.getKey().toLowerCase(), DataType.getDataType(mapEntry.getValue()));
			entityClzBuilder = entityClzBuilder.buildGetterSetter(columnField);
		}

		File file = new File("");
		System.out.println(file.getAbsolutePath() + "\\src\\main\\java\\entity");
		String packeagePath = file.getAbsolutePath() + "\\\\src\\\\main\\\\java\\\\entity";
		File destPath = new File(packeagePath);
		if (!destPath.exists()) {
			destPath.mkdirs();
		}
		GenUtil.writefile(destPath + "\\" + fileName, entityClzBuilder.buildClazz().genCode());
	}

}
