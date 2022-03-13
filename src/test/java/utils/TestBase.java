package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase 
{
	public WebDriver driver;
	
	
	
	public WebDriver WebDriverManager() throws IOException 
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties  prop = new Properties();
		prop.load(fis);
		String url=prop.getProperty("QAUrl");
		
		if(driver==null)
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Satyajit\\Downloads\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.get(url);

		}
		return driver;
	} 

}
