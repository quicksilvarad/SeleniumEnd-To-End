package newPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("EdgeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://jqueryui.com/droppable/");
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));//tells about the number of frames present
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();//moves back from frame
		System.out.println(driver.findElement(By.xpath("//head/title")).getText());


	}

}
