package selenium_practice;



import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class twitterTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccessToken accessToken=null;
		String accessSecret="";
		Twitter twitter;
		StringBuilder result = new StringBuilder();
		twitter = TwitterFactory.getSingleton();
		twitter.setOAuthConsumer("kM4stCv3tKnu2WpApc046hPLa", "A2QqCli04qtFW5ujgbeBG1Jd3oH8W8mwa5bKUATnh0nGz0Lrve");
		
		accessToken = new AccessToken("1613717725985271808-w07kXrVINZ4B5iNWAYDxrLL5Kw1mUR","V4Y02eCNAtA0KHutekUTuNTW0w87hxwT1iLsA3tw0Gzyz"); //내 계정
		twitter.setOAuthAccessToken(accessToken);

		WebDriver driver = new ChromeDriver();
	    LocalDate now = LocalDate.now();

	    // 네이버 날씨 
	    driver.get("https://www.naver.com/");

	     //역삼동 오늘의 날씨 검색
	    WebElement searchInput = driver.findElement(By.cssSelector("#query"));
	    searchInput.sendKeys("역삼동 오늘의 날씨");        

	    //엔터키 입력 !
	    searchInput.sendKeys(Keys.ENTER);
	    
	    //현재 기온 
	    List<WebElement> info = driver.findElements(By.cssSelector("#main_pack > section.sc_new.cs_weather_new._cs_weather > div._tab_flicking > div.content_wrap > div.open > div:nth-child(1) > div > div.weather_info > div > div._today > div.weather_graphic > div.temperature_text"));
	    List<WebElement> status = driver.findElements(By.cssSelector("#main_pack > section.sc_new.cs_weather_new._cs_weather > div._tab_flicking > div.content_wrap > div.open > div:nth-child(1) > div > div.weather_info > div > div._today > div.temperature_info > p > span.weather.before_slash"));
	    String tem = info.get(0).getText();
	    String tem1 = tem.substring(6, 10); 
	    
	    //상태
	    String status1 = status.get(0).getText();
	   result.append( "(" +now+ ") 멀티캠퍼스 소식\n");
	   result.append("<날씨>\n");
	   result.append("현재 기온 : " + tem1 + "/" + status1+"\n");
	    
	    
	    //미세먼지
	    List<WebElement> dust = driver.findElements(By.cssSelector("#main_pack > section.sc_new.cs_weather_new._cs_weather > div._tab_flicking > div.content_wrap > div.open > div:nth-child(1) > div > div.weather_info > div > div.report_card_wrap > ul > li:nth-child(1)\r\n"));
	    String dust1 = dust.get(0).getText();
	    String dust2 = dust1.substring(5, dust1.length());
		   result.append("미세먼지 "+ dust2+"\n");

	    //두번째 줄 받아오기
	    List<WebElement> win = driver.findElements(By.cssSelector("#main_pack > section.sc_new.cs_weather_new._cs_weather > div._tab_flicking > div.content_wrap > div.open > div:nth-child(1) > div > div.weather_info > div > div._today > div.temperature_info > dl"));
	    for(int i = 0; i< win.size(); i++) {
	 	   result.append(win.get(i).getText()+"\n");
	    }
	    
	    //상태에 비 포함하면 우산
	    if(status1.contains("비")) {
	 	   result.append("\n우산을 가져가세요 ~"+"\n");
	    }
	    
	    // 네이버 뉴스 IT 일반 접속
	    driver.get("https://news.naver.com/main/main.naver?mode=LSD&mid=shm&sid1=105");
	    WebElement itnBtn = driver.findElement(By.cssSelector("#snb > h2 > a"));
	    itnBtn.click();
	    
	    // 상위 2개 뉴스 제목 가져오기
	    result.append("<IT 뉴스>\n");
	    List<WebElement> titles = driver.findElements(By.cssSelector("#main_content > div > div._persist > div:nth-child(1) > div > div.cluster_body > ul > li:nth-child(1) > div.cluster_text > a"));
	    for(int i = 0 ; i < 3 ; i++) {
	 	   result.append((i+1) + ". " + titles.get(i).getText().substring(0, 20)+"...\n"); // 기사 제목 
	        
	    }
		
		
		
		
		
		try {
			Status status11 =twitter.updateStatus(result.toString());
			System.out.println("트윗 완료!");
		} catch (TwitterException e1) {
			System.out.println("e1 : "+e1);
			
		}

	   }
}