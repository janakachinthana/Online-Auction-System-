<%@page import="com.oop.model.Bid"%>
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
  	<td><a href="AdminLogin.jsp"><i class="fa fa-fw fa-user"></i> Admin Panel</a></td>
  	<td><a href="SellerLogin.jsp"><i class="fa fa-fw fa-user"></i> Seller</a></td>
  	<td><a class="active" href="BuyerLogin.jsp"><i class="fa fa-fw fa-user"></i> Buyer</a></td>
  	</tr>
  	</table>
  	</center>
  	</div>
	</div>
	<jsp:include page="/WEB-INF/views/SideLeftNev.jsp"></jsp:include>
	<center>
	
	<div id = "janaka"><br><br><br>
	
	<a href="ListBids.jsp">Back to Bid List</a>

	<h2 class="h2">Get Bid Page</h2>

	SLIIT OOP Auction System App for OOP jsp servlet.
	<br>
	<br>
	<%
		Bid bid = (Bid) request.getAttribute("bid");
	%>

	<form method="POST" action="UpdateBidServlet">
		<table>
			<tr>
				<td>Bid ID</td>
				<td><input type="text" name="bidID" disabled="disabled"
					value="<%=bid.getBidID()%>" /></td>
			</tr>
			<tr>
				<td>Bid Price</td>
				<td><input type="text" name="bidPrice"
					value="<%=bid.getBidPrice()%>" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden" name="bidID"
					value="<%=bid.getBidID()%>" /> <input type="submit"
					value="Update Bid" class="update-button"/></td>
			</tr>
		</table>
	</form>

	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="DeleteBidServlet">
					<input type="hidden" name="bidID"
						value="<%=bid.getBidID()%>" /> <input type="submit"
						value="Delete Bid" class="delete-button"/>
				</form>
			</td>
		</tr>
	</table>
	
	<br><br><br>
	
	
	
	<br><br><br>
	
	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</center>
	
</body>
</html>