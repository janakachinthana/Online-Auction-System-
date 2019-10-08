<%@page import="com.oop.model.Feedback"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Item.css" />
<meta charset="UTF-8">
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
  	<td><a class="active" href="BuyerLogin.jsp"><i class="fa fa-fw fa-user"></i> Buyer</a></td>
  	</tr>
  	</table>
  	</center>
  	</div>
	</div>
	<jsp:include page="/WEB-INF/views/SideLeftNev.jsp"></jsp:include>

	<center>
	
		<div id="janaka">
			<br>
			<br>
			<br>

			<a href="ListFeedbacks.jsp">Back to Feedback List</a>
			<h2 class="h2">Get Feedback Page</h2>
			
			

			SLIIT Feedback Management App for OOP jsp servlet. <br> <br>
			<%
				Feedback feedback = (Feedback) request.getAttribute("feedback");
			%>

			<form method="POST" action="UpdateFeedbackServlet">
				<table>
					<tr>
						<td>Feedback ID</td>
						<td><input type="text" name="feedbackID" disabled="disabled"
							value="<%=feedback.getFeedbackID()%>" /></td>
					</tr>
					<tr>
						<td>Upadate here your Feedback</td>
						<td><textarea name="feedback"
						rows = "10"
               			cols = "20"><%=feedback.getFeedback()%></textarea></td>
					</tr>
					<tr>
						<td colspan="2"><input type="hidden" name="feedbackID"
							value="<%=feedback.getFeedbackID()%>" /> <input type="submit"
							value="Update Feedback" class="update-button" /></td>
					</tr>
				</table>
			</form>

			<table>
				<tr>
					<td colspan="2">
						<form method="POST" action="DeleteFeedbackServlet">
							<input type="hidden" name="feedbackID"
								value="<%=feedback.getFeedbackID()%>" /> <input type="submit"
								value="Delete Feedback" class="delete-button" />
						</form>
					</td>
				</tr>
			</table>

			<br>
			<br>
			<br>


			<br>
			<br>
			<br>

		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</center>

</body>
</html>