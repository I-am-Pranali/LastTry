package com.FullScreenScreenShot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Duration;

import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SS {

	public static WebDriver driver ;
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com/");	
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement logBtn=driver.findElement(By.id("login-button"));
		Thread.sleep(3000);
		File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullimg=ImageIO.read(screenshot);
		
		Point point= logBtn.getLocation();
		int width=logBtn.getSize().getWidth();
		int hight=logBtn.getSize().getHeight()+200;
		

		BufferedImage elescreenshot=fullimg.getSubimage(point.getX(), point.getY(), width, hight);
		ImageIO.write(elescreenshot, "png", screenshot);
		
		File destFile = new File(".\\target\\"+"ssss.png");
		FileUtils.copyFile(screenshot, destFile);

	}

}
