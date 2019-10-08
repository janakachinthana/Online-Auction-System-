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
<body class="body">
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<center>
	
	<div id = "janaka">

	<h2 class="h2">Registration Page</h2>

	   <a>SLIIT OOP Auction System App for Object Orineted Progrmming</a>
	<br>
	<br>

	<form method="POST" action="AddPersonServlet">
		<table>

			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" /></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register" class="add-button" /> </td>
			</tr>
			<tr>	
				<td colspan="2"><input type="reset" value="Reset" class="reset-button" /></td>
			</tr>
		</table>
	</form>

	<form method="POST" action="ListPersonServlet">
		<table>
			<tr>
				<td colspan="2"><input type="submit" value="Login" class="list-button" />
				</td>
			</tr>
		</table>
	</form>

	<br><br><br><br><br><br>

</div>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</center>
</body>
</html>