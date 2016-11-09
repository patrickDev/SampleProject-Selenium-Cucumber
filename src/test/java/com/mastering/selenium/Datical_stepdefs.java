package com.mastering.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Datical_stepdefs {
	
	public WebDriver driver;
	final String URL = "http://www.datical.com/";
	
	@Before
	public void startDriver() {
		driver = new FirefoxDriver();
	}
	
	
	@Given("^I open datical website$")
	public void i_open_datical_website() throws Throwable {
		driver.get(URL);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Given("^I navigate to PRODUCT link$")
	public void i_navigate_to_PRODUCT_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("nav-menu-item-5352")).click();	   
	}

	@Then("^I print the html$")
	public void i_print_the_html() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.print(driver.getTitle());
	}
	
	public  void quitDriver(Scenario scenario) {
		if(scenario.isFailed()) {
	        try {
	        	 scenario.write("Current Page URL is " + driver.getCurrentUrl());
	            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	            scenario.embed(screenshot, "image/png");
	        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
	            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
	        }
	        
	        }
	        driver.quit();
	}

}
