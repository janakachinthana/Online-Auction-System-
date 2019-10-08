
package com.oop.service;

import com.oop.model.Buyer;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;


public interface IBuyerService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IBuyerService.class.getName());


	/**
	 * Add buyers for buyer table
	 * @param buyer
	 */
	public void addBuyer(Buyer buyer);

	/**
	 * Get a particular Buyer
	 * 
	 * @param empoyeeID
	 * @return Buyer
	 */
	public Buyer getBuyerByID(String empoyeeID);
	
	/**
	 * Get all list of buyers
	 * 
	 * @return ArrayList<Buyer>
	 */
	public ArrayList<Buyer> getBuyers();
	
	/**
	 * Update existing buyer
	 * @param buyerID
	 * @param buyer
	 * 
	 * @return
	 */
	public Buyer updateBuyer(String buyerID, Buyer buyer);

	/**
	 * Remove existing buyer
	 * 
	 * @param buyerID
	 */
	public void removeBuyer(String buyerID);

}
