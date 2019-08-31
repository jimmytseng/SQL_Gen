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
			<tr id="tableNameTR" style="display:block">
				<td>
					<form:select path="tableName">
					<form:option value="choose_table" />
					<form:options items="${tableOption}" />
					</form:select>
				</td>
				<td>
				    <input type="text" id="filterText">
				</td>
			</tr>
			<tr><td>DML_TYPE</td></tr>
			<tr>
				<td>
					<form:radiobutton path="dmlType" value="${GenSqlDTO.DML_SELECT}"
						label="${GenSqlDTO.DML_SELECT}"></form:radiobutton>
					<form:radiobutton path="dmlType" value="${GenSqlDTO.DML_SELECT}"
						label="${GenSqlDTO.DML_INSERT}"></form:radiobutton>	
					<form:radiobutton path="dmlType" value="${GenSqlDTO.DML_UPDATE}"
						label="${GenSqlDTO.DML_UPDATE}"></form:radiobutton>
					<form:radiobutton path="dmlType" value="${GenSqlDTO.DML_DELETE}"
						label="${GenSqlDTO.DML_DELETE}"></form:radiobutton>
				</td>	
			</tr>
			<tr><td>letter choose</td></tr>
			<tr>
				<td>
					<form:radiobuttons path="isUpperCase" items="${GenSqlDTO.letterMap}"></form:radiobuttons>
				</td>	
			</tr>
			<tr id="columnRow" style="display:block">
			</tr>
			<tr style="display:block"><td class="keywork">and</td><td class="keywork">or</td><td class="keywork">like</td></tr>
			<tr><td>where condition</td></tr>
			<tr><td><form:textarea path="whereCondition" rows="5" cols="100" id="whereCondition"/></td></tr>
			
			<tr>
				<td><input type="button" value="產生SQL" onclick="summitForm(this.fom)" /></td>
			</tr>
		</table>
	</form:form>
</body>
<script>
	$(document).ready(function() {
		$("#tableName").on('change', function() {
			var tableName = $(this).children("option:selected").val();
			$.ajax({
				type : "GET",
				url : "${pageContext.request.contextPath}/sqlRest/getColumns",
				data : {
					"tableName" : tableName
				},
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				success : function(data) {
					var columns = [];
					$("#columnRow").empty();
					$.each(data, function(index, value) {
						columns.push($('<td>').html(value).on('dblclick',appendWhereCondition));
					})
					$("#columnRow").append(columns);
				}
			});
		})
		
		$(".keywork").on('dblclick',appendWhereCondition);
	    $("#filterText").on('blur',function(){
	    	var filterName=$("#filterText").val();
	    	$.ajax({
				type : "GET",
				url : "${pageContext.request.contextPath}/sqlRest/getTables",
				data : {
					"filterName" : filterName
				},
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				success : function(data) {
// 					var columns = [];
// 					$("#columnRow").empty();
// 					$.each(data, function(index, value) {
// 						columns.push($('<td>').html(value).on('dblclick',appendWhereCondition));
// 					})
// 					$("#columnRow").append(columns);
				alert(data);
				}
			});
	    })
		function appendWhereCondition(){
					var whereCondition = $("#whereCondition").val();
					whereCondition = whereCondition +" "+ $(this).text()+" ";
					console.log(whereCondition);
					$("#whereCondition").val(whereCondition) ;
	    }
		
	})
	
	function summitForm(form){
		var tableName = $("#tableName :selected").text();
		if("choose_table"==tableName){
			alert("請選擇表單");
		}
		console.log(tableName);
	}
</script>
</html>

