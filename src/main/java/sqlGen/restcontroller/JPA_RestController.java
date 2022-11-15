package sqlGen.restcontroller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import genClassUtils.ClazzBuilder;
import genClassUtils._interface.Interface;
import genClassUtils._interface.InterfaceBuilder;
import genClassUtils.annotation.ClazzAnnotation;
import genClassUtils.annotation.FieldAnnotation;
import genClassUtils.field.Field;
import genClassUtils.method.InterfaceMethod;
import genClassUtils.utility.GenStringUtil;
import genClassUtils.utility.GenUtil;
import sqlGen.core.entity.EntityMetaData;
import sqlGen.core.entity.jpa.annotation.ColumnAnnotation;
import sqlGen.dao.CommonTableDAO;

@RestController
@RequestMapping("jpa")
public class JPA_RestController {

	@Autowired
	private CommonTableDAO tableDAO;

	@GetMapping("genEntity/{tableName}")
	public void genEntity(HttpServletResponse response,@PathVariable String tableName) {
		// Entity gen
		String fileName = GenStringUtil.firstToUpper(tableName) + "Entity.java";
		EntityMetaData entityMetaData = this.tableDAO.getEntityMetaData(tableName);
		ClazzBuilder clazzBuilder = new ClazzBuilder(fileName);
		Set<String> imports = new HashSet<>();
		imports.add("javax.persistence.Entity");
		imports.add("import javax.persistence.Id");
		clazzBuilder.setImports(imports);
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
		
		// interface gen
		fileName =GenStringUtil.firstToUpper(tableName)+"DAO.java";
		Interface extendsInterface = new Interface("JpaRepository");
		extendsInterface.getGenerics().add(GenStringUtil.firstToUpper(tableName) + "Entity");
		extendsInterface.getGenerics().add("Integer");

		InterfaceBuilder interfaceBuilder = new InterfaceBuilder(GenStringUtil.firstToUpper(tableName)+"DAO");
		Interface myInterface = interfaceBuilder.addImplementInterfaces(extendsInterface).buildInterface();
		System.out.println(myInterface.genCode());
		GenUtil.genFileToPackage(fileName, myInterface.genCode());
		
	}

}
