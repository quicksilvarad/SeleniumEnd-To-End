package newPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.findElement(By.name("name")).sendKeys("Jennifer");

		driver.findElement(By.name("email")).sendKeys("Jennifer@rsa.com");

		driver.findElement(By.id("exampleInputPassword1")).sendKeys("abc@123");

		driver.findElement(By.cssSelector("input[type='checkbox']")).click();

		driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']/option[2]")).click();
		/*Select abc = new Select(dropdown);

		abc.selectByVisibleText("Female");*/  //true way to do static dropdowns
		driver.findElement(By.xpath("//div[@class='form-check form-check-inline']//input[@value='option2']")).click();
		driver.findElement(By.cssSelector("input[type='date']")).sendKeys("1999-03-12");
		driver.findElement(By.cssSelector("input[class='btn btn-success']")).click();
		driver.close();
	}

}
