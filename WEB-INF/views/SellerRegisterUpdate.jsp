<%@page import="com.oop.model.Seller"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel = "stylesheet"
   type = "text/css"
   href = "Item.css" />
<meta charset="UTF-8">
<title>SLIIT OOP Auction System</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<center>
	<div id= "nev1">
	
	<div class="navbar1">
	
<table>
  	<tr><td><a  href="welcome.jsp"><i class="fa fa-fw fa-home"></i> Home</a></td>
  	<td><a href="AdminLogin.jsp"><i class="fa fa-fw fa-user"></i> Admin Panel</a></td>
  	<td><a class="active" href="SellerLogin.jsp"><i class="fa fa-fw fa-user"></i> Seller</a></td>
  	<td><a href="BuyerLogin.jsp"><i class="fa fa-fw fa-user"></i> Buyer</a></td>
  	</tr>
  	</table>
  	</center>
  	</div>
	</div>
	<jsp:include page="/WEB-INF/views/SideLeftNev.jsp"></jsp:include>
	
	<center>
	<div id ="janaka">
	

	<h2 class="h2">Get Seller Page</h2>

	SLIIT OOP Auction System App for OOP jsp servlet.
	<br>
	<br>
	<br><br>
	<div id ="confirm">
	<%
		Seller seller = (Seller) request.getAttribute("seller");
	%>

	<form method="POST" action="SellerRegisterSuccessServlet">
		<table>
			<tr>
				<td>Seller ID</td>
				<td><input type="text" name="sellerID" disabled="disabled"
					value="<%=seller.getSellerID()%>" /></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" pattern="[a-zA-Z]+( ?[a-zA-Z]+)" title="Upercase letters and lowercase letters only" required
					value="<%=seller.getFirstName()%>" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" pattern="[a-zA-Z]+( ?[a-zA-Z]+)" title="Upercase letters and lowercase letters only" required
					value="<%=seller.getLastName()%>" /></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><input type="email" name="email" required
					value="<%=seller.getEmail()%>" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" disabled="disabled"
					value="<%=seller.getPassword()%>" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden" name="sellerID"
					value="<%=seller.getSellerID()%>" /> <input type="submit"
					value="Confirm" class="update-button" onclick = "myFunctionj()"/></td>
			</tr>
		</table>
	</form>

	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="RegisterDeleteServlet">
					<input type="hidden" name="sellerID"
						value="<%=seller.getSellerID()%>" /> <input type="submit"
						value="Cancel" class="delete-button"/>
				</form>
			</td>
		</tr>
	</table>
	</div>
	<br><br><br>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</center>
</body>
</html>