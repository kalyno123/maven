package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

// OPTIMIZE IMPORTS TO GET RID OF ANY REDUNDANT IMPORTS

public class _03_EtsyTest extends Base{

    // ** THIS CLASS IN BEING EXTENDED FROM BASE-CLASS WHICH MEANS IT INHERITED BASE'S METHODS I.E. SETUP(); AND TEARDOWN(); (don't need to coded those methods again) **

    /* TEST CASE 1:
    1. Go to https://www.etsy.com/
    2. Validate Etsy logo is displayed
    METHOD NAME = testEtsyLogo();
    */

    // WebDriver driver; // DECLARE GLOBAL VARIABLE TO BE REUSED AS A LOCAL VARIABLE IN THE BELOW METHODS

    /*
    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver(); // SETTING UP DRIVER OBJECT (OPENING BROWSER)
    }
    */

    @Test
    public void testEtsyLogo(){
        driver.get("https://www.etsy.com/"); // NAVIGATES TO THE URL
        WebElement etsyLogo = driver.findElement(By.id("logo")); // USED ID LOCATOR BC IT'S FASTEST, RELIABLE, AND UNIQUE
        Assert.assertTrue(etsyLogo.isDisplayed()); // assertTrue(); RETURNS A BOOLEAN
    }

    /*
    @AfterMethod
    public void teardown(){
        Driver.quitDriver(); // THIS METHOD IN OUR UTIL. CLASS TEARDOWN THE DRIVER COMPLETELY INCLUDING DELETING ANY STORED DATA(COOKIES)
    }
    */


    /* TEST CASE 2:
    1. Go to https://www.etsy.com/
    2. Validate Etsy search input box and search button is displayed
    METHOD NAME = testEtsySearch();
    */

    @Test
    public void testEtsySearch(){
        driver.get("https://www.etsy.com/"); // NAVIGATES TO THE URL
        WebElement searchInputBox = driver.findElement(By.id("global-enhancements-search-query")); // USED ID LOCATOR BC IT'S FASTEST, RELIABLE, AND UNIQUE
        WebElement searchButton = driver.findElement(By.cssSelector("button[data-id='gnav-search-submit-button']")); // USED CSS SELECTOR LOCATOR BC IT'S 2ND FAST
        Assert.assertTrue(searchInputBox.isDisplayed()); // assertTrue(); RETURNS A BOOLEAN
        Assert.assertTrue(searchButton.isDisplayed()); // IT IS BEST TO ASSERT ONE AT A TIME TO EASILY DETECT WHICH ELEMENT FAILED IN THE REPORT
    }






}
