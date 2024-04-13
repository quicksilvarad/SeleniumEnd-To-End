package newPack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignement3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("EdgeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.cssSelector("input[value='user']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button[id='okayBtn']"))));
		driver.findElement(By.cssSelector("button[id='okayBtn']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("select.form-control"))));
		WebElement ddns = driver.findElement(By.cssSelector("select.form-control"));
		Select ddn = new Select(ddns);
		ddn.selectByVisibleText("Consultant");
		driver.findElement(By.cssSelector("input[id='terms']")).click();
		driver.findElement(By.id("signInBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='navbar-brand']")));
		List<WebElement> list = driver.findElements(By.cssSelector("app-card[class='col-lg-3 col-md-6 mb-3']"));
		list.forEach(element->{element.findElement(By.cssSelector("button[class='btn btn-info']")).click();});
		driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.btn-success")));
		driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[id='country']")));
		driver.findElement(By.cssSelector("input[id='country']")).sendKeys("Austria");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='suggestions']//a[text()='Austria']")));
		driver.findElement(By.xpath("//div[@class='suggestions']//a[text()='Austria']")).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='checkbox2']")));
		driver.findElement(By.cssSelector("label[for='checkbox2']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[class='btn btn-success btn-lg']")));
		driver.findElement(By.cssSelector("input[class='btn btn-success btn-lg']")).click();
		driver.quit();



	}

}
