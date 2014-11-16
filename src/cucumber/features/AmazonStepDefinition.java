/*
 <author>Dilip Shrikhande</author>
 <email>dilip_gem@yahoo.com</email>
 <date>08-Nov-2014</date>
<summary>Contains a step definition class for 'amazonsearch' feature file</summary>

<Description>  This class extends the base abstract class, navigates to the amazon url, searches for phones and  validates 
price of first 5 phones.
	Elements on the site are identified based on attributes such as id,name, css, & absolute x-paths.
</Description>

 */

package cucumber.features;

import static org.testng.AssertJUnit.assertEquals;

import java.util.List;

import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonStepDefinition extends AbstractBaseClass {

	public String price1, price2, price3, price4, price5;

	WebDriver driver = getDriver();

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Before
	public void setUp() throws Throwable {
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Throwable {
		driver.quit();
	}

	@Given("^I am on Amazon site$")
	public void navigateToAmazonSite() throws Throwable {

		driver.get("http://amazon.co.uk");

	}

	@When("^I search for an ([^\"]*)$")
	public void searchForPhone(String Phone) throws Throwable {
		driver.findElement(By.name("field-keywords")).sendKeys(Phone);
		driver.findElement(By.cssSelector("input.nav-submit-input")).click();
	}

	@Then("^I should see the results showing phones at correct prices$")
	public void validateTheResults(DataTable table) throws Throwable {

		List<List<String>> data = table.raw();

		price1 = driver
				.findElement(
						By.xpath("//li[@id='result_0']/div/div/div/div[2]/div[2]/div[1]/div[1]/a/span"))
				.getText();

		try {
			assertEquals("Price is incorrect", price1, data.get(1).get(1));
		} catch (Throwable t) {
			collector.addError(t);
			System.out.println("Price 1 did not match"+t);
		}

		price2 = driver
				.findElement(
						By.xpath("//li[@id='result_1']/div/div/div/div[2]/div[2]/div[1]/div[1]/a/span"))
				.getText();

		try {
			assertEquals("Price is incorrect", price2, data.get(2).get(1));
		} catch (Throwable t) {
			collector.addError(t);
			System.out.println("Price 2 did not match"+t);
		}

		price3 = driver
				.findElement(
						By.xpath("//li[@id='result_2']/div/div/div/div[2]/div[2]/div[1]/div[1]/a/span"))
				.getText();

		try {
			assertEquals("Price is incorrect", price3, data.get(3).get(1));
		} catch (Throwable t) {
			collector.addError(t);
			System.out.println("Price 3 did not match"+t);
		}

		price4 = driver
				.findElement(
						By.xpath("//li[@id='result_3']/div/div/div/div[2]/div[2]/div[1]/div[1]/a/span"))
				.getText();
		try {
			assertEquals("Price is incorrect", price4, data.get(4).get(1));
		} catch (Throwable t) {
			collector.addError(t);
			System.out.println("Price did 4 not match"+t);
		}

		price5 = driver
				.findElement(
						By.xpath("//li[@id='result_4']/div/div/div/div[2]/div[2]/div[1]/div[1]/a/span"))
				.getText();
		try {
			assertEquals("Price is incorrect", price5, data.get(5).get(1));
		} catch (Throwable t) {
			collector.addError(t);
			System.out.println("Price 5 did not match"+t);
		}

	}
}
