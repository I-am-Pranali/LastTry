package com.FullScreenScreenShot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

public class ScreenshotOfElement {

	public static WebDriver driver ;
	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://www.facebook.com/");	
		driver.manage().window().maximize();
		
        WebElement logBtn=driver.findElement(By.xpath("//*[@class= '_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        Screenshot sourceFile = new AShot().takeScreenshot(driver,logBtn);
		//Screenshot sourceFile = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, logBtn);
		File destFile = new File(".\\target\\"+"loginBtn.png");
		
		
		try {
			ImageIO.write(sourceFile.getImage(), "png", destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		//driver.close();

	}

}
