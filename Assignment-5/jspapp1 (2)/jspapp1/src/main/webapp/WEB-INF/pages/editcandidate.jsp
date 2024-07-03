<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Candidate</title>
</head>
<body>
	<h3>Edit Candidates,Admin</h3>
	<jsp:useBean id="ec" class="jspapp.FindCandidateBean"/>
	<jsp:setProperty property="id" name="ec" param="id"/>
	${ec.findCandidate() }
	
	<form method="post" action="ctl?page=updatecand">
	<input type="hidden" name="id" value="${ec.candidate.id}"/>
	Name:<input type="text" name="name" value="${ec.candidate.name }"/>
	Party:<input type="text" name="party" value="${ec.candidate.party }"/>
	Votes:<input type="text" name="votes" value="${ec.candidate.votes }"/>
	<input type="submit" value="Update Candidate"/>
	
	</form>
	

</body>
</html>