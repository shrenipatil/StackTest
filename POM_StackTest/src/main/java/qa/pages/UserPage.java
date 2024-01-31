package qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import POM_StackTest.POM_StackTest.TestBase;
/**
 * @file UserPage.java
 * @author Shreni patil.
 * @brief This is a brief description of the userPage class
 *
 * @details This is a detailed description of clickOnEditor method ,
 * getUserInfo method It can span multiple lines.
 */
public class UserPage extends TestBase
{
	
	Logger log = Logger.getLogger(UserPage.class);
	
	//@FindBy(xpath ="//*[contains(text(),'Editors')]")
	
	@FindBy(xpath ="// *[@title ='Users who edited at least 5 posts']")
	WebElement selectEditor;
	
	@FindBy(xpath ="//*[@rel ='next']")
	WebElement nextPage;
	
	@FindBy(xpath ="//*[@id='user-browser']/div[1]/div[1]/div[2]")
	WebElement userInfo;
	
	@FindBy(xpath ="//*[@id='user-browser']/div[1]/div[1]")
	List<WebElement> singleUserInfo;
	
	@FindBy(xpath ="//*[@id='user-browser']/div[1]")
	List<WebElement> allUserInfo;
	
	@FindBy(xpath ="//*[@id='user-browser']/div[1]/div[1]/div[2]/span")
	WebElement userLocation;
	
	public UserPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public UserPage clickOnEditor()
	{
		try
		{	
		selectEditor.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		
		nextPage.click();

		}
		catch(ElementNotVisibleException e)
		{
			log.error("*** editor option is not selected ***",e);
		}
		return new UserPage();
	}
	
	public void getUserInfo()
	{
		try
		{
			List<WebElement> singleuser = singleUserInfo;
			ArrayList<String> allUserText=new ArrayList<String>();
			for(int j=0; j<singleuser.size();j++)
			{
				   allUserText.add(singleuser.get(j).getText());
				  
				 //  String UserData = allUserText.get(allUserText.size()- 1);
				   System.out.println("User Information \n"+allUserText);
			}
			
        }
		catch(ElementNotVisibleException e)
		{
			log.error("*** editor option is not selected ***",e);
		}
		
	}
}
