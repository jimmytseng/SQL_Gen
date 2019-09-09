package sqlGen.core;

import sqlGen.dto.GenSqlDTO;

abstract public class GenSQL {

	protected GenSqlDTO genSqlDTO;

	protected GenSQL(GenSqlDTO genSqlDTO) {
		this.genSqlDTO = genSqlDTO;
	}

	public static String JPA_Gen = "JPA";

	abstract public String genSelect();

	abstract public String genDelete();

	abstract public String genUpdate();

	abstract public String genInsert();

	public static GenSQL getInstance(String genType, GenSqlDTO dto) {
		GenSQL genSQL = null;
		switch (genType) {
		case "NATIVE":
			genSQL = new NativeGenSQL(dto);
			break;
		case "JDBCTMEPLATE":
			genSQL = new JDBCTemplateGenSQL(dto);
			break;
		}
		return genSQL;
	}

	protected String genSql() {
		String dmlType = this.genSqlDTO.getDmlType();
		switch (dmlType) {
		case GenSqlDTO.DML_SELECT:
			return genSelect();
		case GenSqlDTO.DML_DELETE:
			return genDelete();
		case GenSqlDTO.DML_UPDATE:
			return genUpdate();
		case GenSqlDTO.DML_INSERT:
			return genInsert();
		default:
			throw new RuntimeException();
		}
	}
}
