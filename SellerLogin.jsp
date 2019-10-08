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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="body">
	
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<div id= "nev1">
	
	<div class="navbar1">
	<center>
<table>
  	<tr><td><a href="welcome.jsp"><i class="fa fa-fw fa-home"></i> Home</a></td>
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
	
	<div id = "log1">
	<div id="log2">
	<br>
	<h2 class="h2">Login Page</h2>

	  <a> Seller Login </a>
	<br>
	<br>

	<form method="POST" action="SellerLoginServlet">
		<table>

			<tr>
				<td>E-mail Address : </td>
				<td><input type="email" name="email" required/></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password" required/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login" class="add-button" /> </td>
			</tr>
			<tr>	
				<td colspan="2"><input type="reset" value="Reset" class="reset-button" /></td>
			</tr>
		</table>
	</form>

	<form method="POST" action="SellerRegister.jsp">
		<table>
			<tr>
				<td colspan="2"><input type="submit" value="Register" class="list-button" />
				</td>
			</tr>
		</table>
	</form>
	<br><br>
	</div>
	
	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</center>

</body>
</html>