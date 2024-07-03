<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Candidate</title>
</head>
<body>

	<h3>${initParam.appTitle} </h3>
	<jsp:useBean id="dc" class="jspapp.DeleteCandidateBean"/>
	<jsp:setProperty property="*" name="dc"/>
	
	${dc.DeleteCand() }
	<c:choose>
		<c:when test="${dc.count ==1 }">
			<c:redirect url="ctl?page=result"/>
		</c:when>
		<c:otherwise>
		delete Failed 
		<a href="ctl?page=result">Delete Candidate</a>
		</c:otherwise>
		
	</c:choose>
	

</body>
</html>