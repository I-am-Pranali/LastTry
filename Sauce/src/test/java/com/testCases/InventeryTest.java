package com.testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pages.InventryPage;
@Listeners(com.utilities.ListenerClass.class)
public class InventeryTest extends BaseClass
{
	InventryPage i;
	
	@Test
	public void addToCart()
	{
		
		i = new InventryPage(driver);
		i.add_backpack();
		//i.add_tshirt();
		
	}

}
