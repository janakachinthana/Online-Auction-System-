package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Feedback;
import com.oop.service.FeedbackServiceImpl;
import com.oop.service.IFeedbackService;

/**
 * Servlet implementation class UpdateFeedbackServlet
 */
@WebServlet("/UpdateFeedbackServlet")
public class UpdateFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		Feedback feedback = new Feedback();
		String feedbackID = request.getParameter("feedbackID");	
		feedback.setFeedbackID(feedbackID);
		feedback.setFeedback(request.getParameter("feedback"));
		
		
		IFeedbackService iFeedbackService = new FeedbackServiceImpl();
		iFeedbackService.updateFeedback(feedbackID, feedback);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListFeedbacks.jsp");
		dispatcher.forward(request, response);
	}

}
