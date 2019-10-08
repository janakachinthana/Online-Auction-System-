
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
		<%
String userName = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
}
}
if(userName == null) response.sendRedirect("SellerLogin.jsp");

%>
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	
	
	<center>
		<div id= "nev1">
	
	<div class="navbar1">
	
<table>
  	<tr><td><a href="welcome.jsp"><i class="fa fa-fw fa-home"></i> Home</a></td>
  	<td><a href="AdminLogin.jsp"><i class="fa fa-fw fa-user"></i> Admin Panel</a></td>
  	<td><a class="active" href="SellerLogin.jsp"><i class="fa fa-fw fa-user"></i> Seller</a></td>
  	<td><a href="BuyerLogin.jsp"><i class="fa fa-fw fa-user"></i> Buyer</a></td>
  	</tr>
  	<h3 id ="user"> <i class="fa fa-fw fa-user"></i><%=userName %></h3>
  	</table>
  	</center>
  	</div>
	</div>
	
	<jsp:include page="/WEB-INF/views/SideLeftNev.jsp"></jsp:include>
	<center>
	<div id = "addItem"><br><br><br>
	<h2 class="h2">Add Item Page</h2>

	  <a> SLIIT Auction System App for Object Orineted Progrmming </a>
	<br>
	<br>

	<form enctype="multipart/form-data"  method="POST" action="SellerAddItemServlet">
		<table>
			
			
			<tr>
				<td>Item Name :</td>
				<td><input type="text" name="itemName" pattern="[a-zA-Z]+( ?[a-zA-Z]+)" title="You can enter the value with upercase or lowercase or both only" required/></td>
			</tr>
			<tr>
				<td>Item Image :</td>
				<td><input type="file" name="itemImage" required/></td>
			</tr>
			<tr>
				<td>Price :</td>
				<td><input type="number" name="price" title="Value should be integers...!" required/></td>
			</tr>
			<tr>
				<td>Closing Date :</td>
				<td><input type="date" name="date" required/></td>
			</tr>
			<tr>
				<td>Item Description :</td>
				<td><textarea 
				name="description"
				id = "discrip1"
                rows = "10"
                cols = "20"pattern= "[a-z]*\{ser\}[a-z]*" required></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Item" class="add-button" /> </td>
			</tr>
			<tr>	
				<td colspan="2"><input type="reset" value="Reset" class="reset-button" /></td>
			</tr>
		</table>
	</form>

	<form method="POST" action="SellerViewServlet">
		<table>
			<tr>
				<td colspan="2"><input type="submit" value="List All Items" class="list-button" />
				</td>
			</tr>
		</table>
	</form>
	
	<br><br><br>
	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</center>

</body>
</html>