package facebookmessage;

public class FacebookElements {
	public static final String BASED_URL = "https://www.facebook.com/";
	
	/*
	 * gc: google chrome
	 * ff: firefox
	 * ie: internet explorer
	 * safari: safari
	 */
	public static final String BROWSER_TYPE = "gc";
	public static final String MESSAGE = "Hello World";
	public static final long TIMEOUT = 10;
	
	public static final String USERNAME = "thebluesunset1@gmail.com";
	public static final String PASSWORD = "Bommeo123";
	
	
	// Sign In screen
	public static final String SIGNIN_EMAILADDRESS = "//input[@id=\"email\"]";
	public static final String SIGNIN_PASSWORD = "//input[@id=\"pass\"]"; 
	public static final String SIGNIN_SIGNIN = "//label[@id=\"loginbutton\"]";
	
	
	
	// Home screen
	public static final String HOME_MESSAGEPANEL_MESSAGE_UNSELECTED = "//div[@id=\"contentArea\"]//textarea";
	public static final String HOME_MESSAGEPANEL_MESSAGE = "//div[@id=\"contentArea\"]/div[@id=\"stream_pagelet\"]/div[@id=\"pagelet_composer\"]//div[@id=\"feedx_container\"]//div[@role=\"combobox\"]/div/div";
	public static final String HOME_MESSAGEPANEL_POST = "//div[@id=\"contentArea\"]/div[@id=\"stream_pagelet\"]/div[@id=\"pagelet_composer\"]//div[@id=\"feedx_container\"]//div[@data-testid=\"react-composer-root\"]//button/span";
	
	public static final String HOME_MESSAGE_AFTERPOSTED = "//div[contains(@id,\"feed_stream\")]/div[1]//p";

}
