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

	<h3>${initParam.appTitle }</h3>
	<jsp:useBean id="n" class="jspapp.RegisterBean"/>
	<jsp:setProperty  name="n" property="firstName" param="firstname"/>
	<jsp:setProperty name="n" property="lastName" param="lastname"/>
	<jsp:setProperty  name="n" property="email" param="email"/>
	<jsp:setProperty name="n" property="password" param="pass"/>
	<jsp:setProperty name="n" property="birth" param="dob"/>
	
	${ n.register() }
	<c:choose>
		<c:when test="${n.cnt !=0 }">
		Registration Successfull
		<a href="ctl?page=index">Sign In</a>
		</c:when>
		<c:otherwise>
		Registration Failed
		<a href="ctl?page=newuser">Register Again</a>
		</c:otherwise>
	</c:choose>
</body>
</html>
