<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Location</title>
</head>
<body>
	<pre id="pre">
		<form action="saveLocation" method="post">
		
			Id: <input type="text" name="id" id="id"/>
			Code: <input type="text" name="location_code" id="location_code"/>
			Name: <input type="text" name="location_name" id="location_name"/>
			Type: 
				<input type="radio" name="location_type" value="Urban" id="location_type_urban"/>Urban
				<input type="radio" name="location_type" value="Rural" id="location_type_rural"/>Rural
			<button id="save">Save</button>
			
		</form>
		${msg}
		<br>
		<a href="displayLocations">View All</a>
	</pre>
</body>
</html>