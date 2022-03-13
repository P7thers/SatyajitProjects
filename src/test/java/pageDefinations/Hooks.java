package pageDefinations;

import java.io.IOException;

import io.cucumber.java.After;
import utils.TextContextSetup;

public class Hooks 
{
	public TextContextSetup testcontextsetup;
	
	
	public Hooks(TextContextSetup testcontextsetup) 
	{
		this.testcontextsetup=testcontextsetup;
	}
	
	
	@After
	public void AfterScenario() throws IOException 
	{
		testcontextsetup.testbase.WebDriverManager().quit();
	}

}
