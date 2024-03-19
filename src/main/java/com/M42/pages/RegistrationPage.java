package com.M42.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.M42.utils.BaseClass;
import com.M42.utils.selenium_Function_utils;

public class RegistrationPage extends BaseClass {

	
	
	@FindBy(xpath = "//*[@href='/signup']")
	WebElement Signup;
	
	@FindBy(xpath = "//*[@id='EmiratesIdNumber']")
	WebElement EmiratesIdNumber;

	@FindBy(xpath = "//*[@id='EmiratesExpiryDate']")
	WebElement EmiratesExpiryDate;

	@FindBy(xpath = "//*[@id='QRFirstName']")
	WebElement QRFirstName;

	@FindBy(xpath = "//*[@id='QRLastName']")
	WebElement QRLastName;
/*
	@FindBy(xpath = "//*[@class='gender ']")
	String gender;

	@FindBy(xpath = "//*[@for='Male']")
	String Male;

	@FindBy(xpath = "//*[@for='Female']")
	String Female;

*/
	@FindBy(xpath = "//*[@id='DateofBirth']")
	WebElement DateofBirth;

	@FindBy(xpath = "//*[@id='Email']")
	WebElement Email;

	@FindBy(xpath = "//*[@class='gmail-dropdown-item']")
	WebElement gmaildomain;
	
	
	@FindBy(xpath = "//*[@id='mobileNumber']")
	WebElement mobileNumber;

	@FindBy(xpath = "//*[text()='Save & Continue']")
	WebElement QRButton;
	
	
	@FindBy(xpath = "//*[@id='login-LoginButton']")
	WebElement Login;
	

	public void PatientRegistration(String EmirateID,String Expirydate, String Firstname, String Lastname,String DOB,
			String emailId, String Mobilenumber) throws Throwable {

		selenium_Function_utils.explicitwait(driver, "//*[@id='EmiratesIdNumber']");
		selenium_Function_utils.jstype(driver, EmirateID, EmiratesIdNumber);
		selenium_Function_utils.type(EmiratesIdNumber, EmirateID);
		
		selenium_Function_utils.Mousesendkeys(driver, EmiratesExpiryDate, Expirydate);
		selenium_Function_utils.type(QRFirstName, Firstname);
		selenium_Function_utils.type(QRLastName, Lastname);
		selenium_Function_utils.genderselection(driver);
		selenium_Function_utils.Mousesendkeys(driver, DateofBirth, DOB);
		selenium_Function_utils.type(Email, emailId);
		selenium_Function_utils.MouseHoverelement(driver, gmaildomain);
		selenium_Function_utils.type(mobileNumber, Mobilenumber);
		selenium_Function_utils.screenshot(driver, ".\\screenshot\\before_Reg_Click.jpg");
		selenium_Function_utils.MouseClick(driver, QRButton);
		selenium_Function_utils.explicitwait(driver,"//*[@id='login-LoginButton']");
		selenium_Function_utils.screenshot(driver, ".\\screenshot\\After_Reg_Click.jpg");
		
		//selenium_Function_utils.jsclick(driver, driver.findElement(By.xpath("//*[@id='QRButton']")));

	}
}

