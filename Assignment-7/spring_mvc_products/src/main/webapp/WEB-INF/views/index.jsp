<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>
		Welcome !
		
	</h5>
	
	<c:url var="url" value="/posts/list?minVal=1000&maxVal=10000"/>
		<h4>
		<a href="${url}">Get Products List</a>
		</h4>
</body>
</html>