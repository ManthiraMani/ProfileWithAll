package testclasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import naukripages.LoginObjects;

public class LoginTest extends LoginObjects {
	
	public static Logger log = LogManager.getLogger(LoginTest.class.getName());
	
	
	@BeforeTest
	public void initiateTest() throws Throwable{
		
		setBrowser();
	}
	
	@Test
	public void checkLoginTestCases(){
		
		enterEmilUserName().click();
		enterEmilUserName().clear();
		enterEmilUserName().sendKeys("salaimani.89@gmail.com");
		log.info("Username has been entered");
		
		enterPassword().click();
		enterPassword().clear();
		enterPassword().sendKeys("Salai@123");
		log.info("Password has been entered");
		
		clickOnLogin().click();
		log.info("Login button has been clicked");
			
		
	}
	
	
	@AfterTest
	public void tearDown(){
		//driver.close();
	}

}
