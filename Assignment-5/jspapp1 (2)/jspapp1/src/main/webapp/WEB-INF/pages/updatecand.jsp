<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Candidate</title>
</head>
<body>
<h3>${initParam.appTitle}</h3>
	<jsp:useBean id="uc" class="jspapp.UpdateCandidateBean"/>
	<jsp:setProperty property="*" name="uc"/>
	${uc.UpdateCandidate() }
	<c:choose>
		<c:when test="${uc.count == 1 }">
		<c:redirect url="ctl?page=result"/>
		</c:when>
		<c:otherwise>
		Update Failed 
		<a href="ctl?page=result">Show Result</a>
		</c:otherwise>
	</c:choose>

</body>
</html>