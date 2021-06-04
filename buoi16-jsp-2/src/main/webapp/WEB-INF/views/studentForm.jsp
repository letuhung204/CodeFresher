<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/css/style.css">

<title>Document</title>
</head>
<body>

	<form:form method="post" action="save/student" modelAttribute="student" >
		 <label for="id">id</label>
		  <input type="text" id="id" name="id" path="id" readonly="true" hidden="true">
			
		  <label for="firstName">First name:</label><br>
		  <form:input type="text" path="firstName" id="firstName" name="firstName" required="true" />
		  
		  <label for="lname">Last name:</label>
		  <form:input type="text" id="lname" name="lname" path="lastName" />
		  
		  <label for="age">Age:</label>
		  <form:input type="text" id="age" name="age" path="age" />
		  
		  <label for="lophoc">Lop Hoc:</label>
		  <form:input type="text" id="lophoc" name="lophoc" path="lopHoc" />
		 
		  <button type="submit" >save</button>
	</form:form>
</body>
</html>