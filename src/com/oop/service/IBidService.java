package com.oop.service;

import com.oop.model.Bid;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;


public interface IBidService {
	
	


		/** Initialize logger */
		public static final Logger log = Logger.getLogger(IBidService.class.getName());


		/**
		 * Add bids for bid table
		 * @param bid
		 */
		public void addBid(Bid bid);

		/**
		 * Get a particular Bid
		 * 
		 * @param empoyeeID
		 * @return Bid
		 */
		public Bid getBidByID(String empoyeeID);
		
		/**
		 * Get all list of bids
		 * 
		 * @return ArrayList<Bid>
		 */
		public ArrayList<Bid> getBids();
		
		/**
		 * Update existing bid
		 * @param bidID
		 * @param bid
		 * 
		 * @return
		 */
		public Bid updateBid(String bidID, Bid bid);

		/**
		 * Remove existing bid
		 * 
		 * @param bidID
		 */
		public void removeBid(String bidID);

	


}
