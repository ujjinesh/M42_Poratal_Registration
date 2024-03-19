package com.M42.execution;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.M42.pages.RegistrationPage;
import com.M42.utils.AllureListener;
import com.M42.utils.BaseClass;
import com.M42.utils.TestData;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners({ AllureListener.class })
public class TestExecution extends BaseClass {

	
	BaseClass bs;

	@BeforeClass
	public void setUp() throws Throwable {
		bs = new BaseClass();
		bs.initialize_driver();
	}
	
	@Test
	@Description("Verify Registration a patient on M42 Portal........")
	@Severity(SeverityLevel.BLOCKER)
	@Owner("Bandi Ujjinesh")
	@Epic("E001")
	@Feature("Feature1: Registration")
	@Story("Story:Register a patient")
	@Step("Verify Register a patient")
	@Link(name = "M42 Dev Portal", url = "https://mh-dev-patientportal.azurewebsites.net/signup")
	public void PatientRegistration() throws Throwable  {

		TestData td = new TestData();

		String EID =td.Emirateid();
		String exiprydate = td.DateAndMonth()+"/"+td.futureyear();
		
		RegistrationPage registration = PageFactory.initElements(driver, RegistrationPage.class);
		registration.PatientRegistration(EID,exiprydate,td.getFirstname(), td.getLastname(),
				td.DateAndMonth()+"/"+EID.substring(4, 8), td.getEmail(), td.mobilenumber());

	}
	
	
	@AfterClass
	public void close() {
		
		bs.teardown();
	}
	

}
