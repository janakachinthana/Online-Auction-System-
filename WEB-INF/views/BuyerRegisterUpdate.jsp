<%@page import="com.oop.model.Buyer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<link rel = "stylesheet"
   type = "text/css"
   href = "Item.css" />
<meta charset="UTF-8">
<title>SLIIT OOP Auction System</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	
		<div id= "nev1">
	
	<div class="navbar1">
	<center>
<table>
  	<tr><td><a  href="welcome.jsp"><i class="fa fa-fw fa-home"></i> Home</a></td>
  	<td><a href="AdminLogin.jsp"><i class="fa fa-fw fa-user"></i> Admin Panel</a></td>
  	<td><a href="SellerLogin.jsp"><i class="fa fa-fw fa-user"></i> Seller</a></td>
  	<td><a href="BuyerLogin.jsp" class="active"><i class="fa fa-fw fa-user"></i> Buyer</a></td>
  	</tr>
  	</table>
  	</center>
  	</div>
	</div>
	
	<jsp:include page="/WEB-INF/views/SideLeftNev.jsp"></jsp:include>
	<center>
	
	<div id ="janaka">

	<h2 class="h2">Get Buyer Page</h2>

	SLIIT OOP Auction System App for OOP jsp servlet.
	<br>
	<br>
	<%
		Buyer buyer = (Buyer) request.getAttribute("buyer");
	%>

	<form method="POST" action="BuyerRegisterSuccessServlet">
		<table>
			<tr>
				<td>Buyer ID</td>
				<td><input type="text" name="buyerID" disabled="disabled"
					value="<%=buyer.getBuyerID()%>" /></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" pattern="[a-zA-Z]+( ?[a-zA-Z]+)" title="Upercase letters and lowercase letters only" required
					value="<%=buyer.getFirstName()%>" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" pattern="[a-zA-Z]+( ?[a-zA-Z]+)" title="Upercase letters and lowercase letters only" required
					value="<%=buyer.getLastName()%>" /></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><input type="email" name="email" encripted required
					value="<%=buyer.getEmail()%>" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" disabled="disabled"
					value="<%=buyer.getPassword()%>" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden" name="buyerID"
					value="<%=buyer.getBuyerID()%>" /> <input type="submit"
					value="Confirm" class="update-button" onclick = "myFunctionj()"/></td>
			</tr>
		</table>
	</form>

	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="RegisterDeleteServlet">
					<input type="hidden" name="buyerID"
						value="<%=buyer.getBuyerID()%>" /> <input type="submit"
						value="Cancel" class="delete-button"/>
				</form>
			</td>
		</tr>
	</table>
	
	<br><br><br>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</center>
</body>
</html>