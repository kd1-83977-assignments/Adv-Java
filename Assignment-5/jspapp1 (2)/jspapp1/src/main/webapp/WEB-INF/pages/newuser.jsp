<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register New User</title>
</head>
<body>
	<h3>${initParam.appTitle}</h3>
	
<form method="post" action="ctl?page=register" >
	First Name: <input type="text" name ="firstname"/>  <br/><br/>
	Last Name: <input type="text" name ="lastname"/>  <br/><br/>
	Email:<input type="text" name="email" > <br/><br/>
	Password: <input type="password" name ="pass"/>  <br/><br/>
	Date of Birth: <input type="date" name="dob"/>  <br/><br/>
	
	
	<input type="submit" value="Register"/>

</form>

</body>
</html>