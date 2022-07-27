package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	
	
	By username = By.id("user-name");
	By password = By.id("password");
	By loginbtn = By.id("login-button");
	
//	public WebElement log()
//	{
//		return driver.findElement(loginbtn);
//		
//	}
	public void usern() {
		driver.findElement(username).sendKeys("standard_user");
	}

	public void passw() {
		 driver.findElement(password).sendKeys("secret_sauce");
	}

	public void login() {
		 driver.findElement(loginbtn).click();	 
	}

}