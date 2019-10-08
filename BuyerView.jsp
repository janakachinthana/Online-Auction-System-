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
<body id="body">
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

	<div id= "nev1">
	
	<div class="navbar1">
	<center>
	<table>
  	<tr><td><a  href="welcome.jsp"><i class="fa fa-fw fa-home"></i> Home</a></td>
  	<td><a href="AdminLogin.jsp"><i class="fa fa-fw fa-user"></i> Admin Panel</a></td>
  	<td><a href="SellerLogin.jsp"><i class="fa fa-fw fa-user"></i> Seller</a></td>
  	<td><a class="active" href="BuyerLogin.jsp"><i class="fa fa-fw fa-user"></i> Buyer</a></td>
  	</tr>
  	<h3 id ="user"><form method="POST" action="welcome.jsp"><input type="submit" value="Log Out"  class="delete-button" /></form> <i class="fa fa-fw fa-user"></i><%=userName %></h3>
  	</table>
  	
  	</center>
  	</div>
	</div>
	<jsp:include page="/WEB-INF/views/SideLeftNev.jsp"></jsp:include>

	<center>

	
	<div id = "buyerview1">
	<br><br>
	 <div id ="listHeading">
	 
	 
	<br><br>


		<h2>List of Items</h2><br>
	<a>SLIIT OOP Auction System App for OOP jsp servlet.</a>
	<br>
	<br>
		 
            <%
            IItemService iItemService = new ItemServiceImpl();
			ArrayList<Item> arrayList = iItemService.getItems();
			
			for(Item item : arrayList){
			%>
			<div id="itemUnique">
			<table border="1" cellpadding="12" class="table1">
			
			
			  <tr>
                <th> 
				<form method="POST" action="AddBid.jsp">
				<input type="hidden" name="itemID" value="<%=item.getItemID()%>"/>
				 <input type="submit" value= "Bid Item" class="select-button" />
				 </form>
				 <form method="POST" action="AddFeedback.jsp">
				<input type="hidden" name="itemID" value="<%=item.getItemID()%>"/>
				 <input type="submit" value= "Feedback" class="select-button" />
				  
				 </form>
				 
				 <br>
				 Item Image 
				 </th>
                <td> <img src ="images/fr.jpg"> </td>	
              </tr>
			  <tr>
                <th>Item ID</th>
                <td> <%=item.getItemID() %> </td>
              </tr>
              <tr>
                <th>Item Name</th>
                <td> <%=item.getName() %> </td>
               </tr>
               <tr>
                <th>Price</th>
                <td> <%=item.getPrice() %> </td>
               </tr>
               <tr>
                <th>Description</th>
                <td> <%=item.getDescription() %> </td>	
               </tr>
               <tr>
                <th>Bid Closing Date</th>
                <td> <%=item.getDate() %> </td>	
               </tr>
            
		</table>

		</div>
		<br>
		<%	
			   }
            %> 
		<br><br>
		</div>
		
		
		</center>
	<div id ="foot1">	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include></div>
</body>
</html>