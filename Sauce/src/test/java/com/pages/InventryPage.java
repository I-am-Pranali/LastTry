package com.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InventryPage 
{
	WebDriver driver;

	public InventryPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By backpack_btn = By.id("add-to-cart-sauce-labs-backpack");
	By tshirt_btn = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
	By cart = By.className("shopping_cart_badge");
	By remove_btn = By.id("remove-sauce-labs-backpack");
	

	public void add_backpack()
	{
		driver.findElement(backpack_btn).click();
		Boolean x =driver.findElement(remove_btn).isDisplayed();
		Assert.assertEquals(true, x);

	}
	
	public void add_tshirt()
	{
		driver.findElement(tshirt_btn).click();
	}

}
