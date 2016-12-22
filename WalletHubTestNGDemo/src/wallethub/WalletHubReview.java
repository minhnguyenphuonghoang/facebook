package wallethub;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
		selectStars(5);
		
		
		// 4. select health & write a review message & submit & verify
		verifyCurrentScreenIsReviewScreen();
		selectHealth();
		Thread.sleep(1000); //wait till page is loaded
		writeAReviewMessage(WalletHubElements.MESSAGE);
		clickSubmit();
		verifyMessageAfterPosted(WalletHubElements.MESSAGE);
		
		
		Thread.sleep(2000);
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
	
	// 4. select health & review & submit & verify
	private void verifyCurrentScreenIsReviewScreen(){
		new WebDriverWait(driver, WalletHubElements.TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(WalletHubElements.REVIEW_SELECTPOLICY)));
		new WebDriverWait(driver, WalletHubElements.TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(WalletHubElements.REVIEW_MESSAGE)));
		new WebDriverWait(driver, WalletHubElements.TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(WalletHubElements.REVIEW_SUBMIT)));
	
	}
	
	private void selectHealth(){
		
		try{
			driver.findElement(By.xpath(WalletHubElements.REVIEW_SELECTPOLICY)).click();
			WebElement healthItem = new WebDriverWait(driver, WalletHubElements.TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(WalletHubElements.REVIEW_POLICY_HEALTH)));
			healthItem.click();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}
	
	private void writeAReviewMessage(String reviewMessage){
		try{
			WebElement reviewMessageElement = new WebDriverWait(driver, WalletHubElements.TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(WalletHubElements.REVIEW_MESSAGE)));
			reviewMessageElement.clear();
			reviewMessageElement.sendKeys(reviewMessage);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void clickSubmit(){
		try{
			driver.findElement(By.xpath(WalletHubElements.REVIEW_SUBMIT)).click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	private void verifyMessageAfterPosted(String message){
		try{
			new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(WalletHubElements.REVIEW_SUBMIT)));
			WebElement reviewMessageElement = new WebDriverWait(driver, WalletHubElements.TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(WalletHubElements.REVIEW_MESSAGE_RECORDED)));
			String currentText = reviewMessageElement.getText();
			currentText = currentText.replaceAll("\n", " ");
			Assert.assertEquals(currentText, message);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	// 3. select 5 starts 
	private void selectStars(int numberOfStars){
		try{
			// 1. hover
			WebElement ratingUnselected = new WebDriverWait(driver, WalletHubElements.TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(WalletHubElements.HOME_RATING_UNSELECTED)));
			Actions action = new Actions(driver);
			action.moveToElement(ratingUnselected).build().perform();
			WebElement rating5Stars = new WebDriverWait(driver, WalletHubElements.TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(WalletHubElements.HOME_RATING_5STARTS)));
			
			// 2. click on number of stars
			switch (numberOfStars) {
			case 5:
				rating5Stars.click();
				break;
			default:
				System.out.println("Not implemented");
				break;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	// 1. Sign In
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
		new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(WalletHubElements.LOGIN_EMAILADDRESS)));
		new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(WalletHubElements.LOGIN_PASSWORD)));
		new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(WalletHubElements.LOGIN_LOGIN)));
	}
	
	
}
