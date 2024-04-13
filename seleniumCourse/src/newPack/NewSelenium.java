package newPack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class NewSelenium {

	public static void main(String[] args) throws InterruptedException
	{

		System.setProperty("EdgeDriver", "C:\\Users\\Asus\\Projects\\Selenium\\geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//used to wait till the element comes in viewable state
        driver.get("https://www.rahulshettyacademy.com/locatorspractice");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");//using Id locator
        driver.findElement(By.name("inputPassword")).sendKeys("hello@123"); //using name as locator
        driver.findElement(By.className("signInBtn")).click();//using class name as locator
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText()); //using css selector as locator. also generic syntax for css selectors tagname[attribute='value']
        System.out.println(driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/form/p")).getText()); //using xpath as locator
		driver.findElement(By.linkText("Forgot your password?")).click();
		//Syntax for xpath //tagname[@attribute='value']
		//To write xpath with tags //parent/child[index]
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Vanadium");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("abc@xyz.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear(); //using xpath with index
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("abs@koogle.com");//using cssloactor with index
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("696969696969");
		Thread.sleep(1000);
		driver.findElement(By.className("reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector(".infoMsg")).getText());
		String pwd = driver.findElement(By.cssSelector(".infoMsg")).getText();
		pwd = pwd.substring(pwd.indexOf("'")+1,pwd.lastIndexOf("'"));
		System.out.println(pwd);
		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("inputUsername")).sendKeys("pappu");//using Id locator
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(pwd); //using name as locator
        driver.findElement(By.xpath("//input[contains(@value,\"rmbr\")]")).click();
        driver.findElement(By.className("signInBtn")).click();//using class name as locator
        System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText(),"You are successfully logged in.");
        Thread.sleep(10000);
        driver.findElement(By.cssSelector(".logout-btn")).click();
        //to use regex in css selector syntax is input[type*=text]
        driver.close();
        Assert.assertEquals(false, null);
		}

	}


