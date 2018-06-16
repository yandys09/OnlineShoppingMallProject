<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<spring:url var="css" value="/resources/css" />

<!DOCTYPE html>
<html lang="kr">
<head>

<meta charset="UTF-8">

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">

<!-- Bootstrap Readable CSS -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<link href="${css}/jquery.dataTables.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">


<title>${title}</title>

</head>
<body>

<div class="wrapper">

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="contanier">
			<div class="navbar-header">
				<a class="navbar-brand" href="${contextRoot}/home">HOME</a>		
			</div>
	
		</div>
	
	</nav>  

	<div class="content">
		<div class ="container">
			<div class="row">
				<div class="col-xs-12">
					
					<div class="jumbotron">
						<h1>${errorTitle}</h1>
						<hr/>
						<blockquote style="word-wrap:break-word">
							${errorDescription}
						
						</blockquote>
					</div>
				
				</div>
			</div>
		</div>
	
	</div>
<div class="footer">
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
	</div>


</div>



</body>
</html>