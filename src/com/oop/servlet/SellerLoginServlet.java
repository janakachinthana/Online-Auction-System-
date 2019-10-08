package com.oop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/SellerLoginServlet")
public class SellerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String userID = "Seller@gmail.com";
	private final String password = "Seller";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// get request parameters for userID and password
		String user = request.getParameter("email");
		String pwd = request.getParameter("password");
		
		if(userID.equals(user) && password.equals(pwd)){
			Cookie loginCookie = new Cookie("user",user);
			//setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(1*60);
			response.addCookie(loginCookie);
			response.sendRedirect("SellerView.jsp");
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/SellerLogin.jsp");
			PrintWriter out= response.getWriter();
			out.println("<font color=red size = 50px;>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}

	}

}