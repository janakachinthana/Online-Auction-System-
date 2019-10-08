package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Seller;
import com.oop.service.ISellerService;
import com.oop.service.SellerServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/SellerRegisterServlet")
public class SellerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		Seller seller = new Seller();
		
		seller.setFirstName(request.getParameter("firstName"));
		seller.setLastName(request.getParameter("lastName"));
		seller.setEmail(request.getParameter("email"));
		seller.setPassword(request.getParameter("password"));

		ISellerService iSellerService = new SellerServiceImpl();
		iSellerService.addSeller(seller);

		request.setAttribute("seller", seller);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/SellerRegisterUpdate.jsp");
		dispatcher.forward(request, response);
	}

}
