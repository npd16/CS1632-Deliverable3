import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
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
	@Before
	public void setUp() throws Exception {
		driver.get("https://pittsburgh.craigslist.org");
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
