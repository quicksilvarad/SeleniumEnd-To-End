package newPack;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("EdgeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
		WebDriver driver = new FirefoxDriver();//used to wait till the element comes in viewable state
        driver.get("https://www.rahulshettyacademy.com/angularpractice");
        
       WebElement wb =  driver.findElement(By.cssSelector("input[name='name']"));
       WebElement rel = driver.findElement(with(By.tagName("label")).above(wb));
       System.out.println(rel.getText());
       WebElement wb1 =  driver.findElement(By.cssSelector("label[for='dateofBirth']"));
       WebElement rel1 = driver.findElement(with(By.tagName("input")).below(wb1));
       System.out.println(rel1.getAriaRole());
       WebElement wb2 =  driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
       WebElement rel2 = driver.findElement(with(By.tagName("input")).toLeftOf(wb2));
       System.out.println(rel2.getTagName());
       WebElement wb3 =  driver.findElement(By.cssSelector("input[value='option1']"));
       WebElement rel3 = driver.findElement(with(By.tagName("label")).toRightOf(wb3));
       System.out.println(rel3.getText());
	}

}
