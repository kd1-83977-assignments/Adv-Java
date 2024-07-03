<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voting Candidates</title>
</head>
<body>
	
	<h3>${initParam.appTitle}</h3>
	<jsp:useBean id="lb" class="jspapp.loginBean" scope="session"/>
	
	<jsp:useBean id="vote" class="jspapp.VoteBean"/>
	
	<jsp:setProperty property="user" name="vote" value="${lb.user}"/>
	
	<jsp:setProperty property="candidateId" name="vote" param="candidate"/>
	
	
  ${vote.voting()}
	
	
	<c:choose>
		<c:when test="${vote.count == 1}">
			Voted sucessfully
			<c:redirect url="ctl?page=logout"/>
		</c:when>
		<c:when test="${vote.count == 5}">
			Voted already
			<c:redirect url="ctl?page=logout"/>
		</c:when>
		<c:otherwise>
			Vote Not registered <br/><br/>
			<a href="ctl?page=index">Vote </a>
		</c:otherwise>
	</c:choose>
	
</body>
</html>