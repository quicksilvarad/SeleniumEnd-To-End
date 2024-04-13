package newPack;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class StandaloneScenarioSelenium {
public static void main(String[] args) throws InterruptedException
{



	WebDriverManager.firefoxdriver();
	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	driver.manage().window().maximize();

	//Landingpage implementation starts here

	driver.get("https://rahulshettyacademy.com/client");
	driver.findElement(By.id("userEmail")).sendKeys("tikori@gmail.com");
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Tikori69$");
	driver.findElement(By.cssSelector("input[type='submit']")).click();
	//Landingpage implementation ends here

	Thread.sleep(2000);
	String z = "ZARA COAT 3";
	List<String> v = Arrays.asList("ADIDAS ORIGINAL","ZARA COAT 3","IPHONE 13 PRO");
	int x = v.size();
	System.out.println(x);

	//ProductCatalogue implementation starts here
	//ProductCatalogue productCatalogue = new ProductCatalogue(driver);
	List<WebElement> listOfProducts = driver.findElements(By.cssSelector("div[class='card-body']"));
	//wb.stream().filter(element->v.contains(element.findElement(By.cssSelector("b")).getText())).forEach(x->x.findElement(By.xpath("//button[2]")).click());
	listOfProducts.forEach(element->{
		System.out.println(element.findElement(By.cssSelector("b")).getText());
		if(v.contains(element.findElement(By.cssSelector("b")).getText()))
	      {
		    element.findElement(By.cssSelector("button[class='btn w-10 rounded']")).click();
		try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}});
	driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
	//Thread.sleep(2000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy('0','400')");
	List<WebElement> cart = driver.findElements(By.cssSelector("div[class='cartSection'] h3"));
	int f =cart.stream().filter(element->v.contains(element.getText())).collect(Collectors.toList()).size();
	Actions a = new Actions(driver);
	Assert.assertEquals(f, x);
	js.executeScript("window.scrollBy('0','500')");
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Checkout']")));
	driver.findElement(By.xpath("//button[text()='Checkout']")).click();
	String country = "India"; // Bosnia and Herzegowina
	WebElement holder = driver.findElement(By.cssSelector("input[placeholder='Select Country']"));
	//a.sendKeys(holder, "bos").build().perform();
	holder.sendKeys(country);
	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class*='list-group']")));
	List<WebElement> list = driver.findElements(By.cssSelector("span[class*='inserted']"));
	a.sendKeys(Keys.ARROW_DOWN).build().perform();
	list.forEach(element->{
			a.sendKeys(Keys.ARROW_DOWN).build().perform();
	    System.out.println(element.getText());
	    if(element.getText().equalsIgnoreCase(country))
	      {
	       element.click();
	      }});

	driver.findElement(By.cssSelector("div[class='actions'] a")).click();
	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='actions']//a")));
	Thread.sleep(4000);

	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("label[class='ng-star-inserted']"))));
	List <WebElement> orderList= driver.findElements(By.cssSelector("label[class='ng-star-inserted']"));
	System.out.println("Following are the orders grabbed:");
	orderList.forEach(element->{System.out.println("Order"+" : "+element.getText());});
	driver.quit();
}

}
