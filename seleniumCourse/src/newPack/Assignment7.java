package newPack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("EdgeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
		WebDriver driver = new FirefoxDriver();
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().window().maximize();
	    driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
	    List<WebElement>wb= driver.findElements(By.cssSelector("table[class='table-display']"));
	    wb.forEach(element->
	    {System.out.println("No. of rows: " + element.findElements(By.tagName("tr")).size());
	    System.out.println("No. of columns: " + element.findElements(By.cssSelector("tr th")).size());
	    
	    });
	    List<WebElement> wb2 = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr[3]"));
	    wb2.forEach(element->{
	    	System.out.println(element.getText());
	    });
	    
	}

}
