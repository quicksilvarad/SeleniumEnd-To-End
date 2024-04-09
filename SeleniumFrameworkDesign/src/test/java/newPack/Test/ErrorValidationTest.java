package newPack.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import newPack.Resources.ExtentReporterNG;
import newPack.TestComponents.BaseTest;
import newPack.pageObject.CartPage;
import newPack.pageObject.ProductCatalogue;

public class ErrorValidationTest extends BaseTest {


	@Test(groups= "ErrorTest")
	public void loginError() throws InterruptedException, IOException

	{


		//LandingPage implementation starts here

		landingPage.loginApplications("tikori@gamil.com", "Tikri69$");
		Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect mail or password.");
		ExtentReporterNG.getReporterObject().flush();
	}

	@Test(groups= "ErrorTest")
	public void itemEquality() throws InterruptedException, IOException

	{


		//LandingPage implementation starts here

		ProductCatalogue productCatalogue = landingPage.loginApplications("tikori@gmail.com", "Tikori69$");
		//LandingPage implementation ends here

		Thread.sleep(2000);
		//String z = "ZARA COAT 3";
		List<String> listedProducts = Arrays.asList("ADIDAS ORIGINAL","ZARA COAT 3","IPHONE 13 PRO");
		int x = listedProducts.size();
		System.out.println(x);
		//ProductCatalogue implementation starts here

		List<WebElement> listOfProducts = productCatalogue.getProductList();
		//wb.stream().filter(element->v.contains(element.findElement(By.cssSelector("b")).getText())).forEach(x->x.findElement(By.xpath("//button[2]")).click());
		productCatalogue.addProductsToCart(listOfProducts,listedProducts);

		

		//ProductCatalogue implementation ends here
		//CartPage implementation Starts here
	    CartPage cartPage = productCatalogue.cartList();
	    Thread.sleep(2000);
		Assert.assertEquals(cartPage.cart(listedProducts), x);
		ExtentReporterNG.getReporterObject().flush();
	}
}

