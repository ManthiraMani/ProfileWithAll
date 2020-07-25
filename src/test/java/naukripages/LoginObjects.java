package naukripages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.Base;

public class LoginObjects extends Base {
	
	
	public WebElement enterEmilUserName(){
		
		WebElement email=driver.findElement(By.xpath("//input[@placeholder='Enter Email ID / Username']"));
		return email;
	}
	
	
	public WebElement enterPassword(){
		
		WebElement pwd=driver.findElement(By.xpath("//input[@id='passwordField']"));
		return pwd;
	}
	
	
	public WebElement clickOnLogin(){
		
		WebElement pwd=driver.findElement(By.xpath("//button[text()='Login']"));
		return pwd;
	}

	
	
	
}
