package newPack.tepDefinition;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import newPack.TestComponents.BaseTest;
import newPack.pageObject.CartPage;
import newPack.pageObject.ConfirmationPage;
import newPack.pageObject.LandingPage;
import newPack.pageObject.PaymentInfo;
import newPack.pageObject.ProductCatalogue;

public class StepDefinitionImpl extends BaseTest {
	
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public CartPage cartPage;
	List<String> listedProducts;
	int x;
	ConfirmationPage cp;
	String message;
	@Given("User already landed on E-commerce page")
	 public void getOnLandingPage() throws IOException 
	{
		landingPage = startApplication();
		
	}
	
	@And("^Logged in with username (.+) and password (.+)$")
	public void loginMethod(String usrnm, String pswd) {
	 productCatalogue = landingPage.loginApplications(usrnm, pswd);

	}
	
	@When("I add product to the cart")
	public void addToCart(List<String> listedproducts) 
	{
		
		listedProducts = listedproducts;
		x = listedProducts.size();
		System.out.println(x);
		//ProductCatalogue implementation starts here

		List<WebElement> listOfProducts = productCatalogue.getProductList();
		//wb.stream().filter(element->v.contains(element.findElement(By.cssSelector("b")).getText())).forEach(x->x.findElement(By.xpath("//button[2]")).click());
		productCatalogue.addProductsToCart(listOfProducts,listedProducts);
	}
	
	@And("Checkout the product")
	
	public void checkoutOrder(List<String> listedProducts) 
	{
		 cartPage = productCatalogue.cartList();
			Assert.assertEquals(cartPage.cart(listedProducts), x);
			 String country = "India"; // Bosnia and Herzegowina

				PaymentInfo p = cartPage.confirmCheckout();
				p.enterCountry(country);
				p.checkDropDown(country);
				cp = p.order();
				cp.printOrders();
	}
	
	 @Then("Validate if the {string} is printed")
	 public void validateOrderDisplay(String string) 
	 {
		 Assert.assertFalse(message.contains(string));
		 
	 }
}
