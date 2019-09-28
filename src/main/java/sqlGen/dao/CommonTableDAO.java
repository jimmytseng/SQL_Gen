package sqlGen.dao;

import java.sql.DatabaseMetaData;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class CommonTableDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Map<String, String> getAllTableOption() {
		DatabaseMetaData md = null;
		ResultSet rs = null;
		try {
			md = jdbcTemplate.getDataSource().getConnection().getMetaData();
			rs = md.getTables(null, "dbo", "%", null);
			HashMap<String, String> tableNameMap = new HashMap<String, String>();
			while (rs.next()) {
				tableNameMap.put(rs.getString("TABLE_NAME"), rs.getString("TABLE_NAME"));
			}
			return tableNameMap;
		} catch (SQLException e) {
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<String> getTableColumns(String tableName) {
//		StringBuilder queryBuilder = new StringBuilder(" SELECT [COLUMN_NAME] \n");
//		queryBuilder.append(" FROM [TestDB].[INFORMATION_SCHEMA].[COLUMNS] \n");
//		queryBuilder.append("  where [TABLE_NAME] = ? ");
		StringBuilder queryBuilder = new StringBuilder(
				"SELECT name FROM sys.dm_exec_describe_first_result_set(?, null, 1)");
		return this.jdbcTemplate.query(queryBuilder.toString(), new String[] { "SELECT * FROM dbo." + tableName },
				new int[] { java.sql.Types.VARCHAR }, new ResultSetExtractor<List<String>>() {
					@Override
					public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
						List<String> columnsList = new ArrayList<>();
						while (rs.next()) {
							columnsList.add(rs.getString(1));
						}
						return columnsList;
					}
				});
	}

	public Map<String, String> getTableByFilterName(String filterName) {
		ResultSet rs = null;
		try {
			DatabaseMetaData md = jdbcTemplate.getDataSource().getConnection().getMetaData();
			rs = md.getTables(null, "dbo", filterName + "%", null);
			HashMap<String, String> tableNameMap = new HashMap<String, String>();
			while (rs.next()) {
				tableNameMap.put(rs.getString("TABLE_NAME"), rs.getString("TABLE_NAME"));
			}
			return tableNameMap;
		} catch (SQLException e) {
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Map<String, String> getTabelColumnMetaData(String tableName) {
		String queryString = String.format("SELECT * FROM %s", tableName);
		return this.jdbcTemplate.query(queryString, new ResultSetExtractor<Map<String, String>>() {
			@Override
			public Map<String, String> extractData(ResultSet rs) throws SQLException, DataAccessException {
				Map<String, String> metaDataMap = new TreeMap<>();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				for (int i = 1; i <= columnCount; i++) {
					metaDataMap.put(rsmd.getColumnName(i), JDBCType.valueOf(rsmd.getColumnType(i)).getName());
				}
				return metaDataMap;
			}
		});
	}

}
