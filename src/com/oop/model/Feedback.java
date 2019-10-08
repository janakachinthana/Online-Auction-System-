package com.oop.model;

public class Feedback {

	String FeedbackID;
	String Feedback;
	public String getFeedbackID() {
		return FeedbackID;
	}
	public void setFeedbackID(String feedbackID) {
		FeedbackID = feedbackID;
	}
	public String getFeedback() {
		return Feedback;
	}
	public void setFeedback(String feedback) {
		Feedback = feedback;
	}
	@Override
	public String toString() {
		
		return "FeedbackID=" + FeedbackID + ", Feedback=" + Feedback;
	}
	
	
}
