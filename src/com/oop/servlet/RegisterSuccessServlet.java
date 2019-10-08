package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Person;
import com.oop.service.IPersonService;
import com.oop.service.PersonServiceImpl;

/**
 * Servlet implementation class RegisterSuccessServlet
 */
@WebServlet("/RegisterSuccessServlet")
public class RegisterSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterSuccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");

 		String personID = request.getParameter("personID");			
		IPersonService iPersonService = new PersonServiceImpl();
		Person person = iPersonService.getPersonByID(personID);

		request.setAttribute("person", person);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AdminLogin.jsp");
		dispatcher.forward(request, response);
	}

}
