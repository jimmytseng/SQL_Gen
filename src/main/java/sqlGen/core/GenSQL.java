package sqlGen.core;

import java.util.List;

import sqlGen.dto.GenSqlDTO;

abstract public class GenSQL {

	protected GenSqlDTO genSqlDTO;

	protected GenSQL(GenSqlDTO genSqlDTO) {
		this.genSqlDTO = genSqlDTO;
	}

	public static String NATIVE_GEN = "NATIVE";

	public static String JDBCTemplate_Gen = "JDBCTemplate";

	public static String JPA_Gen = "JPA";

	public String genSelect() {
		List<String> columnNames = this.genSqlDTO.getColumnName();
		StringBuilder builder = new StringBuilder();
		builder.append(" select ");
		if (columnNames.size() == 0) {

		} else {
			for (int i = 0; i < columnNames.size(); i++) {
				String column = columnNames.get(i);
				builder = concateColumn(column, builder);
				if (i != columnNames.size() - 1) {
					builder.append(" , ");
				}
			}
		}
		builder.append(" from ");

		builder = concateTable(builder);
		return builder.toString();
	}

	protected StringBuilder concateTable(StringBuilder builder) {
		builder.append(" " + genSqlDTO.getTableName() + " ");
		return builder;
	}

	protected StringBuilder concateColumn(String column, StringBuilder builder) {
		builder.append(" " + genSqlDTO.getTableName() + " ");
		return builder;

	}

	abstract public String genDelete();

	abstract public String genUpdate();

	abstract public String genInsert();

	public static GenSQL getInstance(String genType, GenSqlDTO dto) {
		GenSQL genSQL = null;
		switch (genType) {
		case "NATIVE":
			genSQL = new NativeGenSQL(dto);
			break;
		case "JDBCTemplate":
			genSQL = new JDBCTemplateGenSQL(dto);
			break;
		}
		return genSQL;

	}
}
