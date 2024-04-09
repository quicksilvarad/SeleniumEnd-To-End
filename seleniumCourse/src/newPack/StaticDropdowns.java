package newPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdowns {
	
	
	
	//Note- methods used in this class only work with dropdowns with select attributes aka static dropdown
	public static void main(String[] args) 

{
	System.setProperty("EdgeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
	WebDriver driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");//has in-built sync mechanism is present
    WebElement staticDropdown = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
    Select dropdown = new Select(staticDropdown);
    dropdown.selectByIndex(3);//to select the desired value
    System.out.println(dropdown.getFirstSelectedOption().getText());//to get the text from the selected option
    dropdown.selectByVisibleText("AED");
    System.out.println(dropdown.getFirstSelectedOption().getText());
    dropdown.selectByValue("INR");//method to select the item based on the value defined in html
    System.out.println(dropdown.getFirstSelectedOption().getText());
    
}
}