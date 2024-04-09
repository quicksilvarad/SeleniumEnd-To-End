package newPack.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import newPack.AbstractComponents.AbstractComponent;



public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	//WebElement userEmail = driver.findElement(By.cssSelector("input[type='email']"));

//Page Factory

	@FindBy(id="userEmail")
	WebElement userEmail;

	@FindBy(xpath="//input[@type='password']")
	WebElement userPassword;

	@FindBy(css="input[type='submit']")
	WebElement submit;

	@FindBy(css="[class*='ng-star-inserted']")
	WebElement errorMessage;

	public ProductCatalogue loginApplications(String email, String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}

	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

	public String getErrorMessage()
	{
		waitForWebElement(errorMessage);
		return errorMessage.getText();
	}

}
