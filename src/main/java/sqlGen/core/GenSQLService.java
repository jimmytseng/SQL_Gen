package sqlGen.core;

import sqlGen.dto.GenSqlDTO;

public class GenSQLService {

	public String genSQLStr(GenSqlDTO dto) {
		GenSQL genSQLObject = GenSQL.getInstance(dto.getGenType(), dto);
		String result =  genSQLObject.genSql();
		if (dto.getIsUpperCase() == 2)
			return result.toLowerCase();
		if (dto.getIsUpperCase() == 3)
			return  result.toUpperCase();
		return result;
	}
}
