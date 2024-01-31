package POM_StackTest.POM_StackTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.pages.*;
import POM_StackTest.POM_StackTest.*;
/**
 * @file HomePageTest.java
 * @author Shreni patil.
 * @brief This is a brief description of the HomePageTest class
 *
 * @details This is a description of homePageTilteTest ,seleteUsersInMenuTest Tests
 */

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	UserPage userPage;

Logger log = Logger.getLogger(HomePageTest.class);
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		log.info("*********************** SETUP - Starting test cases execution ***************************");
		initialization();
		homePage = new HomePage();
		
	}
	@Test
	public void home_Page_Tilte_Test()
	{
		log.info("*************************** START - login Page Tilte Test ******************************");
		String title=homePage.validateLoginPageTilte();
		Assert.assertEquals(title, "https://stackoverflow.com/");
		log.info("**************************** END - login Page Tilte Test ********************************");
	}
	
	@Test
	public void selete_Users_In_Menu_Test()
	{
		log.info("*************************** START - select users section in side menu bar Test ******************************");
		userPage = homePage.clickHamburgerIcon();
		
		log.info("**************************** END - select users section in side menu bar  Test ********************************");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("****************************** TearDown - Browser is closed *****************************************");
	}
}
