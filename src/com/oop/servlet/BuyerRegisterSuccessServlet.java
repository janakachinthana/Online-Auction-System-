package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Buyer;
import com.oop.service.IBuyerService;
import com.oop.service.BuyerServiceImpl;

/**
 * Servlet implementation class RegisterSuccessServlet
 */
@WebServlet("/BuyerRegisterSuccessServlet")
public class BuyerRegisterSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerRegisterSuccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");

 		String buyerID = request.getParameter("buyerID");			
		IBuyerService iBuyerService = new BuyerServiceImpl();
		Buyer buyer = iBuyerService.getBuyerByID(buyerID);

		request.setAttribute("buyer", buyer);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/BuyerLogin.jsp");
		dispatcher.forward(request, response);
	}

}
