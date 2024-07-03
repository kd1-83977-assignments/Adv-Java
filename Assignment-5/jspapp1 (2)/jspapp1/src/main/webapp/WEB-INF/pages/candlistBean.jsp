<%@page import="java.util.ArrayList"%>
<%@page import="com.sunbeam.pojos.Candidate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate List</title>
</head>
<body>
   <h3>${initParam.appTitle }</h3>
   <jsp:useBean id="lb" class="jspapp.loginBean" scope="session"/>
   <jsp:useBean id="cb" class="jspapp.CandidateListBean" scope="session"/>
   Hello, ${lb.user.firstName }  ${lb.user.lastName } <hr/>
	<form method="post" action="ctl?page=vote">
	${cb.fetchCandidates() }
	<c:forEach var="c" items="${cb.candidateList }">
	<input type="radio" name="candidate" value="${c.id}"/> ${c.name} - ${c.party} <br/>
	</c:forEach>
	<input type="submit" value="Vote"/>
	
	</form>
   
</body>
</html>