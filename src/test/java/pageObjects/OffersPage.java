package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage 
{
	public WebDriver driver;
	
	public OffersPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	By search=By.xpath("//input[@type='search']");
	By productName=By.cssSelector("tr td:nth-child(1)");
	
	
	
	
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
	

}
