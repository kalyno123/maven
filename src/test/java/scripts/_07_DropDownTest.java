package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DropDownHandler;
import utilities.Waiters;

public class _07_DropDownTest extends Base{

    /* TEST CASE:
    Go to https://www.facebook.com/
    Click on "Create New Account" link
    Enter below information and click on Sign Up button
    First name = John
    Last Name = Doe
    Email address = johndoe55555@gmail.com
    Password = abcd1234
    Birthday = April 1, 1990
    Gender = Male
    Validate below error message is displayed with expected text:
    "Please choose a more secure password. It should be longer than 6 characters, unique to you, and difficult for others to guess."
    */

    @Test(priority = 1, description = "TC763: Validate Facebook sign in error message for password")
    public void testUnsecurePassword() {

        driver.get("https://www.facebook.com/"); // Go to https://www.facebook.com/

        faceBookPage.createNewAccountLink.click(); // Click on "Create New Account" link

        // Enter below information
        faceBookPage.firstNameInputBox.sendKeys("John");
        faceBookPage.lastNameInputBox.sendKeys("Doe");
        faceBookPage.emailOrPhnInputBox.sendKeys("johndoe55555@gmail.com");
        faceBookPage.reenterEmailOrPhnInputBox.sendKeys("johndoe55555@gmail.com");
        faceBookPage.passwordInputBox.sendKeys("abcd1234");

        //To be able to select an option from dropdown we need an instance of Select class
        //Select monthSelector = new Select(faceBookPage.monthDropDown); // NOTE: parameter passed in () can ONLY be <select>tag or <option>tag web elements
        //Select month as April
        //monthSelector.selectByValue("4"); // selection by value
        //monthSelector.selectByVisibleText("Apr"); // selection by visible text
        //monthSelector.selectByIndex(3); // selection by index - index starts from zero
        //Select day as 1
        //monthSelector.deselectByVisibleText("1");
        //Select year as 1990
        //monthSelector.selectByVisibleText("1990");

        DropDownHandler.selectOptionByIndex(faceBookPage.monthDropDown, 3); //Select month as April
        DropDownHandler.selectOptionByVisibleText(faceBookPage.dayDropDown, "1"); //Select day as 1
        DropDownHandler.selectOptionByValue(faceBookPage.yearDropDown, "1990"); //Select year as 1990


        //Select male gender
        faceBookPage.genderRadioButtons.get(1).click();
        //click on Sign Up button
        faceBookPage.signupButton.click();

        //Validate below error message is displayed with expected text
        String expectedErrorMsg = "Please choose a more secure password. It should be longer than 6 characters, " +
                "unique to you, and difficult for others to guess.";

        /* WebDriverWait explicitWait = new WebDriverWait(driver, 60);
        explicitWait.until(ExpectedConditions.textToBePresentInElement(faceBookPage.errorMessage, expectedErrorMsg)); */
        Waiters.waitUntilTextToBePresentInElement(driver, 60, faceBookPage.errorMessage, expectedErrorMsg);

        Assert.assertEquals(faceBookPage.errorMessage.getText(), expectedErrorMsg, "Error Msg have issues");

    }

    /* TEST CASE:
    Go to https://www.expedia.com
    Select “Flights” from “More travel” dropdown
    Select “Premium economy” from “Economy” dropdown
    Validate “Premium economy” is selected
    */
    @Test(priority = 2, description = "TC578: Validate Expedia dropdowns")
    public void testExpediaDropdowns(){
        driver.get("https://www.expedia.com");//Go to https://www.expedia.com

        expediaPage.moreTravelDropdown.click();//Click on “More travel” dropdown menu
        expediaPage.flights.click();// Select "Flights"
        expediaPage.flightsTypesDropdown.click(); //Click on “Economy” dropdown menu
        expediaPage.flightOptions.get(1).click(); // Select "Premium economy"

        Assert.assertEquals(expediaPage.flightsTypesDropdown.getText(), "Premium economy"); // Validate “Premium economy” is selected
    }





}
