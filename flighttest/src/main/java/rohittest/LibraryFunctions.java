package rohittest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LibraryFunctions extends NewFlightTest{
	
		public static boolean SelectValueInDropDown(String XpathName,String value){
		try{
			Select drp = new Select(new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.name(XpathName))));
				drp.selectByVisibleText(value);
			Reporter.log("Selected " + value + " in " + XpathName + " dropdown");
			return true;
		}
		catch(Exception e){
			Reporter.log("Error occured: " + e.getMessage());
			return false;
		}
	}

	public static boolean FillValueInEditBox(String XpathName,String value){
		try{
			WebElement drp = new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.name(XpathName)));
			drp.clear();	
			drp.sendKeys(value);
			Reporter.log("Filled" + value + " in " + XpathName + " editbox");
			return true;
		}
		catch(Exception e){
			Reporter.log("Error occured: " + e.getMessage());
			return false;
		}
	}

	public static boolean ClickButton(String XpathName,String ButtonName){
		try{
			WebElement drp = new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(XpathName)));
				drp.click();
			Reporter.log("Clicked on " + ButtonName + " button");
			return true;
		}
		catch(Exception e){
			Reporter.log("Error occured: " + e.getMessage());
			return false;
		}
	}

}
