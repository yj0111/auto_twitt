package selenium_practice;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ssaday {
	public static void main(String[] args) {
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
	    System.out.println("오늘의 멀티캠퍼스 소식 (" +now+ ")");
	    System.out.println();
	    System.out.println("<날씨>");
	    System.out.println("현재 기온 : " + tem1 + "/" + status1 );
	    
	    
	    //미세먼지
	    List<WebElement> dust = driver.findElements(By.cssSelector("#main_pack > section.sc_new.cs_weather_new._cs_weather > div._tab_flicking > div.content_wrap > div.open > div:nth-child(1) > div > div.weather_info > div > div.report_card_wrap > ul > li:nth-child(1)\r\n"));
	    String dust1 = dust.get(0).getText();
	    String dust2 = dust1.substring(5, dust1.length());
	    System.out.println("미세먼지 "+ dust2);

	    //두번째 줄 받아오기
	    List<WebElement> win = driver.findElements(By.cssSelector("#main_pack > section.sc_new.cs_weather_new._cs_weather > div._tab_flicking > div.content_wrap > div.open > div:nth-child(1) > div > div.weather_info > div > div._today > div.temperature_info > dl"));
	    for(int i = 0; i< win.size(); i++) {
	        System.out.println(win.get(i).getText());
	    }
	    
	    //상태에 비 포함하면 우산
	    if(status1.contains("비")) {
	        System.out.println("\n우산을 가져가세요 ~");
	    }
	    
	    // 네이버 뉴스 IT 일반 접속
	    driver.get("https://news.naver.com/main/main.naver?mode=LSD&mid=shm&sid1=105");
	    WebElement itnBtn = driver.findElement(By.cssSelector("#snb > h2 > a"));
	    itnBtn.click();
	    
	    // 상위 2개 뉴스 제목 가져오기
	    System.out.println("\n<IT 뉴스>");
	    List<WebElement> titles = driver.findElements(By.cssSelector("#main_content > div > div._persist > div:nth-child(1) > div > div.cluster_body > ul > li:nth-child(1) > div.cluster_text > a"));
	    for(int i = 0 ; i < 3 ; i++) {
	        System.out.println((i+1) + ". " + titles.get(i).getText()); // 기사 제목
	        
	      //트윗
	        driver.get("https://twitter.com");
	    }
	}
}
