
package com.oop.model;

import java.sql.Blob;
import java.util.Iterator;

/**
 * This is the Item model class
 */
public class Item {

	private String ItemID;
	
	private String Name;

	private String Price;

	private String Description;
	
	private String Date;
	
	private String ItemImage;
	


	public String getItemID() {
		return ItemID;
	}



	public void setItemID(String itemID) {
		ItemID = itemID;
	}



	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public String getPrice() {
		return Price;
	}



	public void setPrice(String price) {
		Price = price;
	}



	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
	}




	public String getDate() {
		return Date;
	}



	public void setDate(String date) {
		Date = date;
	}
	



	public String getItemImage() {
		return ItemImage;
	}



	public void setItemImage(String string) {
		ItemImage = string;
	}



	@Override
	public String toString() {
		return "ItemID=" + ItemID + ", Name=" + Name + ", Price=" + Price + ", Description=" + Description
				+ ", Date=" + Date + ", ItemImage=" + ItemImage;
	}







}
