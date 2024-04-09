package newPack.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import newPack.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

WebDriver driver;

	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	//List<WebElement> wb = driver.findElements(By.cssSelector("div[class='card-body']"));
//Page Factory

	@FindBy(css="div[class='card-body']")
	List<WebElement> products;            //consolidates list of products



	By productsLocator = By.cssSelector("div[class='card-body']");//stores by locator
	By addToCartConfirm = By.id("toast-container");
    By loginSuccess = By.cssSelector("div[aria-label='Login Successfully']");
	public List<WebElement> getProductList()
	{
		waitForElement(productsLocator);
		return products;
	}


	public String loginSuccessful() 
	{ waitForElement(loginSuccess);
		return driver.findElement(loginSuccess).getText();
	}

	//List<String> listedProducts = Arrays.asList("ADIDAS ORIGINAL","ZARA COAT 3","IPHONE 13 PRO");

	public void addProductsToCart(List<WebElement> products,List<String> listedProducts)
	{
		products.forEach(element->{

			if(listedProducts.contains(element.findElement(By.cssSelector("b")).getText()))
			{
			    element.findElement(By.cssSelector("button[class='btn w-10 rounded']")).click();
			    waitForElement(addToCartConfirm);
			    waitForElementToVanish(addToCartConfirm);
		}});

	}

}
