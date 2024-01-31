package POM_StackTest.POM_StackTest;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.pages.HomePage;
import qa.pages.UserPage;
/**
 * @file UserPageTest.java
 * @author Shreni patil.
 * @brief This is a brief description of the UserPageTest class
 *
 * @details This is a description of selectEditorsTest ,getUserInfoTest Tests
 */

public class UserPageTest extends TestBase {
	
HomePage homePage;
UserPage userPage;
UserPage userPage1;

Logger log = Logger.getLogger(UserPageTest.class);
	
	public UserPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		log.info("*********************** SETUP - Starting test cases execution ***************************");
		initialization();
		homePage = new HomePage();
		userPage = homePage.clickHamburgerIcon();
		userPage1 = userPage.clickOnEditor();
	}
		
	@Test
	public void select_Editors_Test()
	{
		log.info("*************************** START - select editors section in users page test ******************************");
		 userPage.clickOnEditor();
		log.info("**************************** END - select editors section in users page test ********************************");
	}
	@Test
	public void get_User_Info_Test()
	{
		log.info("*************************** START - get user info having max number of editor count test******************************");
		 userPage1.getUserInfo();
		log.info("**************************** END - get user info having max number of editor count test********************************");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("****************************** TearDown - Browser is closed *****************************************");
	}
}
