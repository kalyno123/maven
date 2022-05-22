package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    /* TEST CASE 3:
    1. Go to https://www.etsy.com/
    2. Search for "canvas painting"
    3. Validate the results are more than zero
    */

    @Test(priority = 3)
    public void testEtsySearchResult(){
        driver.get("https://www.etsy.com/"); // NAVIGATES TO THE URL
        WebElement searchInputBox = driver.findElement(By.id("global-enhancements-search-query")); // USED ID LOCATOR BC IT'S FASTEST, RELIABLE, AND UNIQUE
        searchInputBox.sendKeys("canvas painting", Keys.ENTER);
        WebElement searchResult = driver.findElement(By.cssSelector(".wt-display-inline-flex-sm>span")); // USED CSS SELECTOR LOCATOR BC IT'S 2ND FAST
        Assert.assertTrue(Integer.parseInt(searchResult.getText().replaceAll("[^\\d]", "")) > 0);
        // Assert.assertTrue(Integer.parseInt(resultTag.getText().substring(0, resultTag.getText().indexOf(" ")).replace(",", "")) > 0);
    }






}
