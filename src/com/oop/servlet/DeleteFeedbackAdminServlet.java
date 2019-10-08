package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.FeedbackServiceImpl;
import com.oop.service.IFeedbackService;

/**
 * Servlet implementation class DeleteFeedbackServlet
 */
@WebServlet("/DeleteFeedbackAdminServlet")
public class DeleteFeedbackAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFeedbackAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String feedbackID = request.getParameter("feedbackID");			
		
		IFeedbackService iFeedbackService = new FeedbackServiceImpl();
		iFeedbackService.removeFeedback(feedbackID);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListFeedbacksAdmin.jsp");
		dispatcher.forward(request, response);
	}

}
