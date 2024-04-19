package com.techdome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ecomtestcases {

	private WebDriver driver;
	private int maxRetries = 3;

	public void setup() {
		// Set the path to the msedgedriver executable
		System.setProperty("webdriver.edge.driver", "C:\\DRIVER\\msedgedriver.exe");

		// Retry setup for a maximum of 3 times
		for (int i = 0; i < maxRetries; i++) {
			try {
				// Create a new instance of the Edge driver
				driver = new EdgeDriver();
				// Navigate to the Amazon website
				driver.get("https://www.amazon.in");
				// Maximize the browser window
				driver.manage().window().maximize();
				break; // If setup is successful, exit the loop
			} catch (Exception e) {
				System.out.println("Failed to setup browser. Retrying...");
				if (i == maxRetries - 1) {
					System.out.println("Failed to setup browser after maximum retries. Exiting...");
					throw e;
				}
			}
		}
	}

	public void loginTest() {
		// Find the Sign In button and click on it
		WebElement signInButton = driver.findElement(By.id("nav-link-accountList"));
		signInButton.click();

		// Enter the email or mobile phone number
		WebElement emailInput = driver.findElement(By.id("ap_email"));
		emailInput.sendKeys("umakrishn50@gmail.com");

		// Click on the Continue button
	    WebElement continueButton = driver.findElement(By.xpath("//input[@id='continue']"));
	    continueButton.click();
	    
		// Enter the password
		WebElement passwordInput = driver.findElement(By.id("ap_password"));
		passwordInput.sendKeys("Password@12789");

		// Click on the Sign In button
		WebElement loginButton = driver.findElement(By.id("signInSubmit"));
		loginButton.click();
	}

	public void searchProductTest() {
		// Search for "iphone 15 pro max"
		WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
		searchInput.sendKeys("iphone 15 pro max");

		// Click on the Search button
		WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
		searchButton.click();
	}

	public void getProductDetailsTest() {
		// Get the text and price of the first product
		WebElement productTitle = driver
				.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		String title = productTitle.getText();

		WebElement productPrice = driver.findElement(By.xpath("//span[@class='a-price-whole']"));
		String price = productPrice.getText();

		System.out.println("Product Title: " + title);
		System.out.println("Product Price: " + price);

		// Generate the report
		ExcelReportGenerator.generateReport(title, price);
	}

	public void teardown() {
		// Close the browser
		driver.quit();
	}

}
