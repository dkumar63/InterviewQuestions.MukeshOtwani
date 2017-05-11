package factory;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataprovider.ConfigReader;

public class BrowserFactory 
{
	private static Map<String, WebDriver> drivers = new HashMap<String,WebDriver>();
	private static ConfigReader config = new ConfigReader();
	public static WebDriver getBrowser(String browserName) {
		WebDriver driver = null;
	switch(browserName)
	{
	case "Firefox":
		driver = drivers.get("Firefox");
		if (driver == null) {
			System.setProperty("webdriver.gecko.driver",config.getFirefoxDriverPath());
			
			driver = new FirefoxDriver();
			drivers.put("Firefox", driver);
		}
		break;
	case "IE":
		driver = drivers.get("IE");
		if (driver == null) {
			System.setProperty("webdriver.ie.driver", config.getIEDriverPath());
			driver = new InternetExplorerDriver();
			drivers.put("IE", driver);
		}
		break;
	case "Chrome":
		driver = drivers.get("Chrome");
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", config.getChromeDriverPath());
			driver = new ChromeDriver();
			drivers.put("Chrome", driver);
		}
		break;
	}
	

	/*WebDriver driver;
	ConfigReader configR = new ConfigReader();
	public WebDriver setBrowserPath(String browsername)
	{
		
		if(browsername.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",configR.getChromeDriverPath());
			driver = new ChromeDriver();
			driver.get(configR.getURL());
		}
		
		else if(browsername.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver",configR.getIEDriverPath());
			driver = new InternetExplorerDriver();
			driver.get(configR.getURL());
		}
		
		else if(browsername.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver",configR.getFirefoxDriverPath());
			driver = new FirefoxDriver();
			driver.get(configR.getURL());
		}  */
		
		return driver;
	}
	
	public String setURL()
	{
		return config.getURL();
	}
}
