<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	    <div class="container">
	       <div class="row">
	             <div class="form-group">
					<select name="tableName" id="tableName">
						 <c:forEach items="${tableOption}" var="table">
							　<option value="${table.key}">${table.value}</option>
						</c:forEach>	
					</select>
				</div>
	       </div>
	       <div class="row">
	            <input id="entityBtn" type="submit" class="btn btn-success" value="產生Entity" />
	       </div>
	    </div>
<script>
	$(document).ready(function() {
		$("#entityBtn").click(function(){
			var tableName = $("#tableName").val();
			getEntity(tableName);
		})
	});

	function getEntity(tableName){
		//window.open("/"+ contextPath + "/jpa/genEntity/" + tableName);
		$.ajax({
			type : "GET",
			url : "${pageContext.request.contextPath}/jpa/genEntity/"+tableName,
			contentType : "text/plain; charset=utf-8",
			success : function(data) {
				alert('entity file create success');
			}
		});
	}
</script>

