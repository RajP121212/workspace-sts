<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display Locations</title>
</head>
<body>

	<h3>Locations:</h3>
	<table>
		<tr>
			<th>Id</th>
			<th>Code</th>
			<th>Name</th>
			<th>Type</th>
		</tr>
		<c:forEach items="${locations}" var="location">
			<tr> 
				<td>${location.id}</td> 
				<td>${location.location_code}</td>
				<td>${location.location_name}</td>
				<td>${location.location_type}</td>
				<td><a href="deleteLocation?id=${location.id}">Delete Location</a></td>
				<td><a href="showUpdate?id=${location.id}">Update Location</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	

</body>
</html>