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
	private String sqlType;
	private String tableName;
	private List<String> columnName;
	private String dmlType;
	private boolean withSchema;
	private String whereCondition;
	private Integer isUpperCase=1;
	private String sqlResult;

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



	public List<String> getColumnName() {
		return columnName;
	}

	public void setColumnName(List<String> columnName) {
		this.columnName = columnName;
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

	public String getSqlResult() {
		return sqlResult;
	}

	public void setSqlResult(String sqlResult) {
		this.sqlResult = sqlResult;
	}

}
