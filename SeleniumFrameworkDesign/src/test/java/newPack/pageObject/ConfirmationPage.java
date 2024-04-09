package newPack.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import newPack.AbstractComponents.AbstractComponent;



public class ConfirmationPage extends AbstractComponent {

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By orders = By.cssSelector("label[class='ng-star-inserted']");

	@FindBy(css="label[class='ng-star-inserted']")
	List <WebElement> orderList;

public void printOrders()
{
    waitForElement(orders);
	System.out.println("Following are the orders grabbed:");
	orderList.forEach(element->{System.out.println("Order : "+element.getText());});
}

}
