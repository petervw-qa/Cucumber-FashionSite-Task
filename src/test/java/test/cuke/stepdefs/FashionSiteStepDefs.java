package test.cuke.stepdefs;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FashionSiteStepDefs {

	private static RemoteWebDriver driver;
	private WebElement targ;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver(chromeCfg());
		driver.manage().window().setSize(new Dimension(1366, 768));

	}

	@Given("^that I can access the fashionsite$")
	public void that_I_can_access_the_fashionsite() throws Throwable {
		driver.get("http://automationpractice.com/index.php");
	}

	@When("^I navigate to the search bar$")
	public void i_navigate_to_the_search_bar() throws Throwable {
		targ = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
	}

	@When("^I search for the word dress$")
	public void i_search_for_the_word_dress() throws Throwable {
		targ.sendKeys("Dress");
		targ = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button"));
		targ.click();
	}

	@Then("^I should find some results for dress$")
	public void i_should_find_some_results_for_dress() throws Throwable {
		assertEquals("7 results have been found.",
				driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[2]")).getText());
	}

	@After
	public void tearDown() {
		driver.close();
	}

	public static ChromeOptions chromeCfg() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		ChromeOptions cOptions = new ChromeOptions();

		// Settings
		prefs.put("profile.default_content_setting_values.cookies", 2);
		prefs.put("network.cookie.cookieBehavior", 2);
		prefs.put("profile.block_third_party_cookies", true);

		// Create ChromeOptions to disable Cookies pop-up
		cOptions.setExperimentalOption("prefs", prefs);

		return cOptions;

	}
}
