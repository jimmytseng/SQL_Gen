package sqlGen.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenSqlDTO {
	public static final String DML_SELECT = "select";
	public static final String DML_INSERT = "insert";
	public static final String DML_UPDATE = "update";
	public static final String DML_DELETE = "delete";
	public static Map<Integer, String> letterMap;
	static {
		letterMap = new HashMap<>();
		letterMap.put(1, "none");
		letterMap.put(2, "lower-case");
		letterMap.put(3, "upper-case");
	}
	String sqlType;
	String tableName;
	List<String> columnNAME;
	String dmlType;
	boolean withSchema;
	String whereCondition;
	Integer isUpperCase=1;

	public String getSqlType() {
		return sqlType;
	}

	public void setSqlType(String sqlType) {
		this.sqlType = sqlType;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<String> getColumnNAME() {
		return columnNAME;
	}

	public void setColumnNAME(List<String> columnNAME) {
		this.columnNAME = columnNAME;
	}

	public String getDmlType() {
		return dmlType;
	}

	public void setDmlType(String dmlType) {
		this.dmlType = dmlType;
	}

	public boolean isWithSchema() {
		return withSchema;
	}

	public void setWithSchema(boolean withSchema) {
		this.withSchema = withSchema;
	}

	public String getWhereCondition() {
		return whereCondition;
	}

	public void setWhereCondition(String whereCondition) {
		this.whereCondition = whereCondition;
	}

	public Integer getIsUpperCase() {
		return isUpperCase;
	}

	public void setIsUpperCase(Integer isUpperCase) {
		this.isUpperCase = isUpperCase;
	}

}
