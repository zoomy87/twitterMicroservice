/**
 * 
 */
package com.seniorproject.twitterMicroservice.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * @author ericz
 *
 */

@Component
public class TwitterGetter {
	
	
	private Twitter twitter;

	@Autowired
	public TwitterGetter(@Value("{oauth.consumerKey}")String conKey, @Value("{oauth.consumerSecret}")String conSec
			, @Value("{oauth.accessToken}")String tok, @Value("{oauth.accessTokenSecret}")String tokSec) {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey(conKey)
		  .setOAuthConsumerSecret(conSec)
		  .setOAuthAccessToken(tok)
		  .setOAuthAccessTokenSecret(tokSec);
		TwitterFactory tf = new TwitterFactory(cb.build());
		this.twitter = tf.getInstance();
		
	}

	@Bean
	public Twitter getTwitter() {
		return twitter;
	}

	public void setTwitter(Twitter twitter) {
		this.twitter = twitter;
	}
	
	
	
}
