<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<link
	href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<tiles:insertAttribute name="header" />
		</div>
		<div class="row">
			<div class="col-3">
				<tiles:insertAttribute name="menu" />
			</div>
			<div class="col-9">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
		<div class="row">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>