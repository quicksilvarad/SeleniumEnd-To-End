package newPack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment6 {

	public static void main(String[] args) {
		System.setProperty("EdgeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
		String option = driver.findElement(By.cssSelector("label[for='bmw']")).getText();
		System.out.println(option);
		WebElement ddn = driver.findElement(By.cssSelector("select[id='dropdown-class-example']"));
		Select dropdown = new Select(ddn);
		dropdown.selectByVisibleText(option);
		driver.findElement(By.cssSelector("input[id='name']")).sendKeys(option);
		driver.findElement(By.cssSelector("input[id='alertbtn']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.quit();
	}
}
