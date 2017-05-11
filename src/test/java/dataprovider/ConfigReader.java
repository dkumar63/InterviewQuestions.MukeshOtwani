package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	Properties pro;
	public ConfigReader()
	{
		try {
			File src = new File(".\\Configuration\\Config.properties");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getChromeDriverPath()
	{
		return pro.getProperty("ChromeDriverPath");
	}
	
	public String getIEDriverPath()
	{
		return pro.getProperty("IEDriverPath");
	}
	
	public String getFirefoxDriverPath()
	{
		return pro.getProperty("FireFoxDriverPath");
	}
	
	public String getURL()
	{
		return pro.getProperty("URL");
	}
}
