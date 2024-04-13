package newPack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
	public static void main(String[] args)
	{
		System.setProperty("EdgeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
		Actions a = new Actions(driver);
		//Moves to specific element
		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		a.moveToElement(move).build().perform();
		a.moveToElement(driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("boat buds").build().perform();
		a.moveToElement(move).contextClick().build().perform();
	}
}
