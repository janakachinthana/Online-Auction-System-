<%@page import="com.oop.model.Bid"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.BidServiceImpl"%>
<%@page import="com.oop.service.IBidService"%>
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
  	<td><a href="AdminLogin.jsp"><i class="fa fa-fw fa-user"></i> Admin Panel</a></td>
  	<td><a href="SellerLogin.jsp"><i class="fa fa-fw fa-user"></i> Seller</a></td>
  	<td><a href="BuyerLogin.jsp" class="active"><i class="fa fa-fw fa-user"></i> Buyer</a></td>
  	</tr>
  	</table>
  	</center>
  	</div>
	</div>
	<jsp:include page="/WEB-INF/views/SideLeftNev.jsp"></jsp:include>

	<center>
	
	<div id ="janaka1">
	
	SLIIT OOP Auction System App for OOP jsp servlet.
	<br>
	<br>
	  <div>
		<table border="1" cellpadding="12">
		 <caption><h2>List of Bids</h2></caption>
		 <br>
		 <a href="BuyerView.jsp">Back to Item List</a>
		  <tr>
                <th>Bid ID</th>
                <th>Bid Price</th>
                <th>Select</th>
            </tr>
            <%
            IBidService iBidService = new BidServiceImpl();
			ArrayList<Bid> arrayList = iBidService.getBids();
			
			for(Bid bid : arrayList){
			%>
			 <tr>
				<td> <%=bid.getBidID() %> </td>
				<td> <%=bid.getBidPrice() %> </td>
				<td> 
				<form method="POST" action="GetBidServlet">
				<input type="hidden" name="bidID" value="<%=bid.getBidID()%>"/>
				 <input type="submit" value= "Select Bid" class="select-button" /> 
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