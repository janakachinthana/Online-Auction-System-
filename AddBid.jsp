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
	
	<a href="BuyerView.jsp">Back to Item List</a>
	<h2 class="h2">Add Bid Page</h2>

	  <a> SLIIT Auction System App for Object Orineted Progrmming </a>
	<br>
	<br>

	<form method="POST" action="AddBidServlet">
		<table>

			<tr>
				<td>Bid Price</td>
				<td><input type="number" name="bidPrice" required/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Bid" class="add-button" /> </td>
			</tr>
			<tr>	
				<td colspan="2"><input type="reset" value="Reset" class="reset-button" /></td>
			</tr>
		</table>
	</form>

	<form method="POST" action="ListBidServlet">
		<table>
			<tr>
				<td colspan="2"><input type="submit" value="List All Bids" class="list-button" />
				</td>
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