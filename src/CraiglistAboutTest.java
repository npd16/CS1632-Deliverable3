import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * As a troubled user,
 * I would like to see what can be done to fix my satisfaction 
 * So I will be happy with the service of the site. 
 * @author Nicholas DeFranco
 *
 */

public class CraiglistAboutTest {

	static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the main page for craigslist
	@Before
	public void setUp() throws Exception {
		driver.get("https://pittsburgh.craigslist.org/about");
	}
	
	// Given that I am on the about page
	// When I click on "Jobs FAQ", then "How do I post a job?"
	// Then I should see information on how to post to a job
	@Test
	public void testPostAJob() {
	    try {
			driver.findElement(By.linkText("Jobs FAQ")).click();
			driver.findElement(By.linkText("How do I post a job?")).click();
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	// Given that I am on the about page
	// When I click on  "Avoiding Scams & Fraud"
	// Then I should see information on what I can do to do about spamming
	@Test
	public void testScamInfo() {
	    try {
	    	driver.findElement(By.linkText("Avoiding Scams & Fraud")).click();    
	    	String title = driver.getTitle();
	    	assertTrue(title.contains("scam"));
	    } catch (Exception e) {
			fail();
		}
	}
	
	// Given that I am on the about page
	// When I click on "CL Help Pages" and search "delete" 
	// Then I should see information on what I can do to do about deleting something
	@Test
	public void testSearchDelete(){
		try{
		    driver.findElement(By.linkText("CL Help Pages")).click();
		    driver.findElement(By.name("q")).clear();
		    driver.findElement(By.name("q")).sendKeys("delete");
		    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

		} catch (Exception e){
			fail();
		}
	}
	
	// Given that I am on the about page
	// When I click on  "Avoiding Scams & Fraud"
	// Then I should see information on what I can do to do about spamming
	@Test
	public void testCEOInfo() {
	    try {
	    	driver.findElement(By.linkText("Jim")).click();
	    	String title = driver.getTitle();
	    	assertTrue(title.contains("jim"));
	    } catch (Exception e) {
			fail();
		}
	}
	
	// Given that I am on the about page
	// When I click on  "craigslist" in the header
	// Then I should see the main page of craigslist
	@Test
	public void testGoingBack() {
	    try {
	    	driver.findElement(By.linkText("craigslist")).click();
	    	String title = driver.getTitle();
	    	assertTrue(!title.contains("about"));
	    } catch (Exception e) {
			fail();
		}
	}
	
	
}
