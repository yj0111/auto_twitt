package selenium_practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//maven 프로젝트가 꼬였을 경우 (라이브러리가 작동 안할 떄..)
//Project -> 우클릭 ->Maven ->Update Project
public class Test03 {
		public static void main(String[] args) {
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://accounts.google.com/v3/signin/identifier?dsh=S302104202%3A1673577724985762&continue=https%3A%2F%2Fcontacts.google.com%2F%3Fhl%3Dko&followup=https%3A%2F%2Fcontacts.google.com%2F%3Fhl%3Dko&hl=ko&passive=1209600&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=AeAAQh6qfSm0qHTlS9PP2YUy9OXeOJKxTX7l29GWREe38eEXzpeSgcElJyQ_xYuGsV24TVj1JO83lg");
			
//			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//			WebElement loginBtn = driver.findElement(By.cssSelector("#layers > div > div:nth-child(1) > div > div > div > div > div > div > div > div:nth-child(1) > a > div"));
			//loginBtn.click();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			WebElement loginInput = driver.findElement(By.cssSelector("#identifierId"));
			//#react-root > div > div > div > main > div > div > div > div.css-1dbjc4n.r-6koalj.r-16y2uox > div.css-1dbjc4n.r-16y2uox.r-1jgb5lz.r-13qz1uu > div > div.css-1dbjc4n.r-mk0yit.r-1f1sjgu.r-13qz1uu > label > div > div.css-1dbjc4n.r-18u37iz.r-16y2uox.r-1wbh5a2.r-1wzrnnt.r-1udh08x.r-xd6kpl.r-1pn2ns4.r-ttdzmv > div > input
			//#react-root > div > div > div > main > div > div > div > div.css-1dbjc4n.r-6koalj.r-16y2uox > div.css-1dbjc4n.r-16y2uox.r-1jgb5lz.r-13qz1uu > div > div.css-1dbjc4n.r-mk0yit.r-1f1sjgu.r-13qz1uu > label > div > div.css-1dbjc4n.r-18u37iz.r-16y2uox.r-1wbh5a2.r-1wzrnnt.r-1udh08x.r-xd6kpl.r-1pn2ns4.r-ttdzmv > div > input
			//#react-root > div > div > div > main > div > div > div > div.css-1dbjc4n.r-6koalj.r-16y2uox > div.css-1dbjc4n.r-16y2uox.r-1jgb5lz.r-13qz1uu > div > div.css-1dbjc4n.r-mk0yit.r-1f1sjgu.r-13qz1uu > label > div > div.css-1dbjc4n.r-18u37iz.r-16y2uox.r-1wbh5a2.r-1wzrnnt.r-1udh08x.r-xd6kpl.r-1pn2ns4.r-ttdzmv > div > input
			//<input autocapitalize="sentences" autocomplete="username" autocorrect="on" name="text" spellcheck="true" type="text" dir="auto" class="r-30o5oe r-1niwhzg r-17gur6a r-1yadl64 r-deolkf r-homxoj r-poiln3 r-7cikom r-1ny4l3l r-t60dpp r-1dz5y72 r-fdjqy7 r-13qz1uu" value="">
			loginInput.sendKeys("qudcks8749@gmail.com");
			loginInput.sendKeys(Keys.ENTER);
			
			
			
			
			
			
			
		}
}
