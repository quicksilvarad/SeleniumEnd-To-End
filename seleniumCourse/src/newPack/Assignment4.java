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

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("EdgeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

		Set<String> s = driver.getWindowHandles();
		Iterator<String> it = s.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();
		driver.switchTo().window(childWindowId);
		wait.until(ExpectedConditions.titleContains("New Window"));
		WebElement nwe = driver.findElement(By.cssSelector("div[class='example'] h3"));
		System.out.println(nwe.getText());
		driver.switchTo().window(parentWindowId);
		wait.until(ExpectedConditions.titleContains("The Internet"));
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
	}

}
