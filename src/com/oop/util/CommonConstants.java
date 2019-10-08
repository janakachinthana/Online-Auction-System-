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

/**
 * This is the common constants file for Java Web project.
 */
public class CommonConstants {

	/** Constant for config.properties key for query file path */
	public static final String QUERY_XML = "queryFilePath";

	/** Constant for file path of config.properties */
	public static final String PROPERTY_FILE = "config.properties";

	/** Constant for query tag in ItemQuery.xml */
	public static final String TAG_NAME = "query";

	/** Constant for query id in ItemQuery.xml */
	public static final String ATTRIB_ID = "id";
	
	/** Constant for item id prefix */
	public static final String ITEM_ID_PREFIX = "I000";

	/** Constant for comma */
	public static final String COMMA = ",";

	/** Constant for url key of MySQL database in config.properties */
	public static final String URL = "url";

	/** Constant for user name key of MySQL database in config.properties */
	public static final String USERNAME = "username";

	/** Constant for password key of MySQL database in config.properties */
	public static final String PASSWORD = "password";

	/** Constant for driver name key of MySQL database in config.properties */
	public static final String DRIVER_NAME = "driverName";

	/** Constant for query id of drop_table in ItemQuery.xml */
	public static final String QUERY_ID_DROP_TABLE = "drop_table";

	/** Constant for query id of create_table in ItemQuery.xml */
	public static final String QUERY_ID_CREATE_TABLE = "create_item_table";

	/** Constant for query id of insert items in ItemQuery.xml */
	public static final String QUERY_ID_INSERT_ITEMS = "insert_item";

	/** Constant for query id of get an item in ItemQuery.xml */
	public static final String QUERY_ID_GET_ITEM = "item_by_id";

	/** Constant for query id of get all items in ItemQuery.xml */
	public static final String QUERY_ID_ALL_ITEMS = "all_items";

	/** Constant for query id of remove a item in ItemQuery.xml */
	public static final String QUERY_ID_REMOVE_ITEM = "remove_item";

	/** Constant for query id of update a item in ItemQuery.xml */
	public static final String QUERY_ID_UPDATE_ITEM = "update_item";

	/** Constant for query id of get all item ids in ItemQuery.xml */
	public static final String QUERY_ID_GET_ITEM_IDS = "item_ids";
	
	
	
	
	
	
	/** Constant for person id prefix */
	public static final String PERSON_ID_PREFIX = "A000";

	/** Constant for query id of drop_table in PersonQuery.xml */
	public static final String QUERY_ID_DROP_PERSON_TABLE = "drop_person_table";

	/** Constant for query id of create_table in PersonQuery.xml */
	public static final String QUERY_ID_CREATE_PERSON_TABLE = "create_person_table";

	/** Constant for query id of insert persons in PersonQuery.xml */
	public static final String QUERY_ID_INSERT_PERSONS = "insert_person";

	/** Constant for query id of get an person in PersonQuery.xml */
	public static final String QUERY_ID_GET_PERSON = "person_by_id";

	/** Constant for query id of get all persons in PersonQuery.xml */
	public static final String QUERY_ID_ALL_PERSONS = "all_persons";

	/** Constant for query id of remove a person in PersonQuery.xml */
	public static final String QUERY_ID_REMOVE_PERSON = "remove_person";

	/** Constant for query id of update a person in PersonQuery.xml */
	public static final String QUERY_ID_UPDATE_PERSON = "update_person";

	/** Constant for query id of get all person ids in PersonQuery.xml */
	public static final String QUERY_ID_GET_PERSON_IDS = "person_ids";
	
	
	
	
	
	
	
	
	
	
	/** Constant for seller id prefix */
	public static final String SELLER_ID_PREFIX = "S000";

	/** Constant for query id of drop_table in SellerQuery.xml */
	public static final String QUERY_ID_DROP_SELLER_TABLE = "drop_seller_table";

	/** Constant for query id of create_table in SellerQuery.xml */
	public static final String QUERY_ID_CREATE_SELLER_TABLE = "create_seller_table";

	/** Constant for query id of insert sellers in SellerQuery.xml */
	public static final String QUERY_ID_INSERT_SELLERS = "insert_seller";

	/** Constant for query id of get an seller in SellerQuery.xml */
	public static final String QUERY_ID_GET_SELLER = "seller_by_id";

	/** Constant for query id of get all sellers in SellerQuery.xml */
	public static final String QUERY_ID_ALL_SELLERS = "all_sellers";

	/** Constant for query id of remove a seller in SellerQuery.xml */
	public static final String QUERY_ID_REMOVE_SELLER = "remove_seller";

	/** Constant for query id of update a seller in SellerQuery.xml */
	public static final String QUERY_ID_UPDATE_SELLER = "update_seller";

	/** Constant for query id of get all seller ids in SellerQuery.xml */
	public static final String QUERY_ID_GET_SELLER_IDS = "seller_ids";
	
	
	
	
	
	
	/** Constant for buyer id prefix */
	public static final String BUYER_ID_PREFIX = "CUS000";

	/** Constant for query id of drop_table in BuyerQuery.xml */
	public static final String QUERY_ID_DROP_BUYER_TABLE = "drop_buyer_table";

	/** Constant for query id of create_table in BuyerQuery.xml */
	public static final String QUERY_ID_CREATE_BUYER_TABLE = "create_buyer_table";

	/** Constant for query id of insert buyers in BuyerQuery.xml */
	public static final String QUERY_ID_INSERT_BUYERS = "insert_buyer";

	/** Constant for query id of get an buyer in BuyerQuery.xml */
	public static final String QUERY_ID_GET_BUYER = "buyer_by_id";

	/** Constant for query id of get all buyers in BuyerQuery.xml */
	public static final String QUERY_ID_ALL_BUYERS = "all_buyers";

	/** Constant for query id of remove a buyer in BuyerQuery.xml */
	public static final String QUERY_ID_REMOVE_BUYER = "remove_buyer";

	/** Constant for query id of update a buyer in BuyerQuery.xml */
	public static final String QUERY_ID_UPDATE_BUYER = "update_buyer";

	/** Constant for query id of get all buyer ids in BuyerQuery.xml */
	public static final String QUERY_ID_GET_BUYER_IDS = "buyer_ids";
	
	
	
	
	
	
	
	
	
	
	
	/** Constant for person id prefix */
	public static final String BID_ID_PREFIX = "B000";

	/** Constant for query id of drop_table in PersonQuery.xml */
	public static final String QUERY_ID_DROP_BID_TABLE = "drop_bid_table";

	/** Constant for query id of create_table in PersonQuery.xml */
	public static final String QUERY_ID_CREATE_BID_TABLE = "create_bid_table";

	/** Constant for query id of insert persons in PersonQuery.xml */
	public static final String QUERY_ID_INSERT_BIDS = "insert_bid";

	/** Constant for query id of get an person in PersonQuery.xml */
	public static final String QUERY_ID_GET_BID = "bid_by_id";

	/** Constant for query id of get all persons in PersonQuery.xml */
	public static final String QUERY_ID_ALL_BIDS = "all_bids";

	/** Constant for query id of remove a person in PersonQuery.xml */
	public static final String QUERY_ID_REMOVE_BID = "remove_bid";

	/** Constant for query id of update a person in PersonQuery.xml */
	public static final String QUERY_ID_UPDATE_BID = "update_bid";

	/** Constant for query id of get all person ids in PersonQuery.xml */
	public static final String QUERY_ID_GET_BID_IDS = "bid_ids";
	
	
	
	
	
	

	/** Constant for person id prefix */
	public static final String FEEDBACK_ID_PREFIX = "F000";

	/** Constant for query id of drop_table in PersonQuery.xml */
	public static final String QUERY_ID_DROP_FEEDBACK_TABLE = "drop_feedback_table";

	/** Constant for query id of create_table in PersonQuery.xml */
	public static final String QUERY_ID_CREATE_FEEDBACK_TABLE = "create_feedback_table";

	/** Constant for query id of insert persons in PersonQuery.xml */
	public static final String QUERY_ID_INSERT_FEEDBACKS = "insert_feedback";

	/** Constant for query id of get an person in PersonQuery.xml */
	public static final String QUERY_ID_GET_FEEDBACK = "feedback_by_id";

	/** Constant for query id of get all persons in PersonQuery.xml */
	public static final String QUERY_ID_ALL_FEEDBACKS = "all_feedbacks";

	/** Constant for query id of remove a person in PersonQuery.xml */
	public static final String QUERY_ID_REMOVE_FEEDBACK = "remove_feedback";

	/** Constant for query id of update a person in PersonQuery.xml */
	public static final String QUERY_ID_UPDATE_FEEDBACK = "update_feedback";

	/** Constant for query id of get all person ids in PersonQuery.xml */
	public static final String QUERY_ID_GET_FEEDBACK_IDS = "feedback_ids";
	
	
	
	
	
	
	
	
	
	
	
	/** Constant for Column index one */
	public static final int COLUMN_INDEX_ONE = 1;
	
	/** Constant for Column index two */
	public static final int COLUMN_INDEX_TWO = 2;
	
	/** Constant for Column index three */
	public static final int COLUMN_INDEX_THREE = 3;
	
	/** Constant for Column index four */
	public static final int COLUMN_INDEX_FOUR = 4;
	
	/** Constant for Column index five */
	public static final int COLUMN_INDEX_FIVE = 5;
	
	/** Constant for Column index six */
	public static final int COLUMN_INDEX_SIX = 6;
	
	/** Constant for Column index seven */
	public static final int COLUMN_INDEX_SEVEN = 7;
	
	/** Constant for Column index eight */
	public static final int COLUMN_INDEX_EIGHT = 8;
}
