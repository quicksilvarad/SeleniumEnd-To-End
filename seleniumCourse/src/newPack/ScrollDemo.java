package newPack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ScrollDemo {
	static int x=0;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("EdgeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
		WebDriver driver = new FirefoxDriver();
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().window().maximize();
	    driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy('0','700')");
	    Thread.sleep(3000);
	    js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
	    
	    List<WebElement> wb = driver.findElements(By.cssSelector("div[class='tableFixHead'] td:nth-child(4)"));
	    wb.forEach(element->{
	    
	    	x = x + Integer.parseInt(element.getText());
	    	System.out.println(Integer.parseInt(element.getText()));
	    	
	    });
	    System.out.println(x);
	    int total= Integer.parseInt(driver.findElement(By.cssSelector("div.totalAmount")).getText().split(": ")[1]);
	    Assert.assertEquals(total, x);
	    
	   
	    
	    

	}

}
