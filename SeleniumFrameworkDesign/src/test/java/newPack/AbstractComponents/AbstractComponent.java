package newPack.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import newPack.pageObject.CartPage;
import newPack.pageObject.OrderList;

public class AbstractComponent {

	private WebDriver driver;

	@FindBy(css="button[routerlink*='cart']")
	WebElement cart;

	@FindBy(css="button[routerlink*='myorders']")
    WebElement orderlist;

	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
	  this.setDriver(driver);
	  PageFactory.initElements(driver, this);
	}

	public CartPage cartList()
	{
		cart.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}

	JavascriptExecutor js = (JavascriptExecutor) getDriver();


	public void waitForElement(By findBy)
	{
	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForWebElement(WebElement webElement)
	{
	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	public void waitForElementToVanish(By findBy)
	{
	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}

	public OrderList goToOrderList()
	{
		orderlist.click();
		OrderList orderList = new OrderList(driver);
		return orderList;
	}

	public void waitUntilClickable(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void scroll(int x, int y, WebDriver driver)
	{

		String a = Integer.toString(x);
		String b = Integer.toString(y);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo('"+a+"','"+b+"')","");
	}

	}

