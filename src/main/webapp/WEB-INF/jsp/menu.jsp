<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="wrapper">
	<nav id="sidebar" class="navbar navbar-light">
	    <div class="sidebar-header container">
            <h3>Menu Bar</h3>
        </div>
         <ul class="list-unstyled components">
	          <li class="active">
	                <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">SQL_Gen</a>
	                <ul class="collapse list-unstyled" id="homeSubmenu">
	                    <li><a href="${pageContext.request.contextPath}/sql/native">native_sql</a></li>
	                    <li><a href="${pageContext.request.contextPath}/sql/jdbctemplate">jdbc_template</a></li>
	                    <li><a href="${pageContext.request.contextPath}/sql/jpa">spring_jpa</a></li>
	                    <li><a href="${pageContext.request.contextPath}/sql/hibernate">hibernate</a></li>
	                </ul>
	          </li>
	          <li>
              </li>
          	  <li><a href="${pageContext.request.contextPath}/entity/native">Entity_Gen</a></li> 
         <!--      <li>
	               <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Pages</a>
	                <ul class="collapse list-unstyled" id="pageSubmenu">
	                    <li><a href="#">Page 1</a></li>
	                    <li><a href="#">Page 2</a></li>
	                    <li><a href="#">Page 3</a></li>
	                </ul>
          	  </li>
              <li>
              	    <a href="#">Portfolio</a>
              </li>
              <li>
                    <a href="#">Contact</a>
              </li>-->
         </ul>
	</nav>
</div>
