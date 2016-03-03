import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.*;

/**
 * As a new user,
 * I would like basic, easy to use navigation,
 * So I can understand and use the site quickly
 * @author Nicholas DeFranco
 *
 */

public class CraigslistUserTest {

	static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the main page for craigslist
	@Before
	public void setUp() throws Exception {
		driver.get("https://pittsburgh.craigslist.org");
	}
	
	
	// Given that I am on the main page
	// When I view the title
	// Then I see that it contains the word "craigslist"
	@Test
	public void testCorrectTitle() {
		
		//Make sure to check the title to see if you are on the right page
		
		String title = driver.getTitle();
		assertTrue(title.contains("craigslist"));
	}
	
	// Given that I am on the main page
	// When I view the main body
	// Then I see that it contains "for sale", "housing", "jobs", and "services" links
	@Test
	public void testCorrectHeaderLinks() {
		// Check for for sale, housing, jobs, and services links - if any of
		// these is not found, fail the test
		
		try {
			driver.findElement(By.linkText("for sale"));
			driver.findElement(By.linkText("housing"));
			driver.findElement(By.linkText("jobs"));
			driver.findElement(By.linkText("services"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	// Given that I am on the main page
	// When I click on the "housing" link
	// Then I should be taken the housing page
	@Test
	 public void testHousingLink() throws Exception {
		driver.findElement(By.cssSelector("a.hhh > span.txt")).click();
		String newPageTitle = driver.getTitle();
		assertTrue(newPageTitle.contains("housing, apartments,"));
	  }
	
	// Given that I am on the main page
	// When I click on the "my account" link
	// Then I should be taken to the sign in or sign up page
	@Test
	public void testMyAccountPage() throws Exception {
		driver.findElement(By.cssSelector("a.hhh > span.txt")).click();
		String newPageTitle = driver.getTitle();
		assertTrue(newPageTitle.contains("housing, apartments,"));
	}
	
	// Given that I am on the main page
	// When I click on the "my account" link and sign in with the credentials npdcs1632@gmail.com and qualityassurance as the  email and password
	// Then I should be taken npdcs1632 account page
	@Test
	  public void testSignIn() throws Exception {
	    driver.findElement(By.xpath("(//a[contains(text(),'my account')])[2]")).click();
	    driver.findElement(By.id("inputEmailHandle")).clear();
	    driver.findElement(By.id("inputEmailHandle")).sendKeys("npdcs1632@gmail.com");
	    driver.findElement(By.id("inputPassword")).clear();
	    driver.findElement(By.id("inputPassword")).sendKeys("qualityassurance");
	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	    try {
	    	driver.findElement(By.linkText("home of npdcs1632@gmail.com"));
	    } catch(Exception e){
	    	fail();
	    }
	  }

}
