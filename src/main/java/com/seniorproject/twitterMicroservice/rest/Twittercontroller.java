/**
 * 
 */
package com.seniorproject.twitterMicroservice.rest;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.TweetData;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.connect.TwitterServiceProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ericz
 *
 */
//@Component
//@PropertySource("classpath:application.properties")
@RestController
@RequestMapping("api/v1")
public class Twittercontroller {
	private TwitterServiceProvider tsp;
	private Twitter api;
	private final Logger log = Logger.getLogger(Twittercontroller.class);
	private String key;
	private String secret;
	
//	@Autowired
//	private Environment env;
	
	
	
	@Autowired
	public Twittercontroller(@Value("${api.key}") String key1, @Value("${api.secret}") String secret1){
		
		this.key= key1;
		this.secret= secret1;		
		
		tsp= new TwitterServiceProvider(key, secret);
		api= tsp.getApi("4853842084-TIrvpmvCFPQiSlWv2PGVHiPFO6VuBor5eq3Czki","oQMtztRty6feDwQW75e9yEo0e9v42Y84pBUKn0rwFgA4u");
		
	}

	@RequestMapping(value = "/search/{hashtag}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Tweet> searchTweet(@PathVariable final String hashtag){
		
		return api.searchOperations().search(hashtag, 20).getTweets();
	}
	
	@GetMapping("/test")
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
	public Tweet searchPost(@PathVariable final String tweet){
		TweetData td = new TweetData(tweet);
		Tweet twit = api.timelineOperations().updateStatus(td);
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
	

}
