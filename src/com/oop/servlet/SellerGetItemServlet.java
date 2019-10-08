package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Item;
import com.oop.service.IItemService;
import com.oop.service.ItemServiceImpl;

/**
 * Servlet implementation class SellerGetItemServlet
 */
@WebServlet("/SellerGetItemServlet")
public class SellerGetItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerGetItemServlet() {
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
		Item item = iItemService.getItemByID(itemID);
		

		request.setAttribute("item", item);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/SellerGetItem.jsp");
		dispatcher.forward(request, response);
	}

}
