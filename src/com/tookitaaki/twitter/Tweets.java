package com.tookitaaki.twitter;




import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.1.7
 */
public class Tweets {
    /**
     * Usage: java twitter4j.examples.timeline.GetUserTimeline
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        // gets Twitter instance with default credentials
    	Date date = new Date();
    	ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("X2hc4sGgCTt6CRFESCL3wWz1V")
    	  .setOAuthConsumerSecret("Fqf8qFMkazjRsWN2WCPY2KCKELTQKdUrNckRkLRzAKGEzoZmqT")
    	  .setOAuthAccessToken("161699092-OceTQyDBtgQV7ZcY3vN2yx1P1haCbEhIHwgxn3xf")
    	 .setOAuthAccessTokenSecret("7RClKpGWRQycLNTCLci6kAnrjtSEQ7Cjh4TnKkMl92jOb");
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
    	try {
            Query query = new Query("Sachin");
            //query.setCount(1000);
        	//query.setLang("en");
        	// set the bounding dates 
        	query.since("2015-06-06");
        	//query.setUntil(String.valueOf(date.getDate()));

            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    //System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                	System.out.println(Arrays.toString(Grams.bigram(tweet.getText())));
                	//System.out.println( tweet.getText());                
                }
            } while ((query = result.nextQuery()) != null);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
    	/*Query query = new Query();
    	query.setCount(1000);
    	query.setLang("en");
    	// set the bounding dates 
    	query.setSince(String.valueOf(date.getDate()-10000));
    	query.setUntil(String.valueOf(date.getDate()));

    	QueryResult result = searchWithRetry(twitter, query); // searchWithRetry is my function that deals with rate limits

    	while (result.getTweets().size() != 0) {

    	    List<Status> tweets = result.getTweets();
    	    System.out.print("# Tweets:\t" + tweets.size());
    	    Long minId = Long.MAX_VALUE;

    	    for (Status tweet : tweets) {
    	    // do stuff here            
    	        if (tweet.getId() < minId)
    	        minId = tweet.getId();
    	    }
    	    query.setMaxId(minId-1);
    	    result = searchWithRetry(twitter, query);*/
    }
}
       /* try {
            List<Status> statuses;
            String user;
            if (args.length == 1) {
                user = args[0];
                statuses = twitter.getUserTimeline(user);
            } else {
                user = twitter.verifyCredentials().getScreenName();
                statuses = twitter.getUserTimeline();
            }
            System.out.println("Showing @" + user + "'s user timeline.");
            for (Status status : statuses) {
                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
            }
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }
    }*/
