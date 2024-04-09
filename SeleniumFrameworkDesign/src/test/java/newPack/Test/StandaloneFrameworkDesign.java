package newPack.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import newPack.Resources.ExtentReporterNG;
import newPack.TestComponents.BaseTest;
import newPack.TestComponents.Retry;
import newPack.pageObject.CartPage;
import newPack.pageObject.ConfirmationPage;
import newPack.pageObject.OrderList;
import newPack.pageObject.PaymentInfo;
import newPack.pageObject.ProductCatalogue;
import newPack.data.ExcelData;


public class StandaloneFrameworkDesign extends BaseTest {


	@Test (dataProvider="getData", groups={"data"}, retryAnalyzer= Retry.class )
	public void play(HashMap <Object,Object[]> input) throws InterruptedException, IOException

	{


		//LandingPage implementation starts here

		ProductCatalogue productCatalogue = landingPage.loginApplications(input.get("Email")[0].toString(), input.get("Password")[0].toString());
		//LandingPage implementation ends here
        //Assert.assertEquals(productCatalogue.loginSuccessful(), "Login Successfully");
		
		//String z = "ZARA COAT 3";
		/*List<Object> listedproducts = Arrays.asList(input.get("Products"));
		System.out.println(listedproducts.get(0));
		List<String> listedProducts =  listedproducts.stream()
				   .map(object -> Objects.toString(object, null))
				   .toList();
				   */
		String newStr = input.get("Products")[0].toString();
		String[] listedproducts = newStr.split(",");
		List<String> listedProducts = Arrays.asList(listedproducts);
		int x = listedProducts.size();
		System.out.println(x);
		//ProductCatalogue implementation starts here

		List<WebElement> listOfProducts = productCatalogue.getProductList();
		//wb.stream().filter(element->v.contains(element.findElement(By.cssSelector("b")).getText())).forEach(x->x.findElement(By.xpath("//button[2]")).click());
		productCatalogue.addProductsToCart(listOfProducts,listedProducts);

		//Thread.sleep(2000);

		//ProductCatalogue implementation ends here
		//CartPage implementation Starts here
	    CartPage cartPage = productCatalogue.cartList();
		Assert.assertEquals(cartPage.cart(listedProducts), x);


	    //CartPage implementation ends here
	    //PaymentInfo implementation starts here
	    String country = "India"; // Bosnia and Herzegowina

		PaymentInfo p = cartPage.confirmCheckout();
		//Actions a = new Actions(driver);
		p.enterCountry(country);
		p.checkDropDown(country);

		//PaymentInfo implementation ends here


		//ConfirmationPage implementation starts here
		ConfirmationPage cp = p.order();
		cp.printOrders();
        ExtentReporterNG.getReporterObject().flush();
		//ConfirmationPage implementation ends here
	}

	@Test(dependsOnMethods={"play"},dataProvider="getData",groups="data")
	public void play1(HashMap<Object,Object[]> input) throws InterruptedException, IOException

	{


		//LandingPage implementation starts here
		String listedProducts = "IPHONE 13 PRO";
		ProductCatalogue productCatalogue = landingPage.loginApplications(input.get("Email")[0].toString(), input.get("Password")[0].toString());
		OrderList orderList = productCatalogue.goToOrderList();
		orderList.verifyOrderDisplay(listedProducts);
		ExtentReporterNG.getReporterObject().flush();

}
/*
	@DataProvider
	public Object[][] getData() throws IOException
	{
		HashMap <Object,Object[]> map1 = new <Object,Object[]> HashMap();
		HashMap <Object,Object[]> map2 = new <Object,Object> HashMap();
		map1.put("email", new String[]{"tikori@gmail.com"});
		map1.put("password",new String[] {"Tikori69$"});
		map1.put("products", new String[] {"ADIDAS ORIGINAL","ZARA COAT 3","IPHONE 13 PRO"});
		map2.put("email", new String[] {"wanshitong@gmail.com"});
		map2.put("password", new String[] {"Admin@123"});
		map2.put("products",new String[] {"IPHONE 13 PRO"});

        List<HashMap<Object,Object[]>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\newPack\\data\\productList.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		//return new Object[][] {{"tikori@gmail.com","Tikori69$","ADIDAS ORIGINAL","ZARA COAT 3","IPHONE 13 PRO"},{}};
	}
	*/
	@DataProvider
	public Object[][] getData() throws IOException
	{
		ExcelData e = new ExcelData();
		return new Object[][] {{e.myFun("Success")},{e.myFun("Success2")}};
	}
	
	
}

