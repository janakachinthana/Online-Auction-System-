<%@page import="com.oop.model.Item"%>
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
	
	<div id = "adminItem">
	<div id = "adminItem1">
	<a href="adminCategory.jsp">Back to Category</a>
	<br>
	<h2 id ="adminItemtable1">Item Details<br>
	--------------------</h2>

	
	<%
		Item item = (Item) request.getAttribute("item");
	%>

	<form method="POST" action="DeleteItemServlet">
		<table border="1">
			<tr>
				<td><h2 id ="adminItemtable">Item ID  :</h2></td>
				<td>

					<h3 id ="adminItemtable1"><%=item.getItemID()%></h1></td>
			</tr>
			<tr>
				<td><h2 id ="adminItemtable">Item Name  :</h2></td>
				<td>
					<h3 id ="adminItemtable1"><%=item.getName()%></h1></td>
			</tr>
			<tr>
				<td><h2 id ="adminItemtable">Price  :</h2></td>
				<td><h3 id ="adminItemtable1"><%=item.getPrice()%></h1></td>
					
			</tr>
			
			<tr>
				<td><h2 id ="adminItemtable">Closing Date  :</h2></td>
				<td><h3 id ="adminItemtable1"><%=item.getDate()%></h1></td>
					
			</tr>
			<tr>
				<td><h2 id ="adminItemtable">Item Description  :  </h2></td>
				<td><h3 id ="adminItemtable1"><%=item.getDescription()%></h1></td>
			</tr>
			</table>
			<br>
				<td colspan="2"><input type="hidden" name="itemID"
					value="<%=item.getItemID()%>" /> <input type="submit"
					value="Delete Item" class="delete-button"/></td>
			
		
	</form>
	<br>
	</div>
	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</center>
	
</body>
</html>