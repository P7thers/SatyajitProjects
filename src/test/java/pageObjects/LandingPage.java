package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage
{ 
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
 	
	By search=By.xpath("//input[@type='search']");
	By productName=By.cssSelector("h4[class='product-name']");
	By TopDeal=By.linkText("Top Deals");
	
	public void SearchItem(String Name) 
	{
		driver.findElement(search).sendKeys(Name);
	}

	public void getSearchText() 
	{
		driver.findElement(search).getText();
	}
	
	public String getProductName() 
	{
		return driver.findElement(productName).getText();
	}
	
	public void selectTopDeals() 
	{
		driver.findElement(TopDeal).click();
	}
}
