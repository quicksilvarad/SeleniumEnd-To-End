package newPack;


import java.time.Duration;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		//options.setAcceptInsecureCerts(false);
		//options.addExtensions(C:\\Program Files\\Google\\Chrome\\Application\\120.0.6099.130\\Extensions\external_extensions.json);
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ip:8080:11773:8989:3628");
		options.setCapability("proxy", proxy);
		System.setProperty("ChromeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
		WebDriver driver = new ChromeDriver(options);
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().window().maximize();
	    driver.get("https://expired.badssl.com/");
	    

	}

}
