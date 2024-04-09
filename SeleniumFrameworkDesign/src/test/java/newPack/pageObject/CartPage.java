package newPack.pageObject;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import newPack.AbstractComponents.AbstractComponent;



public class CartPage extends AbstractComponent{

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(css="div[class='cartSection'] h3")
	List<WebElement> cartList;

	@FindBy(xpath="//button[text()='Checkout']")
	WebElement confirm;

	By checkout = By.xpath("//button[text()='Checkout']");
    Actions a = new Actions(getDriver());



	public int cart(List<String> listedProducts)
	{
	 return	cartList.stream().filter(element->listedProducts.contains(element.getText())).collect(Collectors.toList()).size();
	}

	public PaymentInfo confirmCheckout()
	{
		//scroll(0,709,getDriver());
		a.scrollByAmount(0, 700).build().perform();
		waitForWebElement(confirm);
		confirm.click();
		PaymentInfo paymentInfo = new PaymentInfo(getDriver());
		return paymentInfo;

	}


}
