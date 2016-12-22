package wallethub;

import facebookmessage.FacebookElements;

public class WalletHubElements {
	public static final String URL_SIGNIN = "https://wallethub.com/join/login";
	public static final String URL_REVIEW = "https://wallethub.com/profile/test_insurance_company/";
	public static final String USERNAME = "test_inscomp@evolutionfinance.com";
	public static final String PASSWORD = "Abcd123*";
	public static final long TIMEOUT = 10;
	
	
	// LOGIN screen
	public static final String LOGIN_EMAILADDRESS = "//input[@placeholder=\"Email Address\"]";
	public static final String LOGIN_PASSWORD = "//input[@placeholder=\"Password\"]";
	public static final String LOGIN_LOGIN = "//button/span[text()=\"Login\"]";
	
	
	// REVIEW screen
	public static final String HOME_RATING_UNSELECTED = "//div[@class=\"maininfo\"]//span[contains(@class,\"wh-rating\")]";
	public static final String HOME_RATING_5STARTS = "//div[@class=\"maininfo\"]//div[@class=\"wh-rating-choices\"]/div/a[text()=\"5\"]";
	
	
	// WRITE A REVIEW screen
	public static final String REVIEW_SELECTPOLICY = "//form[@id=\"reviewform\"]//span[text()=\"Please select your policy\"]";
	public static final String REVIEW_POLICY_HEALTH = "//form[@id=\"reviewform\"]//ul/li/a[@data-target=\"Health\"]";
	public static final String REVIEW_MESSAGE = "//form[@id=\"reviewform\"]//textarea[@id=\"review-content\"]";
	public static final String REVIEW_SUBMIT = "//form[@id=\"reviewform\"]//input[@value=\"Submit\"]";
	public static final String REVIEW_SUCESSFULMESSAGE = "//div[@id=\"review\"]/div/h1";
}
