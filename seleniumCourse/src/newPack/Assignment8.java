package newPack;

import java.time.Duration;
import java.util.List;
import java.lang.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("EdgeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
		WebDriver driver = new FirefoxDriver();
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().window().maximize();
	    driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
	    driver.findElement(By.cssSelector("input.inputs.ui-autocomplete-input")).sendKeys("Ind");
	    Thread.sleep(1000);
	    
	    driver.findElement(By.id("autocomplete")).sendKeys(Keys.ARROW_DOWN);
	    driver.findElement(By.id("autocomplete")).sendKeys(Keys.ARROW_DOWN);
	    driver.findElement(By.id("autocomplete")).sendKeys(Keys.ENTER);
	    
	    
	    driver.findElement(By.cssSelector("input.inputs.ui-autocomplete-input")).click();
	    System.out.println(driver.findElement(By.cssSelector("input.inputs.ui-autocomplete-input")).getAttribute("value"));// to get the text from input field
	    
	    

	}

}
