package newPack.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import newPack.pageObject.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;

	}


	public WebDriver starter() throws IOException {


		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\newPack\\Resources\\Application.properties");
	    prop.load(fis);
	    //to check whether certain value for the property is being sent from console else fall back on the value defined in app.prop
	    String browserName= System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");

	    if (browserName.equals("firefox"))
	    {
		WebDriverManager.firefoxdriver();
	    driver = new FirefoxDriver();


	    }
	    else if (browserName.equals("edge"))
	    {
	    	WebDriverManager.edgedriver();
		    driver = new EdgeDriver();

	    }
	    else if (browserName.contains("chrome"))
	    {
	    	
	    	System.setProperty("ChromeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\chromedriver");
	    	ChromeOptions chrome = new ChromeOptions();
	    	if(browserName.contains("headless")) {
	    	chrome.addArguments("headless");
	    	}
		    driver = new ChromeDriver(chrome);
		    driver.manage().window().setSize(new Dimension(1980,1080));

	    }

	    driver.manage().window().maximize();
	    return driver;
	}
	public List<HashMap<Object,Object[]>> getJsonDataToMap(String filePath) throws IOException
	{
	String jsonContent =	FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
	ObjectMapper objectMapper = new ObjectMapper();

	List<HashMap<Object,Object[]>> data = objectMapper.readValue(jsonContent, new TypeReference<List<HashMap<Object,Object[]>>>(){});
	return data;
	}

	public String takeScreenShot(String testCaseName, WebDriver driver) throws IOException
	{
		Random rand = new Random();
		int x = rand.nextInt(10000);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dstn = System.getProperty("user.dir")+"//null//reports//"+String.valueOf(x)+testCaseName+".jpeg";
		FileUtils.copyFile(src, new File(dstn));
		return dstn;
	}


	@BeforeMethod(alwaysRun=true)
	public LandingPage startApplication() throws IOException
	{
		driver = starter();
		 landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}
}

