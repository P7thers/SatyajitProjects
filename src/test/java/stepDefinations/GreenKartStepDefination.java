package stepDefinations;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreenKartStepDefination
{
	public WebDriver driver;
	public String LandingpageProductName;
	public String OfferPageProductName;
	
	@Given("User is on GreenCart Landing Page")
    public void user_is_on_greencart_landing_page() throws Throwable 
    {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Satyajit\\Downloads\\Chromedriver\\chromedriver.exe");
    	 driver = new ChromeDriver();
         driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("User searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_something_and_extracted_actual_name_of_product(String shortName) throws InterruptedException 
    {
    	  System.out.println(shortName);
    	  
    	  driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
    	  Thread.sleep(3000);
    	  LandingpageProductName=driver.findElement(By.cssSelector("h4[class='product-name']")).getText().split("-")[0].trim();
    	  System.out.println("Got the Test from browser is :"+LandingpageProductName);
        
    }

    @Then("User searched for {string} shortname in offers page")
    public void user_searched_for_something_shortname_in_offers_page(String shortName) throws Throwable 
    {
    	driver.findElement(By.linkText("Top Deals")).click();
	       
	       Set<String> s1=driver.getWindowHandles();
	       Iterator<String>i1=s1.iterator();
	       String ParentWindow=i1.next();
	       String ChildWindow= i1.next();
	    		   
	       driver.switchTo().window(ChildWindow);
	       driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	       Thread.sleep(3000);
	       OfferPageProductName =driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	       
	       System.out.println(OfferPageProductName);	  
    }

    @And("^Validate product name in offers page matches with Landing Page$")
    public void validate_product_name_in_offers_page_matches_with_landing_page() throws Throwable 
    {
    	Assert.assertEquals(OfferPageProductName, LandingpageProductName);
    }

}
