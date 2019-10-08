package com.oop.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.oop.model.Feedback;
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;



public class FeedbackServiceImpl implements IFeedbackService{
	
	/**
	 * OOP 2018
	 * 
	 * @author Udara Samaratunge  Department of Software Engineering, SLIIT 
	 * 
	 * @version 1.0
	 * Copyright: SLIIT, All rights reserved
	 * 
	 */
	

		/** Initialize logger */
		public static final Logger log = Logger.getLogger(FeedbackServiceImpl.class.getName());

		private static Connection connection;

		private static Statement statement;

		static{
			//create table or drop if exist
			createFeedbackTable();
		}

		private PreparedStatement preparedStatement;

		/**
		 * This method initially drop existing Feedbacks table in the database and
		 * recreate table structure to insert feedback entries
		 * 
		 * @throws SQLException
		 *             - Thrown when database access error occurs or this method is
		 *             called on a closed connection
		 * @throws ClassNotFoundException
		 *             - Thrown when an application tries to load in a class through
		 *             its string name using
		 * @throws SAXException
		 *             - Encapsulate a general SAX error or warning
		 * @throws IOException
		 *             - Exception produced by failed or interrupted I/O operations.
		 * @throws ParserConfigurationException
		 *             - Indicates a serious configuration error
		 * @throws NullPointerException
		 *             - Service is not available
		 * 
		 */
		public static void createFeedbackTable() {

			try {
				connection = DBConnectionUtil.getDBConnection();
				statement = connection.createStatement();
				// Drop table if already exists and as per SQL query available in
				// Query.xml
				statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_FEEDBACK_TABLE));
				// Create new feedbacks table as per SQL query available in
				// Query.xml
				statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_FEEDBACK_TABLE));

			} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		/**
		 * Add set of feedbacks for as a batch from the selected feedback List
		 * 
		 * @throws SQLException
		 *             - Thrown when database access error occurs or this method is
		 *             called on a closed connection
		 * @throws SAXException
		 *             - Encapsulate a general SAX error or warning
		 * @throws IOException
		 *             - Exception produced by failed or interrupted I/O operations.
		 * @throws ParserConfigurationException
		 *             - Indicates a serious configuration error.
		 * 
		 */
		@Override
		public void addFeedback(Feedback feedback) {

			String feedbackID = CommonUtil.generateIDs(getFeedbackIDs());
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				/*
				 * Query is available in FeedbackQuery.xml file and use
				 * insert_feedback key to extract value of it
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_FEEDBACKS));
				connection.setAutoCommit(false);
				
				//Generate feedback IDs
				feedback.setFeedbackID(feedbackID);
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, feedback.getFeedbackID());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, feedback.getFeedback());
				
				// Add feedback
				preparedStatement.execute();
				connection.commit();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end of
				 * transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}

		/**
		 * Feedback details can be retrieved based on the provided feedback ID
		 * 
		 * @param feedbackID
		 *            - Feedback details are filtered based on the ID
		 * 
		 * @see #actionOnFeedback()
		 */
		@Override
		public Feedback getFeedbackByID(String feedbackID) {

			return actionOnFeedback(feedbackID).get(0);
		}
		
		/**
		 * Get all list of feedbacks
		 * 
		 * @return ArrayList<Feedback> 
		 * 						- Array of feedback list will be return
		 * 
		 * @see #actionOnFeedback()
		 */
		@Override
		public ArrayList<Feedback> getFeedbacks() {
			
			return actionOnFeedback(null);
		}

		/**
		 * This method delete an feedback based on the provided ID
		 * 
		 * @param feedbackID
		 *            - Delete feedback according to the filtered feedback details
		 * @throws SQLException
		 *             - Thrown when database access error occurs or this method is
		 *             called on a closed connection
		 * @throws ClassNotFoundException
		 *             - Thrown when an application tries to load in a class through
		 *             its string name using
		 * @throws SAXException
		 *             - Encapsulate a general SAX error or warning
		 * @throws IOException
		 *             - Exception produced by failed or interrupted I/O operations.
		 * @throws ParserConfigurationException
		 *             - Indicates a serious configuration error.
		 * @throws NullPointerException
		 *             - Service is not available
		 */
		@Override
		public void removeFeedback(String feedbackID) {

			// Before deleting check whether feedback ID is available
			if (feedbackID != null && !feedbackID.isEmpty()) {
				/*
				 * Remove feedback query will be retrieved from FeedbackQuery.xml
				 */
				try {
					connection = DBConnectionUtil.getDBConnection();
					preparedStatement = connection
							.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_FEEDBACK));
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, feedbackID);
					preparedStatement.executeUpdate();
				} catch (SQLException | SAXException | IOException | ParserConfigurationException
						| ClassNotFoundException e) {
					log.log(Level.SEVERE, e.getMessage());
				} finally {
					/*
					 * Close prepared statement and database connectivity at the end
					 * of transaction
					 */
					try {
						if (preparedStatement != null) {
							preparedStatement.close();
						}
						if (connection != null) {
							connection.close();
						}
					} catch (SQLException e) {
						log.log(Level.SEVERE, e.getMessage());
					}
				}
			}
		}

		/**
		 * This performs GET feedback by ID and Display all feedbacks
		 * 
		 * @param feedbackID
		 *            ID of the feedback to remove or select from the list

		 * @return ArrayList<Feedback> Array of feedback list will be return
		 * 
		 * @throws SQLException
		 *             - Thrown when database access error occurs or this method is
		 *             called on a closed connection
		 * @throws ClassNotFoundException
		 *             - Thrown when an application tries to load in a class through
		 *             its string name using
		 * @throws SAXException
		 *             - Encapsulate a general SAX error or warning
		 * @throws IOException
		 *             - Exception produced by failed or interrupted I/O operations.
		 * @throws ParserConfigurationException
		 *             - Indicates a serious configuration error.
		 * @throws NullPointerException
		 *             - Service is not available
		 * 
		 * @see #getFeedbacks()
		 * @see #getFeedbackByID(String)
		 */
		private ArrayList<Feedback> actionOnFeedback(String feedbackID) {

			ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
			try {
				connection = DBConnectionUtil.getDBConnection();
				/*
				 * Before fetching feedback it checks whether feedback ID is
				 * available
				 */
				if (feedbackID != null && !feedbackID.isEmpty()) {
					/*
					 * Get feedback by ID query will be retrieved from
					 * FeedbackQuery.xml
					 */
					preparedStatement = connection
							.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_FEEDBACK));
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, feedbackID);
				}
				/*
				 * If feedback ID is not provided for get feedback option it display
				 * all feedbacks
				 */
				else {
					preparedStatement = connection
							.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_FEEDBACKS));
				}
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					Feedback feedback = new Feedback();
					feedback.setFeedbackID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					feedback.setFeedback(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					feedbackList.add(feedback);
				}

			} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end of
				 * transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
			return feedbackList;
		}

		/**
		 * Get the updated feedback
		 * 
		 * @param feedbackID
		 *            ID of the feedback to remove or select from the list
		 * 
		 * @return return the Feedback object
		 * 
		 */
		@Override
		public Feedback updateFeedback(String feedbackID, Feedback feedback) {

			/*
			 * Before fetching feedback it checks whether feedback ID is available
			 */
			if (feedbackID != null && !feedbackID.isEmpty()) {
				/*
				 * Update feedback query will be retrieved from FeedbackQuery.xml
				 */
				try {
					connection = DBConnectionUtil.getDBConnection();
					preparedStatement = connection
							.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_FEEDBACK));
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, feedback.getFeedback());
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, feedback.getFeedbackID());
					preparedStatement.executeUpdate();

				} catch (SQLException | SAXException | IOException | ParserConfigurationException
						| ClassNotFoundException e) {
					log.log(Level.SEVERE, e.getMessage());
				} finally {
					/*
					 * Close prepared statement and database connectivity at the end
					 * of transaction
					 */
					try {
						if (preparedStatement != null) {
							preparedStatement.close();
						}
						if (connection != null) {
							connection.close();
						}
					} catch (SQLException e) {
						log.log(Level.SEVERE, e.getMessage());
					}
				}
			}
			// Get the updated feedback
			return getFeedbackByID(feedbackID);
		}
		
		/**
		 *
		 * @return ArrayList<String> Array of feedback id list will be return
		 * 
		 * @throws SQLException
		 *             - Thrown when database access error occurs or this method is
		 *             called on a closed connection
		 * @throws ClassNotFoundException
		 *             - Thrown when an application tries to load in a class through
		 *             its string name using
		 * @throws SAXException
		 *             - Encapsulate a general SAX error or warning
		 * @throws IOException
		 *             - Exception produced by failed or interrupted I/O operations.
		 * @throws ParserConfigurationException
		 *             - Indicates a serious configuration error.
		 * @throws NullPointerException
		 *             - Service is not available
		 */
		private ArrayList<String> getFeedbackIDs(){
			
			ArrayList<String> arrayList = new ArrayList<String>();
			/*
			 * List of feedback IDs will be retrieved from FeedbackQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_FEEDBACK_IDS));
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				}
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end of
				 * transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
			return arrayList;
		}
	}



