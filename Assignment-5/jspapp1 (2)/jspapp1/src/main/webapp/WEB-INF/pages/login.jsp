<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Beans </title>
</head>
<body>
	 <jsp:useBean id="lb" class="jspapp.loginBean" scope="session"/>
	
	<jsp:setProperty  name="lb" property="email" param="email"/>
	<jsp:setProperty name="lb" property="password" param="pass"/>
	${lb.authenticate() }
	<c:choose>
		<c:when test="${lb.user.role == 'voter' }">
		<c:redirect url="ctl?page=candlistBean" />
		</c:when>
		<c:when test="${lb.user.role == 'admin' }">
		<c:redirect url="ctl?page=result" />
		</c:when>
		<c:otherwise>
		<h3>${initParam.appTitle}</h3>
		<h3>Invalid Email or Password</h3>
		<a href="ctl?page=index">Login Again</a>
		</c:otherwise>
	
	</c:choose>
	
</body>
</html>