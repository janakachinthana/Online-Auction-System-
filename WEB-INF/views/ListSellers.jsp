<%@page import="com.oop.model.Seller"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.SellerServiceImpl"%>
<%@page import="com.oop.service.ISellerService"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "Item.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	
	<div id ="janaka1">
	<h3>List of Sellers</h3>
	SLIIT OOP Auction System App for OOP jsp servlet.
	<br>
	<br>
	  <div>
		<table border="1" cellpadding="12">
		 <caption><h2>List of Sellers</h2></caption>
		 <br>
		 <a href="adminCategory.jsp">Back to Category</a>
		  <tr>
                <th>Seller ID</th>
                <th>Name</th>
                <th>Select</th>
            </tr>
            <%
            ISellerService iSellerService = new SellerServiceImpl();
			ArrayList<Seller> arrayList = iSellerService.getSellers();
			
			for(Seller seller : arrayList){
			%>
			 <tr>
				<td> <%=seller.getSellerID() %> </td>
				<td> <%=seller.getFirstName() %> <%=seller.getLastName() %> </td>
				<td> 
				<form method="POST" action="GetSellerServlet">
				<input type="hidden" name="sellerID" value="<%=seller.getSellerID()%>"/>
				 <input type="submit" value= "Select Seller" class="select-button" /> 
				 </form>
				 </td>	
				</tr>			
			<%	
			   }
            %>     
		</table>
		</div><br><br><br>
		
		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
		</center>
		
</body>
</html>