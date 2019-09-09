<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sqlGen.dto.GenSqlDTO,sqlGen.core.GenSQL"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	<form:form method="POST" action="${pageContext.request.contextPath}/sql/genNativeSql"
		modelAttribute="sqlGenDTO">
		<form:hidden path="genType" value="${GenSqlDTO.NATIVE_GEN}" />
		<table>
			<tr id="tableNameTR" style="display:block">
				<td>
				    <div class="form-group">
					<form:select path="tableName" class="form-control">
					<form:option value="choose_table" class="form-control"/>
					<form:options items="${tableOption}" />
					</form:select>
					</div>
				</td>
				<td>
				    <div class="form-group">
				    <input type="text" id="filterText" class="form-control">
				    </div>
				</td>
			</tr>
			<tr><td>DML_TYPE</td></tr>
			<tr>
				<td>
					<form:radiobutton path="dmlType" value="${GenSqlDTO.DML_SELECT}"
						label="${GenSqlDTO.DML_SELECT}"></form:radiobutton>
					<form:radiobutton path="dmlType" value="${GenSqlDTO.DML_INSERT}"
						label="${GenSqlDTO.DML_INSERT}"></form:radiobutton>	
					<form:radiobutton path="dmlType" value="${GenSqlDTO.DML_UPDATE}"
						label="${GenSqlDTO.DML_UPDATE}"></form:radiobutton>
					<form:radiobutton path="dmlType" value="${GenSqlDTO.DML_DELETE}"
						label="${GenSqlDTO.DML_DELETE}"></form:radiobutton>
				</td>	
			</tr>
			<tr id="columnSelected" style="display:block">
			
			</tr>
			<tr><td>letter choose</td></tr>
			<tr>
				<td>
					<form:radiobuttons path="isUpperCase" items="${GenSqlDTO.letterMap}"></form:radiobuttons>
				</td>	
			</tr>
			<tr id="columnRow" style="display:block">
			</tr>
			<tr style="display:block">
				<td class="keywork btn btn-outline-dark" title="and">and</td>
				<td class="keywork btn btn-outline-dark" title="or">or</td>
				<td class="keywork btn btn-outline-dark" title="like '%%'">like '%%'</td>
				<td class="keywork btn btn-outline-dark" title="in(,)">in(,)</td>
				<td class="keywork btn btn-outline-dark" title="=">=</td>
				<td class="keywork btn btn-outline-dark" title="=">''</td>
			</tr>
			<tr id="whereRow">
				<td>
				    <div class="form-group">
				    	 <div>
				             <label for="whereCondition">where condition:</label>
				         </div>  
					     <form:textarea path="whereCondition" class="form-control" rows="5" cols="100" id="whereCondition"/>
					</div>
				</td>
			</tr>
			<tr>
				<td><input type="button" class="btn btn-success" value="產生SQL" onclick="summitForm(this.form)" /></td>
			</tr>
			<tr>
				<td>
				    <div class="form-group">
				         <div>
				             <label for="sqlResult">result:</label>
				         </div>
					     <form:textarea path="sqlResult" class="form-control" rows="5" cols="100" id="sqlResult"/>
					</div>
				</td>
			</tr>
		</table>
	</form:form>
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
					var columnsCheckboxes =[];
					$("#columnRow").empty();
					$.each(data, function(index, val) {
						columns.push($('<td>').html(val).addClass("btn btn-outline-dark").on('dblclick',appendWhereCondition));
						 var myTD = document.createElement("td"); 
						 var checkbox = document.createElement('input'); 
				            checkbox.type = "checkbox"; 
				            checkbox.name = "columnName"; 
				            checkbox.value = val; 
				            checkbox.id = val; 
				         var label = document.createElement('label');  
				             label.htmlFor = val; 
				             label.innerHTML = val;
				             myTD.appendChild(checkbox); 
				             myTD.appendChild(label); 
				         columnsCheckboxes.push(myTD);
				    });
					console.log("data:"+data);
					if(data!=""){
					 var myTD = document.createElement("td");
					 var selectAllCheckbox = document.createElement('input'); 
					 	selectAllCheckbox.type = "checkbox"; 
			            selectAllCheckbox.id = "checkall"; 
			         var label = document.createElement('label');  
			            label.htmlFor = "checkall"; 
			            label.innerHTML = "全選";
			          $(selectAllCheckbox).bind('change',function(){
			        	  if($(this).prop('checked')){
			        		  checkboxesChecked();
			        	  }else{
			        		  checkboxesUnchecked();
			        	  }
			          })  
			          myTD.appendChild(selectAllCheckbox); 
			          myTD.appendChild(label);    
					}
					$("#columnRow").append(columns);
					$("#columnSelected").empty();
					$("#columnSelected").append(myTD);
					$("#columnSelected").append(columnsCheckboxes);
					
		    	}
			});
		});
		
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
				var retureData = data;
				console.log(retureData);
				$("#tableName").empty();
				$.each(retureData,function(key,data){
					console.log(key);
					console.log(data);
					 $('#tableName').append($('<option>', { 
					        value: key,
					        text : data 
					 })).change();
				});
				$("#whereCondition").val('');
				}
			});
	    })
		function appendWhereCondition(){
					var whereCondition = $("#whereCondition").val();
					whereCondition = whereCondition +" "+ $(this).text()+" ";
					console.log(whereCondition);
					$("#whereCondition").val(whereCondition) ;
	    }
	    
	    $("#dmlType4").on('click',function(){
	    	checkboxesUnchecked();
	    	$("#columnSelected").hide();
	    })
	    
	    $("#dmlType1,#dmlType3").on('click',function(){
	    	$("#columnSelected").show();
	    	$("#whereRow").show();
	    })
		
	    $("#dmlType2").on('click',function(){
	    	$("#whereRow").hide();
	    	$("#columnSelected").show();
	    })
	})
	
	function checkboxesUnchecked(){
		$("#checkall").prop("checked", false);
		$("input[name='columnName']").prop("checked", false);
	}
	
	function checkboxesChecked(){
		$("#checkall").prop("checked", true);
		$("input[name='columnName']").prop("checked", true);
	}
	
	function summitForm(form){
		var tableName = $("#tableName :selected").text();
		if("choose_table"==tableName){
			alert("請選擇表單");
			return;
		}
		var dmlType = $("input[name='dmlType']:checked").val();
		if( typeof(dmlType) == "undefined"){
			 alert("請選擇DML_Type");
				return;
		 }
		var checkedColumns = $("input[name='columnName']:checked").val();
		if(typeof(checkedColumns) == "undefined"){
			if(dmlType=="${GenSqlDTO.DML_INSERT}"){
				checkboxesChecked();
			}else if(dmlType=="${GenSqlDTO.DML_UPDATE}"){
				checkboxesChecked();
			}
		 }
		clearResult();
		form.submit();
	}
	
	function clearResult(){
		 $("#sqlResult").val('');
	}
</script>

