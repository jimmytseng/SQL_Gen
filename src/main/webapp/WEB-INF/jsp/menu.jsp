<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="wrapper">
	<nav id="sidebar" class="navbar navbar-light">
	    <div class="sidebar-header container">
            <h3>Menu Bar</h3>
        </div>
         <ul class="list-unstyled components">
	          <li class="active">
	                <a href="#SQL_Gen" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">SQL_Gen</a>
	                <ul class="collapse list-unstyled" id="SQL_Gen">
	                    <li><a href="${pageContext.request.contextPath}/sql/native">native_sql</a></li>
	                    <li><a href="${pageContext.request.contextPath}/sql/jdbctemplate">jdbc_template</a></li>
	                </ul>
	          </li>
	          <li class="active">
	          		<a href="#Entity_Gen" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Entity_Gen</a>
	          		<ul class="collapse list-unstyled" id="Entity_Gen">
          	      		 <li><a href="${pageContext.request.contextPath}/entity/jpa">JpaEntity</a></li>
          	        </ul>
          	  </li> 
         </ul>
	</nav>
</div>
