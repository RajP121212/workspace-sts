<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Location</title>
</head>
<body>
	<pre id="pre">
		<form action="updateLoc" method="post">
		
			Id: <input type="text" name="id" id="id" value="${locations.id}" readonly/>
			Code: <input type="text" name="location_code" id="location_code" value="${locations.location_code}"/>
			Name: <input type="text" name="location_name" id="location_name" value="${locations.location_name}"/>
			Type: 
				<input type="radio" name="location_type" value="Urban" id="location_type_urban" ${locations.location_type == "Urban"?"checked":""}/>Urban
				<input type="radio" name="location_type" value="Rural" id="location_type_rural" ${locations.location_type == "Rural"?"checked":""}/>Rural
			<button id="save">Save</button>
			
		</form>
	</pre>
</body>
</html>