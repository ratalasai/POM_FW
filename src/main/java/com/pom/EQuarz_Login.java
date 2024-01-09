package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class EQuarz_Login extends TestBase {

	//WebElements address and initiate this by using pageFactory class 
	
		@FindBy (id="si-email")
		WebElement username;

		@FindBy (id="si-password")
		WebElement password;

		@FindBy (xpath="//button[text()='Sign in']")
		WebElement signin;

		public EQuarz_Login(WebDriver driver) {
			// TODO Auto-generated constructor stub
		}
		public void LoginFunctionality(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		public EQuarz_Homepage dologin() {
			username.sendKeys(prop.getProperty("username"));
			password.sendKeys(prop.getProperty("password"));
			signin.click();

			return new EQuarz_Homepage();
		}
	
	
}
