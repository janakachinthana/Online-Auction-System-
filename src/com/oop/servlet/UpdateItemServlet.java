package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Item;
import com.oop.service.ItemServiceImpl;
import com.oop.service.IItemService;

/**
 * Update items servlet
 */
public class UpdateItemServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateItemServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		Item item = new Item();
		String itemID = request.getParameter("itemID");	
		item.setItemID(itemID);
		item.setName(request.getParameter("itemName"));
		item.setPrice(request.getParameter("price"));
		item.setDescription(request.getParameter("description"));
		item.setDate(request.getParameter("date"));
		item.setItemImage(request.getParameter("itemImage"));
		
		IItemService iItemService = new ItemServiceImpl();
		iItemService.updateItem(itemID, item);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListItems.jsp");
		dispatcher.forward(request, response);
	}

}
