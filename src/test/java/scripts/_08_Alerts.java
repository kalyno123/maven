package scripts;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.AlertHandler;

public class _08_Alerts extends Base{

   /* TEST CASE 1:
   Go to https://www.etsy.com/
   Click on ”Sign in” button
   Validate “Sign in” modal is displayed
   Validate heading1 of the modal is “Sign in"
   */

    @Test(priority = 1, description = "Test Case 1")
    public void etsySignInModal(){
        driver.get("https://www.etsy.com/");

        etsySearchPage.signInButton.click();

        Assert.assertTrue(etsySearchPage.signInModel.isDisplayed());
        Assert.assertEquals(etsySearchPage.signInModalHeading.getText(), "Sign in");

    }

    /* TEST CASE 2:
    Go to http://the-internet.herokuapp.com/
    Click on "JavaScript Alerts" link
    Click on "Click for JS Alert" button
    Validate the text of the alert displayed is "I am a JS Alert"
    Click on "OK" button on the alert
    Validate "You successfully clicked an alert" message is displayed with its text
    */
    @Test(priority = 2, description = "Test Case 2")
    public void testInfoWarningAlert(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("JavaScript Alerts");

        heroAppPage.clickOnAlertButton("Click for JS Alert");
        Alert alert = driver.switchTo().alert(); // HERE IS INSTANTIATING THE ALERT OBJECT --> this is an interface that comes from Selenium

        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        alert.accept(); // this accept(); method basically means "Approve"

        Assert.assertEquals(heroAppPage.resultParagraph.getText(), "You successfully clicked an alert");
    }

    /* TEST CASE 3:
    1.Go to http://the-internet.herokuapp.com/
    2.Click on “JavaScript Alerts” link
    3.Click on “Click for JS Confirm” button
    4.Validate the text of the alert displayed is “I am a JS Confirm”
    5.Click on ”Cancel” button on the alert
    6.Validate “You clicked: Cancel” message is displayed with its text
    7.Click on “Click for JS Confirm” button again
    8.Click on ”OK” button on the alert
    9.Validate “You clicked: Ok” message is displayed with its text
    */
    @Test(priority = 3, description = "Test Case 3")
    public void testConfirmationAlert(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("JavaScript Alerts");

        heroAppPage.clickOnAlertButton("Click for JS Confirm");
        Alert alert = driver.switchTo().alert();
        alert.dismiss(); // here is when the action or handling of alert is done
        Assert.assertEquals(heroAppPage.resultParagraph.getText(), "You clicked: Cancel");

        heroAppPage.clickOnAlertButton("Click for JS Confirm");
        alert.accept();
        Assert.assertEquals(heroAppPage.resultParagraph.getText(), "You clicked: Ok");
    }

    /* TEST CASE 3:
    Go to http://the-internet.herokuapp.com/
    Click on “JavaScript Alerts” link
    Click on “Click for JS Prompt” button
    Validate the text of the alert displayed is “I am a JS prompt”
    Click on ”Cancel” button on the alert
    Validate “You entered: null” message is displayed with its text
    Click on “Click for JS Prompt” button again
    Type “Hello” in the alert input box
    Click on ”OK” button on the alert
    Validate “You entered: Hello” message is displayed with its text
    */
    @Test(priority = 4, description = "Test Case 4")
    public void testPromptAlert(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("JavaScript Alerts");

        heroAppPage.clickOnAlertButton("Click for JS Prompt");
        //Alert alert = driver.switchTo().alert(); --> THIS STEP IS NO LONGER NEEDED TO CODE DUE TO THE ALERT HANDLER CLASS
        Assert.assertEquals(AlertHandler.getAlertText(driver), "I am a JS prompt");
        AlertHandler.dismissAlert(driver);
        Assert.assertEquals(heroAppPage.resultParagraph.getText(), "You entered: null");

        heroAppPage.clickOnAlertButton("Click for JS Prompt");
        AlertHandler.sendKeysToAlert(driver,"Hello");
        AlertHandler.acceptAlert(driver);
        Assert.assertEquals(heroAppPage.resultParagraph.getText(), "You entered: Hello");
    }

    /* TEST CASE 5:
    Go to https://www.amazon.com/
    Click on “Select your address” link in the top navigation bar
    Validate “Choose your location” modal is displayed
    Enter your zip code to input box
    Click on “Apply” button
    Validate the zip code entered displayed in the delivery message
    */
    @Test(priority = 5, description = "TASK-5 - Amazon Address Modal")
    public void testAmazonAddressModal(){
        driver.get("https://www.amazon.com/");
        amazonHomePage.selectAddressLink.click();
        String zipCode = "60018";

        amazonHomePage.zipCodeInputBox.sendKeys(zipCode);
        amazonHomePage.applyButton.click();

        Assert.assertTrue(amazonHomePage.deliveryMessage.getText().contains(zipCode));
    }
}
