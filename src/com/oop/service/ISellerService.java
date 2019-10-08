
package com.oop.service;

import com.oop.model.Seller;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;


public interface ISellerService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ISellerService.class.getName());


	/**
	 * Add sellers for seller table
	 * @param seller
	 */
	public void addSeller(Seller seller);

	/**
	 * Get a particular Seller
	 * 
	 * @param empoyeeID
	 * @return Seller
	 */
	public Seller getSellerByID(String empoyeeID);
	
	/**
	 * Get all list of sellers
	 * 
	 * @return ArrayList<Seller>
	 */
	public ArrayList<Seller> getSellers();
	
	/**
	 * Update existing seller
	 * @param sellerID
	 * @param seller
	 * 
	 * @return
	 */
	public Seller updateSeller(String sellerID, Seller seller);

	/**
	 * Remove existing seller
	 * 
	 * @param sellerID
	 */
	public void removeSeller(String sellerID);

}
