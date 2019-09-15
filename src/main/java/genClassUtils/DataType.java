package genClassUtils;

public enum DataType {

	STRING("String"), TIMESTAMP("Timestamp"), DATE("Date"), INTEGER("Integer"), BOOLEAN("Boolean"), FLOAT("Float"),
	LONG("Long");

	DataType(String dataType) {
		this.dataType = dataType;
	}

	private String dataType;

	public String getDataType() {
		return dataType;
	}

}
