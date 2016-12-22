package facebookmessage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;




public class FacebookMessage {
  @Test
  public void postAFacebookMessage() {
//	  System.out.println(FacebookElements.SIGNIN_EMAILADDRESS);
	  inputEmailAddress("thebluesunset1@gmail.com");
	  inputPassword("Bommeo123");
	  
  }
  @BeforeTest
  public void beforeTest() {
	  
	  
	  
  }

  @AfterTest
  public void afterTest() {
	  
	  
	  
  }
  
  
  // keywords
  
  private void inputEmailAddress(String emailAddress){
	  try{
		  System.out.println("input email address");
	  } catch (Exception e) {
		  System.out.println(e);
	  }
	  
  }
  
  
  private void inputPassword(String password){
	  try{
		  System.out.println("input password");
	  } catch (Exception e) {
		  System.out.println(e);
	  }
  }

}
