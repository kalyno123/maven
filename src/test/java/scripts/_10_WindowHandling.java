package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _10_WindowHandling extends Base{


    /* WINDOW HANDLING NOTES:
    - getWindowHandle() method returns the unique id for current window as a String. SYNTAX: --> String currentWindowId = driver.getWindowHandle();
    - getWindowHandles() method returns all window ids that opened in browser by Selenium, and it will return a set of unique window ids. SYNTAX: --> Set<String> allWindowIds = driver.getWindowHandles();
    - switchTo() method can be used to switch window or tab. SYNTAX: --> driver.switchTo().window(windowToBeSwitched);

    - driver.close() method is used to close current window that Selenium focus is on.
    - driver.quit() is used to close all the windows opened in a particular browser session.
    Note: NoSuchWindowException WILL BE THROWN IF ANY ACTION ARE PERFORM ON A WINDOW THAT NO LONGER EXIST.

    HOW TO SWITCH TO 'CHILD' WINDOW?
    1. Get id (handle) of the parent (main) window
    2. Get id (handle) of the all windows for opened with browser session and store in a set
    3. Create an Iterator to loop through each window handle and once the window handle is not equal to main window handle, switch
    */

    /* TEST CASE 1:
    TEST CASE 1: Validate FaceBook social media icon for TechGlobal School
    1. Go to https://www.techglobalschool.com/
    2. Click on FaceBook icon in the footer
    3. Validate user is routed to https://www.facebook.com/techglobalschool
    */
    @Test(priority = 1, description = " TEST CASE 1: Validate FaceBook social media icon for TechGlobal School")
    public void testTechGlobalSchoolFaceBookIcon(){
        driver.get("https://www.techglobalschool.com/");

        String tgHomeWindow = driver.getWindowHandle(); // ALWAYS STORE WINDOW'S ID; this returns a String of the unique ID for the window
        //System.out.println(tgHomeWindow); // CDwindow-B89E55EEBB529EC2DE147A02861E2AC9 --> this ID will change per session
        tgHomePage.faceBookIcon.click();

        // at this point there's TWO tab-window open; THIS IS HOW TO SWITCH TO THE NEWLY OPEN WINDOW; BY LOOPING THROUGH THE SET AND SWITCH TO WHAT IS NOT THE CURRENT FOCUS
        for (String thisWindow : driver.getWindowHandles()){
            if (!thisWindow.equals(tgHomeWindow)) driver.switchTo().window(thisWindow);
        }
        driver.switchTo().window(tgHomeWindow); // THIS IS HOW TO SWITCH BACK TO THE PREVIOUS TAB

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/techglobalschool"); // Validate user is routed to https://www.facebook.com/techglobalschool
    }

    /* TEST CASE 2:
    Go to http://the-internet.herokuapp.com/
    Click on “Multiple Windows” link
    Click on “Click Here” link
    Validate the heading3 as “New Window”
    Navigate back to previous window
    Validate the heading3 as “Opening a new window”
    */
    @Test(priority = 2, description = "TEST CASE 2: Multiple Windows")
    public void testWindowHandle2(){
        driver.get("http://the-internet.herokuapp.com/"); // Go to http://the-internet.herokuapp.com/
        heroAppPage.clickOnLink("Multiple Windows"); // Click on “Multiple Windows” link
        String theInternetWindow = driver.getWindowHandle(); // HERE STORING THE UNIQUE ID OF 'THE INTERNET' WINDOW
        heroAppPage.clickHereLink.click(); // Click on “Click Here” link

        // HERE SWITCHING TO THE NEW TAB THAT WAS OPEN AFTER CLICKING 'CLICK HERE' LINK
        for (String currentWindow : driver.getWindowHandles()){
            if (!currentWindow.equals(theInternetWindow)) driver.switchTo().window(currentWindow); // if current window is NOT equals to 'THE INTERNET' window then switch to THAT window
        }
        softAssert.assertEquals(heroAppPage.newWindowH3.getText(), "New Window"); // Validate the heading3 as “New Window”

        driver.switchTo().window(theInternetWindow); // Navigate back to previous window
        softAssert.assertEquals(heroAppPage.openingWindowH3.getText(), "Opening a new window"); // Validate the heading3 as “Opening a new window”
    }



}
