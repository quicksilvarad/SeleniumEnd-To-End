package newPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

//import dev.failsafe.internal.util.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		List<WebElement> chu = driver.findElements(By.xpath("//div[@id='discount-checkbox']/div"));// find a locator
																									// common to all
																									// checkboxes
		chu.forEach(element -> {
			System.out.println(element);
		});
		System.out.println(chu.size());
		driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).click();
		boolean x = driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected();
		System.out.println(String.valueOf(x));
		driver.findElement(By.cssSelector("input[value='RoundTrip']")).click(); // selecting round trip so that return
																				// date is enabled
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		Assert.assertEquals(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"), true);
		driver.findElement(By.cssSelector("input[value='OneWay']")).click();// selecting one way trip so that return
																			// date is disabled
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		Assert.assertEquals(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"), false);
		driver.findElement(By.id("divpaxinfo")).click();
		System.out.println(driver.findElement(By.id("spanAudlt")).getText());
		Thread.sleep(2000);

		for (int i = 0; i < 4; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		System.out.println(driver.findElement(By.id("spanAudlt")).getText());
		driver.findElement(By.id("btnclosepaxoption")).click();
		driver.close();

	}

}
