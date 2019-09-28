package sqlGen.core.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import genClassUtils.Field;

public class EntityMetaData {

	private String tableName = "";

	private Set<String> primaryKeys = new LinkedHashSet<>();

	private Set<Field> entityColumns = new LinkedHashSet<>();

	public Set<Field> getEntityColumns() {
		return entityColumns;
	}

	public void setEntityColumns(Set<Field> entityColumns) {
		this.entityColumns = entityColumns;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Set<String> getPrimaryKeys() {
		return primaryKeys;
	}

	public void setPrimaryKeys(Set<String> primaryKeys) {
		this.primaryKeys = primaryKeys;
	}

}