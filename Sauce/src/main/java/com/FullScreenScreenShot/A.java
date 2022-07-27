package com.FullScreenScreenShot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class A {

	public static WebDriver driver ;
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.google.com/search?q=amazon+prime&rlz="
				+ "1C1SQJL_enIN923IN923&oq=&aqs=chrome.1."
				+ "35i39i362l3j46i39i362j35i39i362l4."
				+ "122875774j0j15&sourceid=chrome&ie=UTF-8");	
		driver.manage().window().maximize();
		
		
		Screenshot sourceFile = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		File destFile = new File(".\\target\\"+"full.png");
		
		try {
			ImageIO.write(sourceFile.getImage(), "png", destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
