
package com.oop.service;

import com.oop.model.Person;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;


public interface IPersonService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IPersonService.class.getName());


	/**
	 * Add persons for person table
	 * @param person
	 */
	public void addPerson(Person person);

	/**
	 * Get a particular Person
	 * 
	 * @param empoyeeID
	 * @return Person
	 */
	public Person getPersonByID(String empoyeeID);
	
	/**
	 * Get all list of persons
	 * 
	 * @return ArrayList<Person>
	 */
	public ArrayList<Person> getPersons();
	
	/**
	 * Update existing person
	 * @param personID
	 * @param person
	 * 
	 * @return
	 */
	public Person updatePerson(String personID, Person person);

	/**
	 * Remove existing person
	 * 
	 * @param personID
	 */
	public void removePerson(String personID);

}
