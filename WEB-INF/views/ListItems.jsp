<%@page import="com.oop.model.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.ItemServiceImpl"%>
<%@page import="com.oop.service.IItemService"%>
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
	<br><br>
	<div id = "janaka1">
	

	<br><br><br>

	<h3>List of Items</h3>
	<a>SLIIT OOP Auction System App for OOP jsp servlet.</a>
	<br>
	<br>
	  <div>
		<table border="1" cellpadding="12">
		 <caption><h2>List of Items</h2></caption>
		 <a href="adminCategory.jsp">Back to Category</a>
		  <tr>
                <th>Item ID</th>
                <th>Item Name</th>
                <th>Price</th>
                <th>Closing Date</th>
                <th>Description</th>
                <th>Select</th>
            </tr>
            <%
            IItemService iItemService = new ItemServiceImpl();
			ArrayList<Item> arrayList = iItemService.getItems();
			
			for(Item item : arrayList){
			%>
			 <tr>
				<td> <%=item.getItemID() %> </td>
				<td> <%=item.getName() %> </td>
				<td> <%=item.getPrice() %> </td>
				<td> <%=item.getDate() %> </td>
				<td> <%=item.getDescription() %> </td>	
				<td> 
				<form method="POST" action="GetItemServlet">
				<input type="hidden" name="itemID" value="<%=item.getItemID()%>"/>
				 <input type="submit" value= "Select Item" class="select-button" /> 
				 </form>
				 </td>	
				</tr>			
			<%	
			   }
            %>     
		</table>
		</div>
		
		<br><br><br>
		
		<br><br><br>
		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
		</center>
</body>
</html>