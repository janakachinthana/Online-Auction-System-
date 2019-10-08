package com.oop.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.oop.model.Item;
import com.oop.service.IItemService;
import com.oop.service.ItemServiceImpl;

/**
 * Servlet implementation class SellerAddItemServlet
 */
@WebServlet("/SellerAddItemServlet")
@MultipartConfig(maxFileSize = 16177216)

public class SellerAddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerAddItemServlet() {
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
	PrintWriter out;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
//		Part part = request.getPart("image");
		String name = request.getParameter("name");
		
		
		Item item = new Item();
//		InputStream is = part.getInputStream();
		
		item.setName(request.getParameter("itemName"));
		item.setPrice(request.getParameter("price"));
		item.setDescription(request.getParameter("description"));
		item.setDate(request.getParameter("date"));
		item.setItemImage(request.getParameter("itemImage"));
		
		
		IItemService iItemService = new ItemServiceImpl();
		iItemService.addItem(item);
 
		request.setAttribute("item", item);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/SellerView.jsp");
		dispatcher.forward(request, response);
	}

}
