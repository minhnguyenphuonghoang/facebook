package facebookmessage;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;




public class FacebookMessage {
	
	static WebDriver driver;

	@Test
	public void postAFacebookMessage() throws InterruptedException{
		
		// 1. Sign in to FaceBook
		verifyCurrentScreenIsSignInScreen();
		inputEmailAddress(FacebookElements.USERNAME);
		inputPassword(FacebookElements.PASSWORD);
		clickSignIn();
		
		
		// 2. Post a message
		verifyCurrentScreenIsHomeScreen();
		invokeMessage();
		inputMessage(FacebookElements.MESSAGE);
		Thread.sleep(1000); // sleep 1 second after message was input
		clickPost();
		
		// 3. Verify message after posted
		verifyMessageAfterPosted(FacebookElements.MESSAGE);
		
		Thread.sleep(5000);
	}
  
	@BeforeTest
	public void beforeTest() {
		switch (FacebookElements.BROWSER_TYPE) {
		case "gc":
			driver = new ChromeDriver();
			break;
		case "ff":
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("Incorrect browser_type=" + FacebookElements.BROWSER_TYPE);
			Assert.assertFalse(false);
			break;
		}
		
		driver.manage().window().maximize();
		driver.get(FacebookElements.BASED_URL);
	}

	@AfterTest
	public void afterTest() {
		System.out.println("\nClosing browser...");
		driver.close();
	}
  
  
	// keywords
	
	private void verifyCurrentScreenIsSignInScreen(){
		new WebDriverWait(driver, FacebookElements.TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(FacebookElements.SIGNIN_EMAILADDRESS)));
		new WebDriverWait(driver, FacebookElements.TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(FacebookElements.SIGNIN_PASSWORD)));
		new WebDriverWait(driver, FacebookElements.TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(FacebookElements.SIGNIN_SIGNIN)));
	}
	
	private void verifyMessageAfterPosted(String message){
		try{
			new WebDriverWait(driver, 10).until(ExpectedConditions.textToBe(By.xpath(FacebookElements.HOME_MESSAGEPANEL_MESSAGE), ""));
			
			WebElement postedMessage = new WebDriverWait(driver, FacebookElements.TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(FacebookElements.HOME_MESSAGE_AFTERPOSTED)));
			String currentText = postedMessage.getText();
			Assert.assertEquals(currentText, message);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void inputEmailAddress(String emailAddress){
		try{
			driver.findElement(By.xpath(FacebookElements.SIGNIN_EMAILADDRESS)).sendKeys(emailAddress);
		} catch (Exception e) {
			System.out.println("Couldn't input email address!");
			System.out.println(e);
		}
	}
  
  
	private void inputPassword(String password){
		try{
			driver.findElement(By.xpath(FacebookElements.SIGNIN_PASSWORD)).sendKeys(password);
		} catch (Exception e) {
			System.out.println("Couldn't input password!");
			System.out.println(e);
		}
	}
	
	private void clickSignIn(){
		try{
			driver.findElement(By.xpath(FacebookElements.SIGNIN_SIGNIN)).click();
		} catch (Exception e) {
			System.out.println("Couldn't click on Sign In button!");
			System.out.println(e);
		}
	}
	
	
	private void verifyCurrentScreenIsHomeScreen(){
		new WebDriverWait(driver, FacebookElements.TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(FacebookElements.HOME_MESSAGEPANEL_MESSAGE_UNSELECTED)));
		// new WebDriverWait(driver, FacebookElements.TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(FacebookElements.HOME_MESSAGEPANEL_MESSAGE)));
		// new WebDriverWait(driver, FacebookElements.TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(FacebookElements.HOME_MESSAGEPANEL_POST)));
	}
	
	private void invokeMessage(){
		try{
			driver.findElement(By.xpath(FacebookElements.HOME_MESSAGEPANEL_MESSAGE_UNSELECTED)).click();
		} catch (Exception e) {
			System.out.println("Couldn't find Message to invoke on Home screen");
			System.out.println(e);
		}
	}
	private void inputMessage(String message){
		try{
			WebElement a = new WebDriverWait(driver, FacebookElements.TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(FacebookElements.HOME_MESSAGEPANEL_MESSAGE_UNSELECTED)));
			a.sendKeys(message);
			//driver.findElement(By.xpath(FacebookElements.HOME_MESSAGEPANEL_MESSAGE)).sendKeys(message);
		} catch (Exception e) {
			System.out.println("Couldn't found message on Home Screen!");
			System.out.println(e);
		}
	}
	
	private void clickPost(){
		try{
			driver.findElement(By.xpath(FacebookElements.HOME_MESSAGEPANEL_POST)).click();
		} catch (Exception e) {
			System.out.println("Couldn't click on Post button on Home Screen!");
			System.out.println(e);
		}
	}
}
