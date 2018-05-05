<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<!DOCTYPE html>
<html lang="kr">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>${title}</title>
<script type="text/javascript">
	window.menu = '${title}';

</script>
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
	<!-- Navigation -->
	<%@include file="./shared/navbar.jsp"%>

	<!-- Page Content -->
	<!-- Loading the home content -->
	<c:if test="${userClickHome == true}">
		<%@include file="home.jsp"%>
	</c:if>
	
	<!-- Load only when user clicks about -->
	<c:if test="${userClickAbout == true}">
		<%@include file="about.jsp"%>
	</c:if>
	
	<!-- Load only when user clicks contact -->
	<c:if test="${userClickContact == true}">
		<%@include file="contact.jsp"%>
	</c:if>
	<!-- /.container -->

	<!-- Footer -->
	<%@include file="./shared/footer.jsp"%>

	<!-- Bootstrap core JavaScript -->
	<script src="${js}/jquery.js"></script>
	<script src="${js}/bootstrap.bundle.min.js"></script>
	<script src="${js}/myapp.js"></script>

</body>

</html>