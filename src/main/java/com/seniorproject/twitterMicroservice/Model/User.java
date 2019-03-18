/**
 * 
 */
package com.seniorproject.twitterMicroservice.Model;

import org.springframework.social.oauth1.OAuth1Template;
import org.springframework.social.twitter.security.TwitterAuthenticationService;

/**
 * @author ericz
 *
 */
public class User {

	private int UserID;
	
	private int ID;
	
	private String title;
	
	private String completed;

	private String jack;

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
	
	
//	TwitterAuthenticationService t = new TwitterAuthenticationService("Mnw1qqFn6kV185XFk7TJSvqw5", "5ruiEgIASdp507ZYJPGHz68vJC7rfysmOJhEeNxq0j8hRF3TuQ");
//	OAuth1Template o = new OAuth1Template("Mnw1qqFn6kV185XFk7TJSvqw5", "5ruiEgIASdp507ZYJPGHz68vJC7rfysmOJhEeNxq0j8hRF3TuQ ", "", "", "");
//	
//	public void j() {
//		t.
//	}
//	
}
