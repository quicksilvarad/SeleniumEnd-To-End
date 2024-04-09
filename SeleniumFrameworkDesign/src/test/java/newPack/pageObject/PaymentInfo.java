package newPack.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import newPack.AbstractComponents.AbstractComponent;



public class PaymentInfo extends AbstractComponent {

	public PaymentInfo(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	Actions a = new Actions(getDriver());

	@FindBy(css="input[placeholder='Select Country']")
	WebElement dropDown;

	@FindBy(css="span[class*='inserted']")
	List<WebElement> result;

	@FindBy(css="div[class='actions'] a")
	WebElement placeOrder;


	By clickable = By.cssSelector("button[class*='list-group']");
	By confirmOrder = By.cssSelector("div[class='actions'] a");
	public void enterCountry(String country)
	{
		dropDown.sendKeys(country);

	}

	public void checkDropDown(String country)
	{
		waitUntilClickable(clickable);
		a.sendKeys(Keys.ARROW_DOWN).build().perform();
		result.forEach(element->{
 			a.sendKeys(Keys.ARROW_DOWN).build().perform();
		    System.out.println(element.getText());
		    if(element.getText().equalsIgnoreCase(country))
		      {
		       element.click();
		      }});
	}

	public ConfirmationPage order()
	{
		waitUntilClickable(confirmOrder);
		placeOrder.click();
		ConfirmationPage c = new ConfirmationPage(getDriver());
		return c;
	}

}
