<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <form:form method="POST" action="${pageContext.request.contextPath}/entity/genJpaEntity">
	    <div class="container">
	       <div class="row">
	             <div class="form-group">
					<select name="tableName">
						 <c:forEach items="${tableOption}" var="table">
							　<option value="${table.key}">${table.value}</option>
						</c:forEach>	
					</select>
				</div>
	       </div>
	       <div class="row">
	            <input type="submit" class="btn btn-success" value="產生Entity" />
	       </div>
	    </div>
	</form:form>
<script>
	$(document).ready(function() {
		
	}
</script>

