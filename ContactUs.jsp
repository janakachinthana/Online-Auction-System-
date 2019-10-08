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
	
			<div id= "nev1">
	
	<div class="navbar1">
	<center>
	<table>
  	<tr><td><a  href="welcome.jsp" class="active"><i class="fa fa-fw fa-home"></i> Home</a></td>
  	<td><a href="AdminLogin.jsp" ><i class="fa fa-fw fa-user"></i> Admin Panel</a></td>
  	<td><a href="SellerLogin.jsp"><i class="fa fa-fw fa-user"></i> Seller</a></td>
  	<td><a href="BuyerLogin.jsp"><i class="fa fa-fw fa-user"></i> Buyer</a></td>
  	</tr>
  	</table>
  	</center>
  	</div>
	</div>
	</center>
<jsp:include page="/WEB-INF/views/SideLeftNev.jsp"></jsp:include>
	<center>
	
	
	<div id = "janaka3">

	
<br>
	<h2 class="h2">Contact Us</h2>

	   
	<br>
	<br>

	<table>
		<tr><div id = "info">
			Tel : 0717191100 - Mr janaka Dissanayake<br>
			Tel : 0717191100 - Mr Charuka krishantha<br>
			Tel : 0717191100 - Mr Navod<br>
			Tel : 0717191100 - Mr Isuru<br>
			</div>
		</tr>
	</table>
	<table>
		<tr>
			<div id = "info">
			e-mail : IT18226324@my.sliit.lk<br>
			</div>
		</tr>
	</table>
	<table>
		<tr>
			<div id = "info">
			Address : waliwita, malabe<br>
			</div>
		</tr>
	</table>

	<br><br><br><br><br><br>

</div>

</center>
	
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

</body>
</html>