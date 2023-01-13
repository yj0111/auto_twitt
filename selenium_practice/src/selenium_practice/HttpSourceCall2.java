package selenium_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class HttpSourceCall2 {
	
	static AccessToken accessToken=null;
	static String accessSecret="";
	static Twitter twitter;
	
	
	public static void main(String[] args) {
		
		RequestToken requestToken=null;
		
		twitter = TwitterFactory.getSingleton();
		twitter.setOAuthConsumer("kM4stCv3tKnu2WpApc046hPLa", "A2QqCli04qtFW5ujgbeBG1Jd3oH8W8mwa5bKUATnh0nGz0Lrve");
		
		
		//토큰
		requestToken=null;
		try {
			requestToken = twitter.getOAuthRequestToken();
		}catch(TwitterException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(requestToken.getAuthorizationURL());
		
		System.out.println("Enter the PIN and hit enter after you granted access");
		String pin="";
		try {
			pin=br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			if(pin.length()>0) {
				accessToken = twitter.getOAuthAccessToken(requestToken,pin);
			}else {
				accessToken = twitter.getOAuthAccessToken(requestToken);
			}
			
			String key1 = accessToken.getToken();
			String key2 = accessToken.getTokenSecret();
			
			System.out.println("accessToken : "+accessToken);
			System.out.println("getToken : "+key1);
			System.out.println("getTokenSecret : "+key2);
			
		}catch(TwitterException te) {
			if(401==te.getStatusCode()) {
				System.out.println("unable to get the access token");
				System.out.println(te);
			}else {
				te.printStackTrace();
			}
		}
		
	}
}