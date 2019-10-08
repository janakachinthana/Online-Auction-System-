
</html>a<%@page import="com.oop.model.Item"%>
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
  	<td><a class="active" href="SellerLogin.jsp"><i class="fa fa-fw fa-user"></i> Seller</a></td>
  	<td><a href="BuyerLogin.jsp"><i class="fa fa-fw fa-user"></i> Buyer</a></td>
  	</tr>
  	</table>
  	</center>
  	</div>
	</div>
	
	
	<jsp:include page="/WEB-INF/views/SideLeftNev.jsp"></jsp:include>
	<center>
	
	<div id = "addItem"><br><br><br>

	<a href="SellerView.jsp">Back to Item List</a>

	<h2 class="h2">Get Item Page</h2>

	SLIIT OOP Auction System App for OOP jsp servlet.
	<br>
	<br>
	<%
		Item item = (Item) request.getAttribute("item");
	%>

	<form method="POST" action="SellerUpdateItemServlet">
		<table>
			<tr>
				<td>Item ID</td>
				<td><input type="text" name="itemID" disabled="disabled" id="cursor"
					value="<%=item.getItemID()%>" /></td>
			</tr>
			<tr>
				<td>Item Image</td>
				<td><input type="file" name="itemImage"
					value="<%=item.getItemID()%>" /></td>
			</tr>
			<tr>
				<td>Item Name</td>
				<td><input type="text" name="itemName"
					value="<%=item.getName()%>" /></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="price"
					value="<%=item.getPrice()%>" /></td>
			</tr>
			<tr>
				<td>Closing Date</td>
				<td><input type="date" name="date"
					value="<%=item.getDate()%>" /></td>
			</tr>
			<tr>
				<td>Item Description</td>
				<td>
				<textarea 
				name="description" 
				id = "discrip1"
				rows = "10"
                cols = "20"><%=item.getDescription()%></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden" name="itemID"
					value="<%=item.getItemID()%>" /> <input type="submit"
					value="Update Item" class="update-button"/></td>
			</tr>
		</table>
	</form>

	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="SellerDeleteItemServlet">
					<input type="hidden" name="itemID"
						value="<%=item.getItemID()%>" /> <input type="submit"
						value="Delete Item" class="delete-button"/>
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