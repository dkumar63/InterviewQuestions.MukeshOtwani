package webDriverQuestion;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dataprovider.ConfigReader;
import factory.BrowserFactory;

public class Question_5_CrossBrowserTesting 
{
	private static ConfigReader reader = new  ConfigReader();
	private WebDriver driver;
	@Test(groups={"Regression"})
	@Parameters("Browser")
	public void getTitle(String BrowserName)
	{
		driver = BrowserFactory.getBrowser(BrowserName);
		driver.get(reader.getURL());
		System.out.println("Title of the page : "+driver.getTitle());
	}
	
	@Test(groups={"Functional"})
	@Parameters("Browser")
	public void getCurrentURL(String BrowserName)
	{
		driver = BrowserFactory.getBrowser(BrowserName);
		driver.get(reader.getURL());
		System.out.println("Title of the page : "+driver.getCurrentUrl());
	}
	
	@Test(groups={"Regression"})
	@Parameters("Browser")
	public void getWindowName(String BrowserName)
	{
		driver = BrowserFactory.getBrowser(BrowserName);
		driver.get(reader.getURL());
		System.out.println("Title of the page : "+driver.getWindowHandle());
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}
	
}
