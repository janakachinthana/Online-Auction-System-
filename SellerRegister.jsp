<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "Item.css" />
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
  	<td><a href="AdminLogin.jsp" ><i class="fa fa-fw fa-user"></i> Admin Panel</a></td>
  	<td><a href="SellerLogin.jsp" class="active"><i class="fa fa-fw fa-user"></i> Seller</a></td>
  	<td><a href="BuyerLogin.jsp"><i class="fa fa-fw fa-user"></i> Buyer</a></td>
  	</tr>
  	</table>
  	</center>
  	</div>
	</div>
	
	<jsp:include page="/WEB-INF/views/SideLeftNev.jsp"></jsp:include>
	<center>
	
	<div id = "reg1">

	<h2 class="h2">Registration Page</h2>

	   <a>SLIIT OOP Auction System App for Object Orineted Progrmming</a>
	<br>
	<br>
	<div id = "reg2">
	<form method="POST" action="SellerRegisterServlet">
		<table>

			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" pattern="[a-zA-Z]+( ?[a-zA-Z]+)" title="Upercase letters and lowercase letters only" required/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" pattern="[a-zA-Z]+( ?[a-zA-Z]+)" title="Upercase letters and lowercase letters only" required/></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><input type="email" name="email" required/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" encripted required/></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="password" encripted required/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register" class="add-button" /> </td>
			</tr>
			<tr>	
				<td colspan="2"><input type="reset" value="Reset" class="reset-button" /></td>
			</tr>
		</table>
	</form>

	<form method="POST" action="SellerLogin.jsp">
		<table>
			<tr>
				<td colspan="2"><input type="submit" value="Login" class="list-button" />
				</td>
			</tr>
		</table>
	</form>
	</div>
	<br>

</div>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</center>
</body>
</html>