import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * As a signed in user,
 * I would like to be able edit my profile and view previous searches
 * So I can change the settings to my liking and return to previous items
 * @author Nicholas DeFranco
 *
 */

public class CraiglistSignInUserTest {
	
	static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the main page for craigslist
	@BeforeClass
	public static void setUp() throws Exception {
		driver.get("https://pittsburgh.craigslist.org");
	    driver.findElement(By.linkText("my account")).click();
	    driver.findElement(By.id("inputEmailHandle")).clear();
	    driver.findElement(By.id("inputEmailHandle")).sendKeys("npdcs1632@gmail.com");
	    driver.findElement(By.id("inputPassword")).clear();
	    driver.findElement(By.id("inputPassword")).sendKeys("qualityassurance");
	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

	}
	
	
	
	// Given that I am on the account page
	// When I click on the "settings" tab
	// Then I should be able to change multiple elements about my profile
	@Test
	public void testSettings() {
		driver.findElement(By.linkText("settings")).click();
		try {
			driver.findElement(By.linkText("change"));
			driver.findElement(By.linkText("change password"));
			driver.findElement(By.linkText("deactivate account"));
		} catch (NoSuchElementException nseex){
			fail("Not on the correct setting's page");
		}
	}
	
	// Given that I am on the searches tab on the account page
	// When I click on "search terms: macbook, sort: relevant"
	// Then I should see the similar search results
	@Test
	public void testSaveSearch() {
		driver.findElement(By.linkText("searches")).click();
		driver.findElement(By.linkText("search terms: macbook, sort: relevant")).click();
		String search = driver.findElement(By.id("query")).getAttribute("value");
		assertEquals("macbook",search);
		driver.findElement(By.linkText("account")).click();
	}
	
	// Given that I am on the settings tab
	// When I click on "change password" and enter "qualityassurance" as the old password and 2 passwords that do not match
	// Then I should have not changed the password
	@Test
	public void testChangePassword() {
	    driver.findElement(By.linkText("settings")).click();
	    driver.findElement(By.linkText("change password")).click();
	    driver.findElement(By.id("p0")).clear();
	    driver.findElement(By.id("p0")).sendKeys("qualityassurance");
	    driver.findElement(By.id("p1")).clear();
	    driver.findElement(By.id("p1")).sendKeys("familyguy");
	    driver.findElement(By.id("p2")).clear();
	    driver.findElement(By.id("p2")).sendKeys("bobsburgers");
	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	    String error = driver.findElement(By.cssSelector("html body p.error")).getText();
	    assertTrue(error.contains("Passwords you entered did not match"));
	    driver.navigate().back();
	    driver.navigate().back();
	}
	
	// Given that I am on the change email page
	// When I enter an invalid email
	// Then it should not change the email
	@Test
	public void testInvalidEmail() {
		driver.findElement(By.linkText("settings")).click();
		driver.findElement(By.linkText("change")).click();
	    driver.findElement(By.name("inputNewEmail")).clear();
	    driver.findElement(By.name("inputNewEmail")).sendKeys("cs1632rules");
	    driver.findElement(By.name("inputNewEmailRetype")).clear();
	    driver.findElement(By.name("inputNewEmailRetype")).sendKeys("cs1632rules");
	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	    String error = driver.findElement(By.cssSelector("html body p.error")).getText();
	    assertTrue(error.contains("The email address you entered (cs1632rules) doesn't look right"));
	    driver.navigate().back();
	    driver.navigate().back();
	}
	
	// Given that I am on the account page
	// When I click on "log out"
	// Then I should be able to sign in
	@Test
	public void testLogout() {
		driver.findElement(By.linkText("log out")).click();
		String text = driver.findElement(By.cssSelector("h4.ban")).getText();
		assertTrue(text.contains("Log in"));
		
	    driver.findElement(By.id("inputEmailHandle")).clear();
	    driver.findElement(By.id("inputEmailHandle")).sendKeys("npdcs1632@gmail.com");
	    driver.findElement(By.id("inputPassword")).clear();
	    driver.findElement(By.id("inputPassword")).sendKeys("qualityassurance");
	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	}
	
	@After
	public void cleanUp(){
		driver.findElement(By.linkText("home of npdcs1632@gmail.com")).click();
	}
	


}
