<%@page import="com.oop.model.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "Item.css" />
<meta charset="UTF-8">
<title>SLIIT OOP Auction System</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<center>
	
	<div id ="janaka">

	<h2 class="h2">Get Person Page</h2>

	SLIIT OOP Auction System App for OOP jsp servlet.
	<br>
	<br>
		
		<h1> Registration Successfully </h1>
	<form method="POST" action="welcome.jsp">
		<table>
			<tr>
				<td colspan="2"><input type="submit"value="Login" class="update-button"/></td>
			</tr>
		</table>
	</form>

	<br><br><br>

	
	
	<br><br><br>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</center>
</body>
</html>