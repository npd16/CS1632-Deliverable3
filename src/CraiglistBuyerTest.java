import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
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
	private String baseUrl;
	
	// Start at the main page for craigslist
	@Before
	public void setUp() throws Exception {
		driver.get("https://pittsburgh.craigslist.org");
		baseUrl = "https://pittsburgh.craigslist.org/";
	}
	
	// Given that I am on the main page
	// When I click on "for sale" and search "iphone"
	// Then I should see multiple iPhones that are available to buy
	@Test
	public void testiPhoneSearch() {
		driver.findElement(By.cssSelector("a.sss > span.txt")).click();
	    driver.findElement(By.id("query")).clear();
	    driver.findElement(By.id("query")).sendKeys("iphone");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    String title = driver.getTitle();
	    assertTrue(title.contains("iphone"));
	}
	
	// Given that I am on the for sale
	// When I click on the owner tab
	// Then I should see results being sold by an owner
	@Test
	public void testSaleOwner() {
		driver.get(baseUrl + "/search/sss");
		String startTitle = driver.getTitle();
	    driver.findElement(By.linkText("owner")).click();
	    String title = driver.getTitle();
	    assertNotEquals(startTitle,title);
	}
	
	// Given that I am on the for sale
	// When I click on the dealer tab
	// Then I should see results being sold by a dealer
	@Test
	public void testSaleDealer() {
		driver.get(baseUrl + "/search/sss");
		String startTitle = driver.getTitle();
	    driver.findElement(By.linkText("dealer")).click();
	    String title = driver.getTitle();
	    assertNotEquals(startTitle,title);
	}

	// Given that I am on the main page
	// When I click on "books"
	// Then I should see multiples results that are books and magazines
	@Test
	public void testBooksSale() {
		driver.findElement(By.cssSelector("a.bka > span.txt")).click();
		String title = driver.getTitle();
		assertTrue(title.contains("books"));
	}
	
	// Given that I am on the main page
	// When I click on "video games"
	// Then I should see multiples results that are video games and consoles
	@Test
	public void testVideoGameSale() {
		try{	
			driver.findElement(By.cssSelector("a.vga > span.txt")).click();
			driver.findElement(By.linkText("video gaming"));
		} catch (Exception e) {
			fail();
		}
	}	
	
}
