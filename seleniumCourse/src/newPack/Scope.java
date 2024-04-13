package newPack;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("EdgeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));//plays role of sub-driver
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		WebElement columnDriver = driver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());

	    int noOfClicks =1;
	    Set<String> s = driver.getWindowHandles();
		for (int i=1 ; i<columnDriver.findElements(By.tagName("a")).size() ; i++)
		{
			//Actions a = new Actions((WebDriver) columnDriver.findElement(By.tagName("a")));
			String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);

			s= driver.getWindowHandles();
			System.out.println(s.size());
			System.out.println("Successfully opened tabs:"+s.size()+" , " + "Link no.:" + noOfClicks);
			noOfClicks++;

		}
		Thread.sleep(6000);

	    /*Iterator<String> it = s.iterator();

	    while(it.hasNext())
	    {
	    	driver.switchTo().window(it.next());
	    	System.out.println(driver.getTitle());
	    }*/
		s.forEach(element->{System.out.println(driver.switchTo().window(element).getTitle());});
		driver.quit();

	}

}
