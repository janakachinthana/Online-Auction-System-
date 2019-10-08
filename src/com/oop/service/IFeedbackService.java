
	
	package com.oop.service;

	import com.oop.model.Feedback;

	import java.util.ArrayList;
	import java.util.logging.Level;
	import java.util.logging.Logger;
	import javax.xml.transform.TransformerConfigurationException;
	import javax.xml.transform.TransformerException;
	import javax.xml.transform.TransformerFactoryConfigurationError;
	

	public interface IFeedbackService {
		
		


			/** Initialize logger */
			public static final Logger log = Logger.getLogger(IFeedbackService.class.getName());


			/**
			 * Add feedbacks for feedback table
			 * @param feedback
			 */
			public void addFeedback(Feedback feedback);

			/**
			 * Get a particular Feedback
			 * 
			 * @param empoyeeID
			 * @return Feedback
			 */
			public Feedback getFeedbackByID(String empoyeeID);
			
			/**
			 * Get all list of feedbacks
			 * 
			 * @return ArrayList<Feedback>
			 */
			public ArrayList<Feedback> getFeedbacks();
			
			/**
			 * Update existing feedback
			 * @param feedbackID
			 * @param feedback
			 * 
			 * @return
			 */
			public Feedback updateFeedback(String feedbackID, Feedback feedback);

			/**
			 * Remove existing feedback
			 * 
			 * @param feedbackID
			 */
			public void removeFeedback(String feedbackID);

		


	


}
