package scripts;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utilities.Waiters;

public class _04_GoogleTest extends Base{

    /* TC765: Validate Google search
    1. Go to "https://www.google.com/"
    2. Search for "Selenium"
    3. Validate the results are more than zero
        (2) Page Object Repository:
            GoogleSearchPage
            GoogleSearchResultPage
   */
    @Test (description = "TC765: Validate Google search") // this will help link the test case # to the test scripts to locate both easier
    public void testGoogleSearch(){
        driver.get("https://www.google.com/");
        googleSearchPage.searchInputBox.sendKeys("Selenium", Keys.ENTER);

        String results = googleSearchResultPage.searchResults.getText(); // About 173,000,000 results (0.47 seconds)
        Assert.assertTrue(Integer.parseInt(results.substring(results.indexOf(" ")+1, results.indexOf("result")-1).replace(",", "")) > 0);
    }


    /* TEST CASE:
    1. Go to https://www.google.com/
    2. Click on "Store" link
    3. Validate the title of the page is "Google Store for Google Made Devices & Accessories"
    */
    @Test (priority = 2, description = "TC123: Validate Google Store link")
    public void testGoogleStoreLink(){
        driver.get("https://www.google.com/");

        //explicitWait.until(ExpectedConditions.visibilityOf(googleSearchPage.storeLink)); // 120 attempts
        Waiters.waitForVisibilityOfElement(driver, googleSearchPage.storeLink, 30);
        googleSearchPage.storeLink.click();//

        // THIS CAN THROW AN EXCEPTION IN SOME CASES AND TO HANDLE THIS USE EXPLICIT WAIT
        //explicitWait.until(ExpectedConditions.titleIs("Google Store for Google Made Devices & Accessories"));
        Waiters.waitUntilTitleIs(driver, 30, "Google Store for Google Made Devices & Accessories");
        Assert.assertEquals(driver.getTitle(), "Google Store for Google Made Devices & Accessories");
    }



}
