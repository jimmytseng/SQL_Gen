package sqlGen.dto;

import java.util.List;

public class GenSqlDTO {
	public static final String DML_UPDATE = "update";
	public static final String DML_DELETE = "delete";
	public static final String DML_SELECT = "select";
	
	String sqlType;
	String tableName;
	List<String> columnNAME;
	String dmlType;
	boolean withSchema;
	String whereCondition;
	boolean isUpperCase;

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

	public boolean isUpperCase() {
		return isUpperCase;
	}

	public void setUpperCase(boolean isUpperCase) {
		this.isUpperCase = isUpperCase;
	}
}
