package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TextContextSetup 
{
	
	public WebDriver driver;
	public String OfferPageProductName;
	public String LandingpageProductName;
	public PageObjectManager pageObjectmanager;
	public TestBase testbase;
	public GenericUtils genericUtils;
	
	public TextContextSetup() throws IOException 
	{
		testbase = new TestBase();
		pageObjectmanager=new PageObjectManager(testbase.WebDriverManager());
		genericUtils =new GenericUtils(testbase.WebDriverManager());
	}

}
