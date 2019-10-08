/**
 * OOP 2019
 * 
 * @author Janaka Chinthana Dissanayake OOP Assignment, SLIIT 
 * 
 * @version 1.0
 * Copyright: SLIIT, All rights reserved
 * 
 */
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

import com.oop.model.Item;
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

/**
 * Contract for the implementation of Item Service .
 */
public class ItemServiceImpl implements IItemService {
	

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ItemServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createItemTable();
	}

	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing Items table in the database and
	 * recreate table structure to insert item entries
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
	public static void createItemTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
			// Create new items table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add set of items for as a batch from the selected item List
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
	public void addItem(Item item) {

		String itemID = CommonUtil.generateIDs(getItemIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in ItemQuery.xml file and use
			 * insert_item key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_ITEMS));
			connection.setAutoCommit(false);
			
			//Generate item IDs
			item.setItemID(itemID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, item.getItemID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, item.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, item.getPrice());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, item.getDescription());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, item.getDate());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, item.getItemImage());
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
	 * Item details can be retrieved based on the provided item ID
	 * 
	 * @param itemID
	 *            - Item details are filtered based on the ID
	 * 
	 * @see #actionOnItem()
	 */
	@Override
	public Item getItemByID(String itemID) {

		return actionOnItem(itemID).get(0);
	}
	
	/**
	 * Get all list of items
	 * 
	 * @return ArrayList<Item> 
	 * 						- Array of item list will be return
	 * 
	 * @see #actionOnItem()
	 */
	@Override
	public ArrayList<Item> getItems() {
		
		return actionOnItem(null);
	}

	/**
	 * This method delete an item based on the provided ID
	 * 
	 * @param itemID
	 *            - Delete item according to the filtered item details
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
	public void removeItem(String itemID) {

		// Before deleting check whether item ID is available
		if (itemID != null && !itemID.isEmpty()) {
			/*
			 * Remove item query will be retrieved from ItemQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_ITEM));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, itemID);
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
	 * This performs GET item by ID and Display all items
	 * 
	 * @param itemID
	 *            ID of the item to remove or select from the list

	 * @return ArrayList<Item> Array of item list will be return
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
	 * @see #getItems()
	 * @see #getItemByID(String)
	 */
	private ArrayList<Item> actionOnItem(String itemID) {

		ArrayList<Item> itemList = new ArrayList<Item>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching item it checks whether item ID is
			 * available
			 */
			if (itemID != null && !itemID.isEmpty()) {
				/*
				 * Get item by ID query will be retrieved from
				 * ItemQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ITEM));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, itemID);
			}
			/*
			 * If item ID is not provided for get item option it display
			 * all items
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_ITEMS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Item item = new Item();
				item.setItemID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				item.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				item.setPrice(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				item.setDescription(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				item.setDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				item.setItemImage(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				itemList.add(item);
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
		return itemList;
	}

	/**
	 * Get the updated item
	 * 
	 * @param itemID
	 *            ID of the item to remove or select from the list
	 * 
	 * @return return the Item object
	 * 
	 */
	@Override
	public Item updateItem(String itemID, Item item) {

		/*
		 * Before fetching item it checks whether item ID is available
		 */
		if (itemID != null && !itemID.isEmpty()) {
			/*
			 * Update item query will be retrieved from ItemQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_ITEM));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, item.getName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, item.getPrice());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, item.getDescription());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, item.getDate());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, item.getItemImage());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, item.getItemID());
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
		// Get the updated item
		return getItemByID(itemID);
	}
	
	/**
	 *
	 * @return ArrayList<String> Array of item id list will be return
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
	private ArrayList<String> getItemIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of item IDs will be retrieved from ItemQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ITEM_IDS));
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
