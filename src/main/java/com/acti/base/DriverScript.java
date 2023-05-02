package com.acti.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverScript {

	public static WebDriver driver;

	Properties prop;

	public DriverScript() {

		try {
			File file = new File("./src/test/resources/config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {
			System.out.println("unable to load Config.Properties file.Please check" + e.getMessage());
			e.printStackTrace();

		}
	}
	
	@Test
	public void initApplication() {
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println(browser + ": in use");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(browser + ": in use");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		if (browser.equalsIgnoreCase("Edge")) {
			System.out.println(browser + ": in use");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println(browser + " is not supported browser .please check Config.properties file");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		launchURL();
		
	}
	public void launchURL() {
		String url = prop.getProperty("url");
		driver.get(url);;
	}
	public void quitDriver(){
		driver.quit();
	}
	
}
