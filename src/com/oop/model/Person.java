
package com.oop.model;


public class Person {

	private String PersonID;
	
	private String FirstName;

	private String LastName;

	private String Email;

	private String Password;

	/**
	 * @return the employeeID
	 */
	public String getPersonID() {
		return PersonID;
	}

	/**
	 * @param employeeID the employeeID to set
	 */
	public void setPersonID(String personID) {
		PersonID = personID;
	}

	/**
	 * @return the name
	 */
	public String getFirstName() {
		return FirstName;
	}

	/**
	 * @param name the name to set
	 */
	public void setFirstName(String firstname) {
		FirstName = firstname;
	}

	/**
	 * @return the name
	 */
	public String getLastName() {
		return LastName;
	}

	/**
	 * @param name the name to set
	 */
	public void setLastName(String lastname) {
		LastName = lastname;
	}

	/**
	 * @return the designation
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * @return the facultyName
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setPassword(String password) {
		Password = password;
	}
	
	@Override
	public String toString() {
		
		return "Person ID = " + PersonID + "\n" + "First Name = " + FirstName + "\n" + "LastName = " + LastName + "\n"
				+ "Email = " + Email + "\n" + "Password = " + Password;
	}
}
