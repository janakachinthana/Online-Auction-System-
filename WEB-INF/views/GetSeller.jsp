<%@page import="com.oop.model.Seller"%>
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

<div id= "nev1">
	
	<div class="navbar1">
	<center>
	<table>
  	<tr><td><a  href="welcome.jsp"><i class="fa fa-fw fa-home"></i> Home</a></td>
  	<td><a href="AdminLogin.jsp" class="active"><i class="fa fa-fw fa-user"></i> Admin Panel</a></td>
  	<td><a href="SellerLogin.jsp"><i class="fa fa-fw fa-user"></i> Seller</a></td>
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
	<%
		Seller seller = (Seller) request.getAttribute("seller");
	%>

	<form method="POST" action="DeleteSellerServlet">
		<table>
			<tr>
				<td>Seller ID</td>
				<td><input type="text" name="sellerID" disabled="disabled"
					value="<%=seller.getSellerID()%>" /></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" disabled="disabled"
					value="<%=seller.getFirstName()%>" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" disabled="disabled"
					value="<%=seller.getLastName()%>" /></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><input type="text" name="email" disabled="disabled"
					value="<%=seller.getEmail()%>" /></td>
			</tr>
			
			
				</table>
		
				<input type="hidden" name="sellerID"
					value="<%=seller.getSellerID()%>" /> <input type="submit"
					value="Delete Seller" class="delete-button"/>
			
	</form>

	

	
	
	<br><br><br>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</center>
</body>
</html>