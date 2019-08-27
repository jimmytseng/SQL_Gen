<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sqlGen.dto.GenSqlDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="${pageContext.request.contextPath}/assets/js/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>native_sql</title>
</head>
<body>
	<form:form method="POST" action="/nativeSQL/genSql"
		modelAttribute="sqlGenDTO">
		<table>
            <tr id="tableNameTR"><tr>
			<tr>
				<form:radiobutton path="dmlType" value="${GenSqlDTO.DML_SELECT}"
					label="${GenSqlDTO.DML_SELECT}"></form:radiobutton>
				<form:radiobutton path="dmlType" value="${GenSqlDTO.DML_UPDATE}"
					label="${GenSqlDTO.DML_UPDATE}"></form:radiobutton>
				<form:radiobutton path="dmlType" value="${GenSqlDTO.DML_DELETE}"
					label="${GenSqlDTO.DML_DELETE}"></form:radiobutton>
			</tr>
			

			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>