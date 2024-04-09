package newPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoDropdown {
	
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("EdgeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		driver.findElement(By.cssSelector("li[class='ui-menu-item'] a"));
		Thread.sleep(3000);
		List<WebElement> webElements = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		webElements.forEach(element -> {
			if(element.getText().equalsIgnoreCase("India")) {
				
				System.out.println("Successful");
				element.click();
			}
			else 
			{
				System.out.println("Failed");
			}
		}
		);
		
	}

}
