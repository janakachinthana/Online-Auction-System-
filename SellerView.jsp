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
  	<td><a class="active" href="SellerLogin.jsp"><i class="fa fa-fw fa-user"></i> Seller</a></td>
  	<td><a href="BuyerLogin.jsp"><i class="fa fa-fw fa-user"></i> Buyer</a></td>
  	</tr>
  	<h3 id ="user"> <form method="POST" action="welcome.jsp"><input type="submit" value="Log Out"  class="delete-button" /></form><i class="fa fa-fw fa-user"></i><%=userName %></h3>
  	</table>
  </center>
  
  	</div>
	</div>


	
	
	<jsp:include page="/WEB-INF/views/SideLeftNev.jsp"></jsp:include>
	<center>
	
	<div id = "SellerView">

	<br><br><br>

<div id ="img3">
<br>

	<a>SLIIT OOP Auction System App for OOP jsp servlet.</a>
	<br>
	<br>
	
	  
		
		 
		 <a href="SellerAddItem.jsp"><input type = "button" value="Add Item" class = "sell"></a>
		 
				<form method="POST" action="ListBidSellerServlet">
				 <input type="submit"value="Bids List"  class = "sell"/>
				</form>
		
				<form method="POST" action="ListFeedbackSellerServlet">
				 <input type="submit"value="Feedback List"  class = "sell"/>
				</form>
			<br><br>
		 
		 <br>
		 <br>
		 
		 </div>
		 
		 
		 	<h2>List of Items</h2>
		 
           
			
			
		
             <%
            IItemService iItemService = new ItemServiceImpl();
			ArrayList<Item> arrayList = iItemService.getItems();
			
			for(Item item : arrayList){
			%>
			<div id ="img4"></div>
			<br><br>
				<div id = janaka2>
				
				<table class ="table1" border="1" cellpadding="12">
			 <tr>
			 	<th>Item Image</th>
                <th>Item ID</th>
                <th>Item Name</th>
                <th>Price</th>
                <th>Closing Date</th>
                <th>Select</th>
            </tr>
            
			 <tr>
			 	<td> <img src ="images/fr.jpg"> </td>
				<td> <%=item.getItemID() %> </td>
				<td> <%=item.getName() %> </td>
				<td> <%=item.getPrice() %> </td>
				<td> <%=item.getDate() %> </td>	
				<td> 
				<form method="POST" action="SellerGetItemServlet">
				<input type="hidden" name="itemID" value="<%=item.getItemID()%>"/>
				 <input type="submit" value= "Select Item"  class ="select-button"/> 
				 </form>
				 </td>	
				</tr>	
				</div>	
				</table>
				<br><br>
			<%	
			   }
            %>     
		<div id ="img4"></div><br><br>
		</div>
		</div>
		</center>
		
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
		
</body>
</html>