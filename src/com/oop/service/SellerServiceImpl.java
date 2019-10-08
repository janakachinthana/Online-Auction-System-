
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

import com.oop.model.Seller;
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;


public class SellerServiceImpl implements ISellerService {
	

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(SellerServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createSellerTable();
	}

	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing Sellers table in the database and
	 * recreate table structure to insert seller entries
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
	public static void createSellerTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_SELLER_TABLE));
			// Create new sellers table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_SELLER_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add set of sellers for as a batch from the selected seller List
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
	public void addSeller(Seller seller) {

		String sellerID = CommonUtil.generateIDs(getSellerIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in SellerQuery.xml file and use
			 * insert_seller key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_SELLERS));
			connection.setAutoCommit(false);
			
			//Generate seller IDs
			seller.setSellerID(sellerID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, seller.getSellerID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, seller.getFirstName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, seller.getLastName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, seller.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, seller.getPassword());
			// Add seller
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
	 * Seller details can be retrieved based on the provided seller ID
	 * 
	 * @param sellerID
	 *            - Seller details are filtered based on the ID
	 * 
	 * @see #actionOnSeller()
	 */
	@Override
	public Seller getSellerByID(String sellerID) {

		return actionOnSeller(sellerID).get(0);
	}
	
	/**
	 * Get all list of sellers
	 * 
	 * @return ArrayList<Seller> 
	 * 						- Array of seller list will be return
	 * 
	 * @see #actionOnSeller()
	 */
	@Override
	public ArrayList<Seller> getSellers() {
		
		return actionOnSeller(null);
	}

	/**
	 * This method delete an seller based on the provided ID
	 * 
	 * @param sellerID
	 *            - Delete seller according to the filtered seller details
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
	public void removeSeller(String sellerID) {

		// Before deleting check whether seller ID is available
		if (sellerID != null && !sellerID.isEmpty()) {
			/*
			 * Remove seller query will be retrieved from SellerQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_SELLER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, sellerID);
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
	 * This performs GET seller by ID and Display all sellers
	 * 
	 * @param sellerID
	 *            ID of the seller to remove or select from the list

	 * @return ArrayList<Seller> Array of seller list will be return
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
	 * @see #getSellers()
	 * @see #getSellerByID(String)
	 */
	private ArrayList<Seller> actionOnSeller(String sellerID) {

		ArrayList<Seller> sellerList = new ArrayList<Seller>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching seller it checks whether seller ID is
			 * available
			 */
			if (sellerID != null && !sellerID.isEmpty()) {
				/*
				 * Get seller by ID query will be retrieved from
				 * SellerQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SELLER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, sellerID);
			}
			/*
			 * If seller ID is not provided for get seller option it display
			 * all sellers
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_SELLERS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Seller seller = new Seller();
				seller.setSellerID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				seller.setFirstName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				seller.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				seller.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				seller.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				sellerList.add(seller);
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
		return sellerList;
	}

	/**
	 * Get the updated seller
	 * 
	 * @param sellerID
	 *            ID of the seller to remove or select from the list
	 * 
	 * @return return the Seller object
	 * 
	 */
	@Override
	public Seller updateSeller(String sellerID, Seller seller) {

		/*
		 * Before fetching seller it checks whether seller ID is available
		 */
		if (sellerID != null && !sellerID.isEmpty()) {
			/*
			 * Update seller query will be retrieved from SellerQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_SELLER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, seller.getFirstName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, seller.getLastName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, seller.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, seller.getPassword());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, seller.getSellerID());
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
		// Get the updated seller
		return getSellerByID(sellerID);
	}
	
	/**
	 *
	 * @return ArrayList<String> Array of seller id list will be return
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
	private ArrayList<String> getSellerIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of seller IDs will be retrieved from SellerQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SELLER_IDS));
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
