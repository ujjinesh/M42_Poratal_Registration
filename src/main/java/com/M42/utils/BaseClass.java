package com.M42.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	
	public WebDriver initialize_driver() throws Throwable {
		
			//WebDriverManager.chromedriver().setup();
		
		if (Property.getValueForKey("Browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			tdriver.set(driver);
			driver.get(Property.getValueForKey("url"));
		} else if (Property.getValueForKey("Browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			tdriver.set(driver);
			driver.get(Property.getValueForKey("url"));
		} else {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			tdriver.set(driver);
			driver.get(Property.getValueForKey("url"));
		}
		
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}
	
	
	public  void teardown() {
		driver.quit();
		
	}
}
