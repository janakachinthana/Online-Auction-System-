
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

import com.oop.model.Person;
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

public class PersonServiceImpl implements IPersonService {
	

	/** Initialize logger */
	public static final Logger log1 = Logger.getLogger(PersonServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createPersonTable();
	}

	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing Persons table in the database and
	 * recreate table structure to insert person entries
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
	public static void createPersonTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_PERSON_TABLE));
			// Create new persons table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_PERSON_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log1.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add set of persons for as a batch from the selected person List
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
	public void addPerson(Person person) {

		String personID = CommonUtil.generateIDs(getPersonIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in PersonQuery.xml file and use
			 * insert_person key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_PERSONS));
			connection.setAutoCommit(false);
			
			//Generate person IDs
			person.setPersonID(personID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, person.getPersonID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, person.getFirstName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, person.getLastName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, person.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, person.getPassword());
			// Add person
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log1.log(Level.SEVERE, e.getMessage());
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
				log1.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	/**
	 * Person details can be retrieved based on the provided person ID
	 * 
	 * @param personID
	 *            - Person details are filtered based on the ID
	 * 
	 * @see #actionOnPerson()
	 */
	@Override
	public Person getPersonByID(String personID) {

		return actionOnPerson(personID).get(0);
	}
	
	/**
	 * Get all list of persons
	 * 
	 * @return ArrayList<Person> 
	 * 						- Array of person list will be return
	 * 
	 * @see #actionOnPerson()
	 */
	@Override
	public ArrayList<Person> getPersons() {
		
		return actionOnPerson(null);
	}
 
	/**
	 * This method delete an person based on the provided ID
	 * 
	 * @param personID
	 *            - Delete person according to the filtered person details
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
	public void removePerson(String personID) {

		// Before deleting check whether person ID is available
		if (personID != null && !personID.isEmpty()) {
			/*
			 * Remove person query will be retrieved from PersonQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_PERSON));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, personID);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log1.log(Level.SEVERE, e.getMessage());
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
					log1.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	/**
	 * This performs GET person by ID and Display all persons
	 * 
	 * @param personID
	 *            ID of the person to remove or select from the list

	 * @return ArrayList<Person> Array of person list will be return
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
	 * @see #getPersons()
	 * @see #getPersonByID(String)
	 */
	private ArrayList<Person> actionOnPerson(String personID) {

		ArrayList<Person> personList = new ArrayList<Person>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching person it checks whether person ID is
			 * available
			 */
			if (personID != null && !personID.isEmpty()) {
				/*
				 * Get person by ID query will be retrieved from
				 * PersonQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_PERSON));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, personID);
			}
			/*
			 * If person ID is not provided for get person option it display
			 * all persons
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_PERSONS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Person person = new Person();
				person.setPersonID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				person.setFirstName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				person.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				person.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				person.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				personList.add(person);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log1.log(Level.SEVERE, e.getMessage());
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
				log1.log(Level.SEVERE, e.getMessage());
			}
		}
		return personList;
	}

	/**
	 * Get the updated person
	 * 
	 * @param personID
	 *            ID of the person to remove or select from the list
	 * 
	 * @return return the Person object
	 * 
	 */
	@Override
	public Person updatePerson(String personID, Person person) {

		/*
		 * Before fetching person it checks whether person ID is available
		 */
		if (personID != null && !personID.isEmpty()) {
			/*
			 * Update person query will be retrieved from PersonQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_PERSON));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, person.getFirstName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, person.getLastName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, person.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, person.getPassword());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, person.getPersonID());
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log1.log(Level.SEVERE, e.getMessage());
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
					log1.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated person
		return getPersonByID(personID);
	}
	
	/**
	 *
	 * @return ArrayList<String> Array of person id list will be return
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
	private ArrayList<String> getPersonIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of person IDs will be retrieved from PersonQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_PERSON_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log1.log(Level.SEVERE, e.getMessage());
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
				log1.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
}
