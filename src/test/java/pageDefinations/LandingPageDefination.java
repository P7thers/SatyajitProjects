package pageDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TextContextSetup;

public class LandingPageDefination 
{
	public WebDriver driver;
	public String LandingpageProductName;
	TextContextSetup testcontextsetup;
	
	public LandingPageDefination(TextContextSetup testcontextsetup) 
	{
		this.testcontextsetup=testcontextsetup;
	}
	
	@Given("User is on GreenCart Landing Page")
    public void user_is_on_greencart_landing_page() throws Throwable 
    {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Satyajit\\Downloads\\Chromedriver\\chromedriver.exe");
		//testcontextsetup.driver = new ChromeDriver();
		//testcontextsetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

	@When("^User searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_something_and_extracted_actual_name_of_product(String shortName) throws InterruptedException 
	{
		System.out.println(shortName);
		//LandingPage landingpage= new LandingPage(testcontextsetup.driver);
		LandingPage landingpage= testcontextsetup.pageObjectmanager.getLandingPage();
		landingpage.SearchItem(shortName);
		//testcontextsetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(3000);
		// testcontextsetup.LandingpageProductName=testcontextsetup.driver.findElement(By.cssSelector("h4[class='product-name']")).getText().split("-")[0].trim();
		testcontextsetup.LandingpageProductName=landingpage.getProductName().split("-")[0].trim();
		System.out.println("Got the Test from browser is :"+testcontextsetup.LandingpageProductName);

	}

}
