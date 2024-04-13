package newPack;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class BrokenLinksTest {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("EdgeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
		WebDriver driver = new FirefoxDriver();
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().window().maximize();
	    driver.get("https://rahulshettyacademy.com/AutomationPractice");
	    List<WebElement> wb = driver.findElements(By.cssSelector("div[id='gf-BIG'] a"));
	    //wb.forEach(element->{element.getAttribute("href");});
	    System.out.println(wb.size());
	    SoftAssert a = new SoftAssert();
	    for(WebElement link : wb) {
	    //Step1- to get all the urls tied up to the links
	    //Step2- Java methods call url and get u the status code
	    //Step3- if status code > 400 link is not working
	    String url = link.getAttribute("href");
	    System.out.println(url);
	    HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
	    conn.setRequestMethod("HEAD");
	    conn.connect();
	    int res = conn.getResponseCode();
	    System.out.println(res);
	    //a.assertFalse(res<400, "TC failed");
	    }

	}

}
