
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

import com.oop.model.Bid;
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;


public class BidServiceImpl implements IBidService {
	

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(BidServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createBidTable();
	}

	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing Bids table in the database and
	 * recreate table structure to insert bid entries
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
	public static void createBidTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_BID_TABLE));
			// Create new bids table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_BID_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add set of bids for as a batch from the selected bid List
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
	public void addBid(Bid bid) {

		String bidID = CommonUtil.generateIDs(getBidIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in BidQuery.xml file and use
			 * insert_bid key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_BIDS));
			connection.setAutoCommit(false);
			
			//Generate bid IDs
			bid.setBidID(bidID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, bid.getBidID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, bid.getBidPrice());
			
			// Add bid
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
	 * Bid details can be retrieved based on the provided bid ID
	 * 
	 * @param bidID
	 *            - Bid details are filtered based on the ID
	 * 
	 * @see #actionOnBid()
	 */
	@Override
	public Bid getBidByID(String bidID) {

		return actionOnBid(bidID).get(0);
	}
	
	/**
	 * Get all list of bids
	 * 
	 * @return ArrayList<Bid> 
	 * 						- Array of bid list will be return
	 * 
	 * @see #actionOnBid()
	 */
	@Override
	public ArrayList<Bid> getBids() {
		
		return actionOnBid(null);
	}

	/**
	 * This method delete an bid based on the provided ID
	 * 
	 * @param bidID
	 *            - Delete bid according to the filtered bid details
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
	public void removeBid(String bidID) {

		// Before deleting check whether bid ID is available
		if (bidID != null && !bidID.isEmpty()) {
			/*
			 * Remove bid query will be retrieved from BidQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_BID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, bidID);
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
	 * This performs GET bid by ID and Display all bids
	 * 
	 * @param bidID
	 *            ID of the bid to remove or select from the list

	 * @return ArrayList<Bid> Array of bid list will be return
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
	 * @see #getBids()
	 * @see #getBidByID(String)
	 */
	private ArrayList<Bid> actionOnBid(String bidID) {

		ArrayList<Bid> bidList = new ArrayList<Bid>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching bid it checks whether bid ID is
			 * available
			 */
			if (bidID != null && !bidID.isEmpty()) {
				/*
				 * Get bid by ID query will be retrieved from
				 * BidQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_BID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, bidID);
			}
			/*
			 * If bid ID is not provided for get bid option it display
			 * all bids
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_BIDS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Bid bid = new Bid();
				bid.setBidID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				bid.setBidPrice(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				bidList.add(bid);
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
		return bidList;
	}

	/**
	 * Get the updated bid
	 * 
	 * @param bidID
	 *            ID of the bid to remove or select from the list
	 * 
	 * @return return the Bid object
	 * 
	 */
	@Override
	public Bid updateBid(String bidID, Bid bid) {

		/*
		 * Before fetching bid it checks whether bid ID is available
		 */
		if (bidID != null && !bidID.isEmpty()) {
			/*
			 * Update bid query will be retrieved from BidQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_BID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, bid.getBidPrice());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, bid.getBidID());
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
		// Get the updated bid
		return getBidByID(bidID);
	}
	
	/**
	 *
	 * @return ArrayList<String> Array of bid id list will be return
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
	private ArrayList<String> getBidIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of bid IDs will be retrieved from BidQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_BID_IDS));
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
