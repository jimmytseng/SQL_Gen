package sqlGen.core;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import sqlGen.dto.GenSqlDTO;

public class NativeGenSQL extends GenSQL {

	protected NativeGenSQL(GenSqlDTO genSqlDTO) {
		super(genSqlDTO);
	}

	@Override
	public String genSelect() {
		List<String> columnNames = this.genSqlDTO.getColumnName();
		StringBuilder builder = new StringBuilder();
		builder.append(" select ");
		if (columnNames.size() > 0)
			concateColumn(builder);
		else
			builder.append(" * ");
		builder.append(" from ");
		builder = concateTable(builder);
		builder = concateWhereConditon(builder);
		return builder.toString();
	}

	@Override
	public String genDelete() {
		StringBuilder builder = new StringBuilder();
		builder.append(" delete  from ");
		builder = concateTable(builder);
		builder = concateWhereConditon(builder);
		return builder.toString();
	}

	@Override
	public String genUpdate() {
		StringBuilder builder = new StringBuilder();
		List<String> columnNames = this.genSqlDTO.getColumnName();
		builder.append(" update ");
		builder = concateTable(builder);
		builder.append(" set ");
		if (columnNames.size() == 0) {
			throw new RuntimeException();
		} else {
			for (int i = 0; i < columnNames.size(); i++) {
				String column = columnNames.get(i);
				builder.append(column + " = ? ");
				if (i != columnNames.size() - 1) {
					builder.append(", ");
				}
			}
		}
		builder = concateWhereConditon(builder);
		return builder.toString();
	}

	@Override
	public String genInsert() {
		StringBuilder builder = new StringBuilder();
		List<String> columnNames = this.genSqlDTO.getColumnName();
		builder.append(" insert into  ");
		builder = concateTable(builder);
		if (this.genSqlDTO.getColumnName().size() > 0) {
		builder.append("( ");
		concateColumn(builder);
		builder.append(" )");
		}
		builder.append("values (");
		for (int i = 0; i < columnNames.size(); i++) {
			builder.append("?");
			if (i != columnNames.size() - 1) {
				builder.append(", ");
			}
		}
		builder.append(")");
		return builder.toString();
	}

	private StringBuilder concateTable(StringBuilder builder) {
		builder.append(" " + genSqlDTO.getTableName() + " ");
		return builder;
	}

	private StringBuilder concateColumn(StringBuilder builder) {
		List<String> columnNames = this.genSqlDTO.getColumnName();
		for (int i = 0; i < columnNames.size(); i++) {
			String column = columnNames.get(i);
			builder.append(column);
			if (i != columnNames.size() - 1) {
				builder.append(", ");
			}
		}
		return builder;
	}



	private StringBuilder concateWhereConditon(StringBuilder builder) {
		String whereCondition = this.genSqlDTO.getWhereCondition();
		builder.append(" where");
		if (StringUtils.isNotBlank(whereCondition))
			builder.append(" " + whereCondition + " ");
		return builder;
	}
}
