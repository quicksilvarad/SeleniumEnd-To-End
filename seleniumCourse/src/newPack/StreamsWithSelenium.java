package newPack;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StreamsWithSelenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("EdgeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//used to wait till the element comes in viewable state
        driver.get("https://www.rahulshettyacademy.com/seleniumPractise");
        //capture all webelements into a list
        //capture text of all webelements into a new original list
        //apply sort on the original list in step 3 ->sorted list
        //compare original list vs sorted list
        driver.findElement(By.cssSelector("a[href*='offers']")).click();
        Thread.sleep(2000);
        Set<String> set = driver.getWindowHandles();
        Iterator<String> it = set.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        //driver.findElement(By.xpath("//table//tr/th[1]"));

        //List<WebElement> wb = driver.findElements(By.xpath("//table//tr/td[1]"));
        //List<String> l =  wb.stream().map(s->s.getText()).collect(Collectors.toList());
        //List<String> o =  l.stream().sorted().collect(Collectors.toList());
        //Assert.assertTrue(l.equals(o));
        List <String> price;
        //pagination concept -> searching for an element across multiple pages within a page
        do {
        	List<WebElement> wb = driver.findElements(By.xpath("//table//tr/td[1]"));
         price = wb.stream().filter(s->s.getText().contains("Beans")).map(s->getVeggiePrice(s)).collect(Collectors.toList());
        price.forEach(element->System.out.println(element));
        if(price.size()<1)
        {
        	driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
        	Thread.sleep(2000);
        }
        }while(price.size()<1);
	}

	//custom method to get the price
	public static String getVeggiePrice(WebElement b)
	{
		return b.findElement(By.xpath("following-sibling::td[1]")).getText();
	}
}
