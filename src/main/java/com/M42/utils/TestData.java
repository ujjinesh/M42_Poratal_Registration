package com.M42.utils;

import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

public class TestData {

	public static Faker faker;
	public static Random random;

	private String Firstname;
	private String Lastname;
	private String email;

	public TestData() {

		faker = new Faker(new Locale("en"));
		this.Firstname = faker.name().firstName();
		this.Lastname = faker.name().lastName();
		this.email = faker.internet().emailAddress();

	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		this.Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		this.Lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String DateAndMonth() {
		// Create an instance of the Faker class
		faker = new Faker();

		// Generate a random month (1-12)
		int month = faker.number().numberBetween(1, 13);

		// Generate a random day based on the month (1-28/29/30/31)
		int day;
		switch (month) {
		case 2: // February
			day = faker.number().numberBetween(1, 29); // Assuming leap years
			break;
		case 4:
		case 6:
		case 9:
		case 11: // April, June, September, November
			day = faker.number().numberBetween(1, 31);
			break;
		default: // January, March, May, July, August, October, December
			day = faker.number().numberBetween(1, 32);
			break;
		}

		return String.format("%02d", day) + "/" + String.format("%02d", month);

	}

	public String mobilenumber() {
		// Create an instance of the Random class
		random = new Random();

		// Define the prefix for UAE mobile numbers
		String prefix = "15";

		// Generate a 9-digit mobile number
		int randomNumber = random.nextInt(9000000) + 1000000; // Ensure it's 7 digits
		// Concatenate the prefix and the random number to form the mobile number
		String uaeMobileNumber = prefix + randomNumber;

		return uaeMobileNumber;
	}

	public String Emirateid() {
		// Create an instance of the Random class
		random = new Random();

		// Generate a 7-digit number
		int randomNumber = random.nextInt(9000000) + 1000000; // Ensure it's 7 digits
		int lastdigit = random.nextInt(10);
		String Emid = "784" + "-" + year() + "-" + randomNumber + "-" + lastdigit;

		return Emid;
	}

	public int year() {
		// Create an instance of the Random class
		random = new Random();

		// Generate a random year between 1900 and 2006
		int minYear = 1900;
		int maxYear = 2006;
		int randomYear = random.nextInt(maxYear - minYear + 1) + minYear;

		return randomYear;
	}

	public String futureyear() {

		// Create a Random object
		random = new Random();

		// Generate a random year between 2025 and 2030
		int minYear = 2025;
		int maxYear = 2030;
		int randomYear = random.nextInt(maxYear - minYear + 1) + minYear;
		String year = String.valueOf(randomYear);
		return year;
	}

}
