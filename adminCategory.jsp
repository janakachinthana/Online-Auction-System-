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
if(userName == null) response.sendRedirect("AdminLogin.jsp");
%>

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
  	<h3 id ="user"> <form method="POST" action="welcome.jsp"><input type="submit" value="Log Out" class="delete-button"   /> </form> <i class="fa fa-fw fa-user"></i><%=userName %></h3>
  	</table>
  	</center>
  	</div>
	</div>
	
	<jsp:include page="/WEB-INF/views/SideLeftNev.jsp"></jsp:include>

	<center>
	
	<div id = "listCat">
	<br>

	   <h1>Welcome To Admin Category Page</h1>
	   
	   
	<br>
	<br>
	<div id = "AdminList">
	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="ListAdminServlet">
				 <input type="submit"value="Admin List"  id="AdminListButton"/>
				</form>
			</td>
		</tr>
	</table>
	</div>
	<div id = "BuyerList">
	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="ListBuyerServlet">
				 <input type="submit"value="Buyers List"  id="BuyerListButton"/>
				</form>
			</td>
		</tr>
	</table>
	</div>
	<div id = "SellerList">
	<table>

		<tr>
			<td colspan="2">
				<form method="POST" action="ListSellerServlet">
				 <input type="submit"value="Sellers List"  id="SellerListButton"/>
				</form>
			</td>
		</tr>
	</table>
	</div>
	<div id = "ItemList">
	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="ListItemServlet">
				 <input type="submit"value="Items List"  id="ItemListButton"/>
				</form>
			</td>
		</tr>
	</table>
	</div>
	<div id = "BidList">
	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="ListBidAdminServlet">
				 <input type="submit"value="Bids List"  id="BidListButton"/>
				</form>
			</td>
		</tr>
	</table>
	</div>
	<div id = "FeedbackList">
	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="ListFeedbackAdminServlet">
				 <input type="submit"value="Feedback List"  id="FeedbackListButton"/>
				</form>
			</td>
		</tr>
	</table></div>
	<br><br><br><br><br>

</div>
<br><jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</center>
</body>
</html>