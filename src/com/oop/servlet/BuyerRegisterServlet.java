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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/BuyerRegisterServlet")
public class BuyerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		Buyer buyer = new Buyer();
		
		buyer.setFirstName(request.getParameter("firstName"));
		buyer.setLastName(request.getParameter("lastName"));
		buyer.setEmail(request.getParameter("email"));
		buyer.setPassword(request.getParameter("password"));

		IBuyerService iBuyerService = new BuyerServiceImpl();
		iBuyerService.addBuyer(buyer);

		request.setAttribute("buyer", buyer);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/BuyerRegisterUpdate.jsp");
		dispatcher.forward(request, response);
	}

}
