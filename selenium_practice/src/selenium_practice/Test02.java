package selenium_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//maven 프로젝트가 꼬였을 경우 (라이브러리가 작동 안할 떄..)
//Project -> 우클릭 ->Maven ->Update Project
public class Test02 {
		public static void main(String[] args) {
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://etk.srail.kr/");
			String srtMain = driver.getWindowHandle();
			for(String handle : driver.getWindowHandles()) {
				if(!handle.equals(srtMain)) {
					driver.switchTo().window(handle).close();
				}
			}
			driver.switchTo().window(srtMain);
			Select departure = new Select(driver.findElement(By.name("dptRsStnCd")));
			departure.selectByVisibleText("광주송정");
			
			Select arrival = new Select(driver.findElement(By.name("arvRsStnCd")));
			arrival.selectByValue("0551");
			
			driver.findElement(By.cssSelector("#search-form > fieldset > a")).click();
			
			
			
			
			
			
		}
}
