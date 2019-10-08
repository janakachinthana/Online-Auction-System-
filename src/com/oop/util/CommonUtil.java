/**
 * OOP 2019
 * 
 * @author Group15, OOP Assignment, SLIIT, June Intake 2019, 
 * 
 * @version 1.0
 * Copyright: SLIIT, All rights reserved
 * 
 */
package com.oop.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.oop.service.IItemService;
import com.oop.service.IPersonService;

/**
 * This is the common utility class to load all property details at once when it
 * is initializing .
 */
public class CommonUtil {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IItemService.class.getName());

	public static final Properties properties = new Properties();

	static {
		try {
			
			// Read the property only once when load the class
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
			
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add new Item ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.ITEM_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.ITEM_ID_PREFIX + next;
		}
		return id;
	}
	
	
	
	
	
	
	
	/** Initialize logger */
	public static final Logger log1 = Logger.getLogger(IPersonService.class.getName());

	public static final Properties properties1 = new Properties();

	static {
		try {
			
			// Read the property only once when load the class
			properties1.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
			
		} catch (IOException e) {
			log1.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add new Item ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generatePersonIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.PERSON_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.PERSON_ID_PREFIX + next;
		}
		return id;
	}
	
	
	
	
	
	
	/** Initialize logger */
	public static final Logger log2 = Logger.getLogger(IPersonService.class.getName());

	public static final Properties properties2 = new Properties();

	static {
		try {
			
			// Read the property only once when load the class
			properties2.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
			
		} catch (IOException e) {
			log2
			.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add new Item ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateBidIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.BID_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.BID_ID_PREFIX + next;
		}
		return id;
	}
	
	
	
	
	/** Initialize logger */
	public static final Logger log3 = Logger.getLogger(IPersonService.class.getName());

	public static final Properties properties3 = new Properties();

	static {
		try {
			
			// Read the property only once when load the class
			properties3.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
			
		} catch (IOException e) {
			log3
			.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add new Item ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateFeedbackIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.FEEDBACK_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.FEEDBACK_ID_PREFIX + next;
		}
		return id;
	}
	
	
	
	
	
	
	
	
	
	
	
}
