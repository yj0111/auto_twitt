package selenium_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//maven 프로젝트가 꼬였을 경우 (라이브러리가 작동 안할 떄..)
//Project -> 우클릭 ->Maven ->Update Project
public class Test01 {
		public static void main(String[] args) {
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.naver.com/");
			
			WebElement financeBtn =driver.findElement(By.cssSelector("#NM_FAVORITE > div.group_nav > ul.list_nav.NM_FAVORITE_LIST > li:nth-child(3) > a"));
			financeBtn.click();
			WebElement financeNewsBtn =driver.findElement(By.cssSelector("#menu > ul > li.m7 > a > span"));
			financeNewsBtn.click();
			
//			WebElement searchInput = driver.findElement(By.cssSelector("#stock_items"));
//			searchInput.sendKeys("삼성전자");
//			searchInput.sendKeys(Keys.ENTER);
			//#content > div.article > div.section > div.news_area > div > ul > li:nth-child(1) > span > a
			//#newsMainTop > div > div.inner_area_left > div > div.main_news > ul > li:nth-child(1) > a
			
			List<WebElement> items = driver.findElements(By.cssSelector("#newsMainTop > div > div.inner_area_left > div > div.main_news > ul > li> a"));
			for(WebElement item : items) {
				System.out.println(item.getText());
			}
			
			
		}
}
