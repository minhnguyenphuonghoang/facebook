package facebookmessage;

public class FacebookElements {
	
	// Sign In screen
	public static final String SIGNIN_EMAILADDRESS = "//input[@id=\"email\"]";
	public static final String SIGNIN_PASSWORD = "//input[@id=\"pass\"]"; 
	public static final String SIGNIN_SIGNIN = "//label[@id=\"loginbutton\"]/input";
	
	
	
	// Home screen
	public static final String HOME_MESSAGEPANEL_AVATAR = "//div[@id=\"contentArea\"]/div[@id=\"stream_pagelet\"]/div[@id=\"pagelet_composer\"]//div[@id=\"feedx_container\"]/div/div[2]/div/div/div/div/a/img";
	public static final String HOME_MESSAGEPANEL_MESSAGE = "//div[@id=\"contentArea\"]/div[@id=\"stream_pagelet\"]/div[@id=\"pagelet_composer\"]//div[@id=\"feedx_container\"]//div[@role=\"combobox\"]/div/div";
	public static final String HOME_MESSAGEPANEL_POST = "//div[@id=\"contentArea\"]/div[@id=\"stream_pagelet\"]/div[@id=\"pagelet_composer\"]//div[@id=\"feedx_container\"]//div[@data-testid=\"react-composer-root\"]//button";
	
	

}
