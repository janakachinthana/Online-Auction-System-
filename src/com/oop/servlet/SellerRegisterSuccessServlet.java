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
 * Servlet implementation class RegisterSuccessServlet
 */
@WebServlet("/SellerRegisterSuccessServlet")
public class SellerRegisterSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerRegisterSuccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");

 		String sellerID = request.getParameter("sellerID");			
		ISellerService iSellerService = new SellerServiceImpl();
		Seller seller = iSellerService.getSellerByID(sellerID);

		request.setAttribute("seller", seller);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/SellerLogin.jsp");
		dispatcher.forward(request, response);
	}

}
