package pageDefinations;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TextContextSetup;

public class OfferPageDefination 
{
	//public WebDriver driver;
    public String OfferPageProductName;
	public String LandingpageProductName;
	TextContextSetup testcontextsetup;
	PageObjectManager pageobjectmanager;
	
	//Single responsibility Principle
	//loosly coupled
	//Factory Design Patten
	
	public OfferPageDefination(TextContextSetup testcontextsetup) 
	{
		this.testcontextsetup=testcontextsetup;
	}
	
	@Then("^User searched for (.+) shortname in offers page$")
	public void user_searched_for_something_shortname_in_offers_page(String shortName) throws Throwable 
	{
	    //Offer Page->Enter>grab text	
		
		SwitchToOfferPage() ;
		//testcontextsetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		//OffersPage offerspage= new OffersPage(testcontextsetup.driver);
		OffersPage offerspage=testcontextsetup.pageObjectmanager.OffersPage();
		offerspage.SearchItem(shortName);
		Thread.sleep(3000);
		
		//testcontextsetup.OfferPageProductName =testcontextsetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		testcontextsetup.OfferPageProductName=offerspage.getProductName();
		System.out.println(OfferPageProductName);	  
	}
	

	public void SwitchToOfferPage() 
	{
		//testcontextsetup.driver.findElement(By.linkText("Top Deals")).click();			

		// pageobjectmanager = new PageObjectManager(testcontextsetup.driver);
		LandingPage landingpage = testcontextsetup.pageObjectmanager.getLandingPage();
		landingpage.selectTopDeals();
		//LandingPage landingpage = new LandingPage(testcontextsetup.driver);
		//landingpage.selectTopDeals();
		testcontextsetup.genericUtils.SwitchWindowToChild();
		
	}

	    @And("^Validate product name in offers page matches with Landing Page$")
	    public void validate_product_name_in_offers_page_matches_with_landing_page() throws Throwable 
	    {
	    	Assert.assertEquals(OfferPageProductName, LandingpageProductName);
	    }

}
