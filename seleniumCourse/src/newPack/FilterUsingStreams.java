package newPack;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class FilterUsingStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("EdgeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		String v="v";
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys(v);
		List<WebElement> l = driver.findElements(By.xpath("//tr/td[1]"));
		l.forEach(s->System.out.println(s.getText()));
		System.out.println("------------------");

		List<String> receivedList=l.stream().map(s->s.getText()).collect(Collectors.toList());
		receivedList.forEach(s->System.out.println(s));
		List<WebElement>filteredList=l.stream().filter(s->s.getText().contains(v)).collect(Collectors.toList());
		Assert.assertFalse(filteredList.equals(l));


	}

}
