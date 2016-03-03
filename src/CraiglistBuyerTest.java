import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * As a buyer,
 * I would like to be able to search through different products,
 * So I can find the items I am looking for
 * @author Nicholas DeFranco
 *
 */

public class CraiglistBuyerTest {
	
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
