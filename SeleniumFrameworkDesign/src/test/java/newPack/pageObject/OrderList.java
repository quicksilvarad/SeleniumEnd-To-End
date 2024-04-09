package newPack.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import newPack.AbstractComponents.AbstractComponent;

public class OrderList extends AbstractComponent{

	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productList;

	public OrderList(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub

		}

	public Boolean verifyOrderDisplay(String productName)
	{
		Boolean match = productList.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
	    return match;
	}


}
