
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

import com.oop.model.Buyer;
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;


public class BuyerServiceImpl implements IBuyerService {
	

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(BuyerServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createBuyerTable();
	}

	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing Buyers table in the database and
	 * recreate table structure to insert buyer entries
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
	public static void createBuyerTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_BUYER_TABLE));
			// Create new buyers table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_BUYER_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add set of buyers for as a batch from the selected buyer List
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
	public void addBuyer(Buyer buyer) {

		String buyerID = CommonUtil.generateIDs(getBuyerIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in BuyerQuery.xml file and use
			 * insert_buyer key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_BUYERS));
			connection.setAutoCommit(false);
			
			//Generate buyer IDs
			buyer.setBuyerID(buyerID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, buyer.getBuyerID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, buyer.getFirstName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, buyer.getLastName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, buyer.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, buyer.getPassword());
			// Add buyer
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
	 * Buyer details can be retrieved based on the provided buyer ID
	 * 
	 * @param buyerID
	 *            - Buyer details are filtered based on the ID
	 * 
	 * @see #actionOnBuyer()
	 */
	@Override
	public Buyer getBuyerByID(String buyerID) {

		return actionOnBuyer(buyerID).get(0);
	}
	
	/**
	 * Get all list of buyers
	 * 
	 * @return ArrayList<Buyer> 
	 * 						- Array of buyer list will be return
	 * 
	 * @see #actionOnBuyer()
	 */
	@Override
	public ArrayList<Buyer> getBuyers() {
		
		return actionOnBuyer(null);
	}

	/**
	 * This method delete an buyer based on the provided ID
	 * 
	 * @param buyerID
	 *            - Delete buyer according to the filtered buyer details
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
	public void removeBuyer(String buyerID) {

		// Before deleting check whether buyer ID is available
		if (buyerID != null && !buyerID.isEmpty()) {
			/*
			 * Remove buyer query will be retrieved from BuyerQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_BUYER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, buyerID);
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
	 * This performs GET buyer by ID and Display all buyers
	 * 
	 * @param buyerID
	 *            ID of the buyer to remove or select from the list

	 * @return ArrayList<Buyer> Array of buyer list will be return
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
	 * @see #getBuyers()
	 * @see #getBuyerByID(String)
	 */
	private ArrayList<Buyer> actionOnBuyer(String buyerID) {

		ArrayList<Buyer> buyerList = new ArrayList<Buyer>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching buyer it checks whether buyer ID is
			 * available
			 */
			if (buyerID != null && !buyerID.isEmpty()) {
				/*
				 * Get buyer by ID query will be retrieved from
				 * BuyerQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_BUYER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, buyerID);
			}
			/*
			 * If buyer ID is not provided for get buyer option it display
			 * all buyers
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_BUYERS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Buyer buyer = new Buyer();
				buyer.setBuyerID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				buyer.setFirstName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				buyer.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				buyer.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				buyer.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				buyerList.add(buyer);
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
		return buyerList;
	}

	/**
	 * Get the updated buyer
	 * 
	 * @param buyerID
	 *            ID of the buyer to remove or select from the list
	 * 
	 * @return return the Buyer object
	 * 
	 */
	@Override
	public Buyer updateBuyer(String buyerID, Buyer buyer) {

		/*
		 * Before fetching buyer it checks whether buyer ID is available
		 */
		if (buyerID != null && !buyerID.isEmpty()) {
			/*
			 * Update buyer query will be retrieved from BuyerQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_BUYER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, buyer.getFirstName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, buyer.getLastName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, buyer.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, buyer.getPassword());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, buyer.getBuyerID());
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
		// Get the updated buyer
		return getBuyerByID(buyerID);
	}
	
	/**
	 *
	 * @return ArrayList<String> Array of buyer id list will be return
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
	private ArrayList<String> getBuyerIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of buyer IDs will be retrieved from BuyerQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_BUYER_IDS));
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
