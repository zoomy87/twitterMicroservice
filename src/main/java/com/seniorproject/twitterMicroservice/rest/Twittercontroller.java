/**
 * 
 */
package com.seniorproject.twitterMicroservice.rest;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.connect.TwitterServiceProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seniorproject.twitterMicroservice.beans.TwitterGetter;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

/**
 * @author ericz
 *
 */
//@Component
@PropertySource("classpath:application.properties")
@RestController
@RequestMapping("api/v1")
public class Twittercontroller {
	private TwitterServiceProvider tsp;
	private Twitter api;
	private final Logger log = Logger.getLogger(Twittercontroller.class);
	private String key;
	private String secret;
	private twitter4j.Twitter twitter;
	private twitter4j.Twitter twitter2;
	
//	@Autowired
//	private Environment env;
	
	@Autowired
	TwitterGetter tg;
	
	@Autowired
	public Twittercontroller(@Value("${oauth.consumerKey}")String conKey, @Value("${oauth.consumerSecret}")String conSec
			, @Value("${oauth.accessToken}")String tok, @Value("${oauth.accessTokenSecret}")String tokSec){
		
		this.key= conKey;
		this.secret= conSec;		
		
		log.info(conSec);
		log.info(conKey);
		log.info(tok);
		log.info(tokSec);
		
		tsp= new TwitterServiceProvider(key, secret);
		api= tsp.getApi("4853842084-TIrvpmvCFPQiSlWv2PGVHiPFO6VuBor5eq3Czki","oQMtztRty6feDwQW75e9yEo0e9v42Y84pBUKn0rwFgA4u");
		
		/**
		 * Twitter4j stuff is below
		 */
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("conKey")
		  .setOAuthConsumerSecret("conSec")
		  .setOAuthAccessToken("tok")
		  .setOAuthAccessTokenSecret("tokSec");
		TwitterFactory tf = new TwitterFactory(cb.build());
		this.twitter = tf.getInstance();
		
		cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
			.setOAuthConsumerKey(conKey)
			.setOAuthConsumerSecret(conSec);
		tf = new TwitterFactory(cb.build());
		twitter2 = tf.getInstance();
//		try {
//			twitter.setOAuth2Token(twitter.getOAuth2Token());
//		} catch (TwitterException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	@RequestMapping(value = "/search/{hashtag}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Tweet> searchTweet(@PathVariable final String hashtag){
		
		return api.searchOperations().search(hashtag, 20).getTweets();
		
	}
	
	@RequestMapping(value = "/search2/{hashtag}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public QueryResult searchTweets(@PathVariable final String hashtag){
		Query query = new Query(hashtag);
		QueryResult q= null;
		
		try {
			log.info(query.getQuery());
			q= twitter.search(query);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		
		return q;
	}
	
	@GetMapping("/user_home")
	public List<Tweet> request() {
		List<Tweet> retVal;
		
		retVal= api.timelineOperations().getHomeTimeline();
//		retVal.forEach((tweet) -> tweet.getEntities().getHashTags().forEach( (tag) -> System.out.println(tag.getText())) );
		
//		final String uri = "https://jsonplaceholder.typicode.com/todos/1";

//	    RestTemplate restTemplate = new RestTemplate();
//	    String result = restTemplate.getForObject(uri, String.class);
	    
	    
//	    User user = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos" + "/2", User.class);
//	    retVal= user.toString();
//	    System.out.println(user.toString());
	    return retVal;
		
	}
	
	
	@RequestMapping(value = "/post/{tweet}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public twitter4j.Status searchPost(@PathVariable final String tweet){
		twitter4j.Status twit= null;
		try {
			twit = twitter.updateStatus(tweet);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return twit;
	}
	
	@GetMapping("recent_tweets")
	public List<Tweet> getUserTweets(){
		return api.timelineOperations().getUserTimeline();
	}
	
	@RequestMapping(value = "/get_user/{user}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Tweet> getSpecificUser(@PathVariable final String user){
		return api.timelineOperations().getUserTimeline(user);
		
	}
	
//	@PostMapping("twitter_login")
//	public String login() throws TwitterException {
//		 twitter2.oauth
//	}
	

}
