package wallethub;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class WalletHubReview {
	static WebDriver driver;
	
	@Test
	public void f() throws InterruptedException {
		// 1. Log in
		signInWalletHub(WalletHubElements.USERNAME, WalletHubElements.PASSWORD);
		
		// 2. Navigate to review site
		driver.navigate().to(WalletHubElements.URL_REVIEW);
		
		
		// 3. select 5 starts
		
		
		// 4. select health & review & submit & verify
		
		
		
		Thread.sleep(5000);
	}
	
	
	
	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(WalletHubElements.URL_SIGNIN);
	}

	
	
	@AfterTest
	public void afterTest() {
		System.out.println("\nClosing browser...");
		driver.close();
	}
	
	// 
	
	private void verifyCurrentScreenIsProfileScreen(){
		new WebDriverWait(driver, WalletHubElements.TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(WalletHubElements.HOME_RATING_UNSELECTED)));
	}
	
	
	
	
	// Sign In
	private void signInWalletHub(String username, String password){
		verifyCurrentScreenIsLogInScreen();
		inputEmailAddress(username);
		inputPassword(password);
		clickLogIn();
		verifyLoginSuccessful();
		
	}
	
	private void verifyCurrentScreenIsLogInScreen(){
		new WebDriverWait(driver, WalletHubElements.TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(WalletHubElements.LOGIN_EMAILADDRESS)));
		new WebDriverWait(driver, WalletHubElements.TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(WalletHubElements.LOGIN_PASSWORD)));
		new WebDriverWait(driver, WalletHubElements.TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(WalletHubElements.LOGIN_LOGIN)));
	}

	private void inputEmailAddress(String emailAddress){
		try{
			driver.findElement(By.xpath(WalletHubElements.LOGIN_EMAILADDRESS)).sendKeys(emailAddress);
		} catch (Exception e) {
			System.out.println("Couldn't find email address!");
			System.out.println(e);
		}
	}
	
	private void inputPassword(String password){
		try{
			driver.findElement(By.xpath(WalletHubElements.LOGIN_PASSWORD)).sendKeys(password);
		} catch (Exception e) {
			System.out.println("Couldn't find password textfied!");
			System.out.println(e);
		}
	}
	
	private void clickLogIn(){
		try{
			driver.findElement(By.xpath(WalletHubElements.LOGIN_LOGIN)).click();
		} catch (Exception e) {
			System.out.println("Couldn't find Login button");
			System.out.println(e);
		}
	}
	
	private void verifyLoginSuccessful(){
		new WebDriverWait(driver, WalletHubElements.TIMEOUT).until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath(WalletHubElements.LOGIN_EMAILADDRESS))));
		new WebDriverWait(driver, WalletHubElements.TIMEOUT).until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath(WalletHubElements.LOGIN_PASSWORD))));
		new WebDriverWait(driver, WalletHubElements.TIMEOUT).until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath(WalletHubElements.LOGIN_LOGIN))));
	}
	
	
}
