package sqlGen.core.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import genClassUtils.CommonClazz;

public abstract class EntityMetaData extends CommonClazz {

	private String tableName = "";
	
	private Set<String> primaryKeys = new LinkedHashSet<>();
	
	private Set<String> entityColumns = new LinkedHashSet<>();

	public EntityMetaData() {
		super();
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

	public Set<String> getEntityColumns() {
		return entityColumns;
	}

	public void setEntityColumns(Set<String> entityColumns) {
		this.entityColumns = entityColumns;
	}

}