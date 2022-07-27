package com.testCases;




import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.pages.HomePage;

@Listeners(com.utilities.ListenerClass.class)
public class HomePageTest extends BaseClass
{

	HomePage s;
	
	@Test
	public void signIn()
	{
		
		s = new HomePage(driver);
		s.usern();
		s.passw();
		s.login();	
		String title = driver.getTitle();
		Assert.assertEquals(title, "Swag Labs");
	}
	
	

}
