/**
 * 
 */
package com.seniorproject.twitterMicroservice.Model;

/**
 * @author ericz
 *
 */
public class User {

	private int UserID;
	
	private int ID;
	
	private String title;
	
	private String completed;

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "User [<br>UserID=" + UserID + "<br>  ID=" + ID + ", <br>title=" + title + "<br>   completed=" + completed + "]";
	}
	
	
	
	
	
}
