package rohittest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class NewFlightTest {
	protected static WebDriver driver;
	
	 @DataProvider(name = "FlightTestData")
  	public Object[][] dataForFlight(){
        	return new Object[][]{
              	{"Paris","Rome"}
        	};
  	}
	 
	
	@BeforeTest
    public void beforeMethod() {
		//final WebDriverWait ShortWait;
		//final WebDriverWait LongWait;
		WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    	String url = "https://www.blazedemo.com";
    	driver.get(url);
    	driver.manage().window().maximize();

    }

	@AfterTest
    public void afterMethod() {
        driver.quit();
    }

   @Test(dataProvider="FlightTestData")
    public void searchFlight(String keyWord1, String keyWord2){
    	//String keyWord1 = "Paris";
    	//String keyWord2 = "Rome";
    	
    	if (LibraryFunctions.SelectValueInDropDown(RepositoryXpaths.CitiesSelectionPage.CityFromDropdown, keyWord1) == false) Assert.fail();;
    	if (LibraryFunctions.SelectValueInDropDown(RepositoryXpaths.CitiesSelectionPage.CityToDropdown, keyWord2) == false) Assert.fail();;
    	if (LibraryFunctions.ClickButton(RepositoryXpaths.CitiesSelectionPage.SearchFlightsButton, "See available flights button") == false) Assert.fail();;
    	if (LibraryFunctions.ClickButton(RepositoryXpaths.FlightSelectionPage.FlightButton, "Choose Flight button") == false) Assert.fail();;
    	if (LibraryFunctions.ClickButton(RepositoryXpaths.DetailsPage.PurchaseButton, "PurchaseButton") == false) Assert.fail();;
    	try{
    	WebElement ConfirmationMessaage = new WebDriverWait(driver, 6).until(ExpectedConditions.elementToBeClickable(By.xpath(RepositoryXpaths.ConfirmationPage.ConfirmationMessage)));
    	}
    	catch(NoSuchElementException e){
    		Reporter.log("Flight is not booked successfully.");
    		Assert.fail();
    	}
    	
    	Reporter.log("Flight is booked successfully.");
	}
  
}