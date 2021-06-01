<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page contentType="text/html; charset=UTF-8" %>

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
	<h1>Hello codeFresher ! JSP PAGE</h1>
	<h1>${name_map_view}</h1>

	<h1>
		<c:out value="${name_map_view}"></c:out>
	</h1>

	<h2>show information Student</h2>
	<strong>${student_map.id}</strong>
	<br>
	<strong><c:out value="${student_map.name}"></c:out></strong>
	<br>
	<strong><c:out value="${student_map.fullName}"></c:out></strong>
	<br>
	<strong><c:out value="${student_map.age}"></c:out></strong>
	<br>

	<table style="width: 50%; border: 1px">
		<tr>
			<th>stt</th>
			<th>id</th>
			<th>name</th>
			<th>full name</th>
			<th>age</th>
		</tr>

		<c:forEach items="${list_student}" var="studentDinhDanh" varStatus="s">
			<tr>
				<td>${s.index + 1}</td>
				<td>${studentDinhDanh.id}</td>
				<td style="color: red">${studentDinhDanh.name}</td>
				<td>${studentDinhDanh.fullName}</td>
				<td>${studentDinhDanh.age}</td>
			</tr>
			<c:if test="${studentDinhDanh.name == 'Chien'}">
				<h1>check condition name is Chien !</h1>
			</c:if>
		</c:forEach>
		
	</table>
	
	<c:choose>
		<c:when test="${student_map.id==1}">
				<h1>this id =1</h1>
		</c:when>
		<c:otherwise>
			<h1>XIN CHÀO CÁC BẠN</h1>
		</c:otherwise>
	</c:choose>

	<!-- them file vao trang web --> 
	<%@ include file="hello.jsp" %>
</body>
</html>