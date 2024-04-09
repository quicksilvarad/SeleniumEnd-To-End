package newPack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("EdgeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
		WebDriver driver = new FirefoxDriver();
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().window().maximize();
	    driver.get("https://www.makemytrip.com/");
	    String monthYear="December 2024";
	    //JavascriptExecutor js = (JavascriptExecutor)driver;
	    //js.executeScript("window.scrollBy(0,1000)");
	    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='form_fields[travel_comp_date]']")));
	    
	    //wait.until(ExpectedConditions.alertIsPresent());
	    //driver.switchTo().alert().dismiss();
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='departure']")));
	    //driver.findElement(By.xpath("//div[@class='container']//i[class='wewidgeticon we_close']")).click();
	    driver.findElement(By.xpath("//label[@for='departure']")).click();
	    WebElement wb = driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[@style='' ]"));
	    
	    while(!wb.getText().contains("October 2024")) 
	    {
	    	driver.findElement(By.cssSelector("span[aria-label='Next Month']")).click();    
	    }
	    
	    //driver.findElement(By.xpath("//div[@class='DayPicker-Day']")).click();
	    //Thread.sleep(2000);
	    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='january']")));
	    List<WebElement> dates = driver.findElements(By.xpath("//div[@class='DayPicker-Month']/following-sibling::div//div[@class='dateInnerCell']"));
	    dates.forEach(date->{if(date.getText().contains("24")) {date.click();}});
	    

	}

}
