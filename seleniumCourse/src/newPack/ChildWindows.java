package newPack;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChildWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		    
			System.setProperty("EdgeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://rahulshettyacademy.com/loginpagePractise/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(By.className("blinkingText")).click();
			//WebDriverWait waitforit = new WebDriverWait(driver,Duration.ofSeconds(5));
			
			//waitforit.until(ExpectedConditions.visibili(By.xpath("//div/p[@class='im-para red']")));
			Set<String> s = driver.getWindowHandles();
			Iterator<String> it = s.iterator();
			String parentWindowId = it.next();
			String childWindowId = it.next();
			
			driver.switchTo().window(childWindowId);
			WebElement wb = driver.findElement(By.xpath("//div/p[@class='im-para red']"));
	        String newString = wb.getText().split(" at ")[1].split(" ")[0];
	        System.out.println(newString);
	        driver.switchTo().window(parentWindowId);
	        driver.findElement(By.id("username")).sendKeys(newString);
			
		

	}

}
