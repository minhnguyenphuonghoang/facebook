package facebookmessage;

import org.testng.annotations.Test;

import com.thoughtworks.selenium.Wait;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.interactions.ClickInSession;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		
		Thread.sleep(5000);
	}
  
	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.get(FacebookElements.BASED_URD);
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
