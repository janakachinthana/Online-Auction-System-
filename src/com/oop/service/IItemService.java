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

import com.oop.model.Item;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;


public interface IItemService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IItemService.class.getName());


	/**
	 * Add items for item table
	 * @param item
	 */
	public void addItem(Item item);

	/**
	 * Get a particular Item
	 * 
	 * @param empoyeeID
	 * @return Item
	 */
	public Item getItemByID(String empoyeeID);
	
	/**
	 * Get all list of items
	 * 
	 * @return ArrayList<Item>
	 */
	public ArrayList<Item> getItems();
	
	/**
	 * Update existing item
	 * @param itemID
	 * @param item
	 * 
	 * @return
	 */
	public Item updateItem(String itemID, Item item);

	/**
	 * Remove existing item
	 * 
	 * @param itemID
	 */
	public void removeItem(String itemID);

}
