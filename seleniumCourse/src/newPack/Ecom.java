package newPack;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ecom {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("EdgeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(4000);
		String[] newArr = {"Tomato","Brocolli","Cauliflower"};

		addItems(driver,newArr);

				}


		/*driver.findElement(By.xpath("//img[contains(@src,'beetroot')]/parent::div/parent::div/div[@class='stepper-input']/a[contains(@class,'increment')]")).click();
		driver.findElement(By.xpath("//img[contains(@src,'beetroot')]/parent::div/parent::div/div[@class='stepper-input']/a[contains(@class,'increment')]")).click();
		driver.findElement(By.xpath("//img[contains(@src,'beetroot')]/parent::div/parent::div/div[@class='stepper-input']/a[contains(@class,'decrement')]")).click();
		driver.findElement(By.xpath("//img[contains(@src,'beetroot')]/parent::div/parent::div/div[@class='product-action']/button")).click();

		driver.findElement(By.xpath("//img[contains(@src,'cucumber')]/parent::div/parent::div/div[@class='stepper-input']/a[contains(@class,'increment')]")).click();
		driver.findElement(By.xpath("//img[contains(@src,'cucumber')]/parent::div/parent::div/div[@class='stepper-input']/a[contains(@class,'increment')]")).click();
		driver.findElement(By.xpath("//img[contains(@src,'cucumber')]/parent::div/parent::div/div[@class='stepper-input']/a[contains(@class,'increment')]")).click();
		driver.findElement(By.xpath("//img[contains(@src,'cucumber')]/parent::div/parent::div/div[@class='product-action']/button")).click();
		*/
		//driver.quit();



	public static void addItems(WebDriver driver, String[] items) throws InterruptedException
	{   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		int j=0;
		List<WebElement> wb = driver.findElements(By.cssSelector("h4.product-name"));
	    for(int i=0; i<wb.size();i++)
		{

			String[] name = wb.get(i).getText().split("-");
			System.out.println(wb.get(i) + ":" + name); //+name.substring(0,name.indexOf("-")-1));
			String formattedName = name[0].trim();
			List itemsNeededList = Arrays.asList(items);

			if(itemsNeededList.contains(formattedName))
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==items.length)
				{
					break;
				}
			}

	}
	    driver.findElement(By.cssSelector("img[alt=\"Cart\"]")).click();
	    driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
	    driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

	    driver.findElement(By.cssSelector("button.promoBtn")).click();
	    //driver.manage().timeouts().wait(8000);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Code applied ..!']")));
	    //wait.wait();
	    driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	    WebElement dropdown = driver.findElement(By.cssSelector("select[style*='width']"));
	    Select dropdownList = new Select(dropdown);
	    dropdownList.selectByVisibleText("Brunei");
	    driver.findElement(By.cssSelector("input[type='checkbox']")).click();
	    driver.findElement(By.xpath("//button[text()='Proceed']")).click();

}
}