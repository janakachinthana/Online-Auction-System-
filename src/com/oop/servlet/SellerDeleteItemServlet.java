package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.IItemService;
import com.oop.service.ItemServiceImpl;

/**
 * Servlet implementation class SellerDeleteItemServlet
 */
@WebServlet("/SellerDeleteItemServlet")
public class SellerDeleteItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerDeleteItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String itemID = request.getParameter("itemID");			
		
		IItemService iItemService = new ItemServiceImpl();
		iItemService.removeItem(itemID);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/SellerView.jsp");
		dispatcher.forward(request, response);
	}

}
