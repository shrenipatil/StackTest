package POM_StackTest.POM_StackTest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import qa.util.*;
/**
 * @file TestBase.java
 * @author Shreni patil.
 * @brief This is a brief description of the Test Base class
 *
 * @details This is a detailed description of the web event listener ,
 * page time out , browser specification
 * It can span multiple lines.
 */
public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	Logger log = Logger.getLogger(TestBase.class);
	
	public TestBase()
	{
		try
		{
			prop=new Properties();
			FileInputStream ip=new FileInputStream("./src/main/java/qa/config/config.properties");
			prop.load(ip);
			log.info("**** Load Properties File Successfully ****");
			
		}catch(FileNotFoundException fe)
		{
			fe.printStackTrace();
			log.error("***** File is not find *****");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("***** Error While Loading Properties File *****");
		}
	}
	public void initialization()
	{
		String browserName=prop.getProperty("browse");
		if(browserName.equals("FF"))
		{
			FirefoxOptions options= new FirefoxOptions();
			options.setHeadless(true);
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver(options);
			log.info("**** Application Run With Firefox Browser ****");
		}
		else if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			log.info("**** Application Run With Chrome Browser ****");
		}
		
		e_driver=new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		log.info("**** entering application URL ****");
	}
}
