package genClassUtils.enums;

public enum DataType {

	STRING("String"), TIMESTAMP("Timestamp"), DATE("Date"), INTEGER("Integer"), BOOLEAN("Boolean"), FLOAT("Float"),
	DOUBLE("Double"), ByteArray("byte[]");

	DataType(String dataType) {
		this.dataType = dataType;
	}

	public static DataType getDataType(String dataType) {
		switch (dataType) {
		case "CHAR":
		case "VARCHAR":
		case "LONGVARCHAR":
			return DataType.STRING;
		case "DATE":
			return DataType.DATE;
		case "TIMESTAMP":
			return DataType.TIMESTAMP;
		case "BINARY":
		case "VARBINARY":
		case "LONGVARBINARY":
		case "BLOB":
			return DataType.ByteArray;
		case "INTEGER":
			return DataType.INTEGER;
		case "FLOAT":
			return DataType.FLOAT;
		case "DOUBLE":
			return DataType.DOUBLE;
		default:
			return DataType.STRING;
		}
	}

	private String dataType;

	public String getDataType() {
		return dataType;
	}
	
}
