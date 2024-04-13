package newPack;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultipleWindowsDemo {
// Section 15
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("EdgeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
		WebDriver driver = new FirefoxDriver();//used to wait till the element comes in viewable state
        driver.get("https://www.rahulshettyacademy.com/angularpractice");
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> set = driver.getWindowHandles();
        Iterator<String> it = set.iterator();
        String parentWindow=it.next();
        String childWindow=it.next();
        driver.switchTo().window(childWindow).get("https://www.rahulshettyacademy.com");
        WebElement wb = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1);
        String d = wb.getText();
        System.out.println(d);
        driver.switchTo().window(parentWindow);
        WebElement name = driver.findElement(By.cssSelector("input[name='name']"));
        name.sendKeys(d);
        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("F://logo.png"));
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());




	}

}
