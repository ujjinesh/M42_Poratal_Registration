package com.M42.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;
import com.google.common.io.Files;

public class selenium_Function_utils {

	public static void click(WebDriver driver, String locatorvalue) {
		try {
			driver.findElement(By.xpath(locatorvalue)).click();
			System.out.println("Clicked on element");
		} catch (Exception e) {
			System.out.println("Failed to click on element");
			e.printStackTrace();
		}
	}

	public static void clear(WebDriver driver, String locatorvalue) {
		driver.findElement(By.xpath(locatorvalue)).clear();
	}
	
	public static boolean type(WebElement element, String text) {
		try {
			// element.clear();
			element.sendKeys(text);
			System.out.println("Typed '" + text + "' into the element");
			return true;
		} catch (Exception e) {
			System.out.println("Failed to type text into the element");
			e.printStackTrace();
			return false;
		}
	}

	public static void jstype(WebDriver driver, String value, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + value + "';", element);

	}

	public static void jsclick(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

	}

	public static void genderselection(WebDriver driver) {
		// Use Faker to generate a gender
		Faker faker = new Faker();
		String gender = faker.options().option("Male", "Female");

		WebElement genderRadioButton = driver.findElement(By.xpath("//*[@class='gender ']"));
		if (gender.equalsIgnoreCase("male")) {
			genderRadioButton.findElement(By.xpath("//*[@for='Male']")).click();
		} else if (gender.equalsIgnoreCase("female")) {
			genderRadioButton.findElement(By.xpath("//*[@for='Female']")).click();
		}
	}

	public static void MouseHoverelement(WebDriver driver, WebElement element) {

		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}

	public static void explicitwait(WebDriver driver,String Locatorvalue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locatorvalue)));
	}

	public static void screenshot(WebDriver driver, String Path) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		try {
			File src = ts.getScreenshotAs(OutputType.FILE);
			File tar = new File(Path);
			Files.copy(src, tar);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void MouseClick(WebDriver driver, WebElement element) {

		 new Actions(driver)
	        .moveToElement(element)
	        .click()
	        .perform();

	}

	public static void Mousesendkeys(WebDriver driver, String value) {

		new Actions(driver)
		.sendKeys(value)
		.perform();

	}

	public static void Mousesendkeys(WebDriver driver, WebElement element, String value) {

		new Actions(driver)
		.sendKeys(element, value)
		.perform();

	}
}
