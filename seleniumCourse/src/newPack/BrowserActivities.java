package newPack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserActivities {

	public static void main(String[] args)
	{
		System.setProperty("EdgeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
		WebDriver driver = new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.google.com");//has in-built sync mechanism is present
	    driver.navigate().to("https://www.rockstargames.com");//have to take care of wait manually
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Grand Theft Auto VI']")));
		System.out.println(driver.findElement(By.xpath("//div[text()='Grand Theft Auto VI']")).getText());
	    driver.navigate().back();
	    driver.close();
	}
}
