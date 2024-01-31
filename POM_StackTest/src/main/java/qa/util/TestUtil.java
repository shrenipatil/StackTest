package qa.util;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import POM_StackTest.POM_StackTest.*;

public class TestUtil extends TestBase{

	public static String TESTDATA_SHEET_PATH="/Users/Inside/workspace/FreeCRMTest/src/main/java/com/crm/qa/"
			+ "testdata/HRMTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	/*
	public String createXpath()
	{
		//*[@id="user-browser"]/div[1]/div[2]
	String firstX = "//*[@id='user-browser']/div[";
	  String secondX = "]/div[";
	  String thirdX = "]";
	  String completeX = null;

	  for(int i=1; i <= 7; i++) {
	      for(int j=1; j <= 4; j++) {
	           completeX = firstX + i + secondX + j + thirdX;
	          //String tableData = driver.findElement(By.xpath(completeX)).getText();
	          System.out.println(completeX + "   ");
	          return completeX;
	      }
	  }
	return completeX;
	}*/
	
	public void switchToFrame()
	{
		System.out.println("Inside the change frame util");
		driver.switchTo().frame("rightMenu");
		System.out.println("out from the change frame util");
	}
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	
}
