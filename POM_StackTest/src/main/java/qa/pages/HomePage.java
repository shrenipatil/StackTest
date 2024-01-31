package qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import POM_StackTest.POM_StackTest.*;
/**
 * @file HomePage.java
 * @author Shreni patil.
 * @brief This is a brief description of the HomePage class
 *
 * @details This is a detailed description of thevalidateLoginPageTilte method ,
 * clickHamburgerIcon method It can span multiple lines
 */
public class HomePage extends TestBase
{
	
	Logger log = Logger.getLogger(HomePage.class);
	
	@FindBy(xpath ="//a[@class='s-topbar--menu-btn js-left-sidebar-toggle']")
	WebElement hambargeIcon;
	
	@FindBy(xpath ="//*[@id='nav-users']")
	WebElement userOption;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	/**
	 * @return website url
	 */
	public String validateLoginPageTilte()
	{
		String URL = null;
		try
		{
		URL=driver.getCurrentUrl();
		}
		catch(ElementNotVisibleException e)
		{
			log.error("*** Element is Not Visible ***", e);
		}
		return URL;
		
}

	/**
	 * @return User Page
	 */
	public UserPage clickHamburgerIcon()
	{
		try
		{
		hambargeIcon.click();
		userOption.click();
		}
		catch(ElementNotVisibleException e)
		{
			log.error("*** user option is not selected ***",e);
		}
	return new UserPage();
	}
}