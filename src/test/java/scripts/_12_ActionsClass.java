package scripts;

import com.sun.deploy.util.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiters;

import java.time.Duration;
import java.util.List;

public class _12_ActionsClass extends Base{

    /* TEST CASE 1:
    Go to https://www.techglobalschool.com/
    Move address displayed in the footer
    Validate the address is “2860 S River Rd Suite 350, Des Plaines IL 60018”
    */
    @Test (priority = 1, description = "Actions | move to element 1")
    public void moveToElementPractice1(){
        driver.get("https://www.techglobalschool.com/");

        //It must be POM, and we must read it from the page but this is for interview purposes
        WebElement address = driver.findElement(By.cssSelector("#comp-kixny3ro span>span"));

        //Actions actions = new Actions(driver);
        actions.moveToElement(address).perform();

        Assert.assertEquals(address.getText(), "2860 S River Rd Suite 350, Des Plaines IL 60018");
    }

    /* Test name = Actions class | move to element 2 -- Method name = moveToElementPractice2()
    Go to https://www.carvana.com/
    Hover over “FINANCING” menu item (dropdown)
    Validate below items are displayed:
    WHY FINANCE WITH CARVANA
    GET PREQUALIFIED
    AUTO LOAN CALCULATOR
    */
    @Test (priority = 2, description = "Actions | move to element 1")
    public void moveToElementPractice2(){
        driver.get("https://www.carvana.com/");
        //driver.navigate().refresh(); // THIS REFRESHES THE DOM SO THE ELEMENT WILL EXIST IN THE DOWN AFTER THE REFRESH
        WebElement financeDropdown = driver.findElement(By.cssSelector("div[data-cv-test='headerFinanceDropdown']"));
        Waiters.pause(5);

        //Move to financeDropdown
        //Actions actions = new Actions(driver);
        actions.moveToElement(financeDropdown).perform();
        Waiters.pause(2);
        List<WebElement> financeDropdownOptions = driver.findElements(By.cssSelector("a[data-cv-test^='headerFinance']"));

        //Validate texts expected
        String[] optionTexts = {"WHY FINANCE WITH CARVANA", "GET PREQUALIFIED", "AUTO LOAN CALCULATOR"};
        for (int i = 0; i < 3; i++) {
            Assert.assertTrue(financeDropdownOptions.get(i).isDisplayed());
            Assert.assertEquals(financeDropdownOptions.get(i).getText(), optionTexts[i]);
            //System.out.println("======================" + financeDropdownOptions.get(i).getText() + "======================");
        }
    }

    /*  TEST CASE 3:
    Go to https://www.techglobalschool.com/
    Click on “Register an Intro Session” link
    Validate the url is https://www.techglobalschool.com/apply-now-1
    Method name = clickOnElementPractice()
    Test name = Actions class | click on element
    */
    @Test (priority = 3, description = "Actions | Click")
    public void clickOnElementPractice(){
        driver.get("https://www.techglobalschool.com/");
        WebElement registerForIntroLink = driver.findElement(By.cssSelector("#comp-kvjohd5t5>a"));
        registerForIntroLink.click(); // THIS SOMETIMES DOES NOT CLICK ON THE WEB ELEMENT ... SO YOU USE ACTION CLASS TO PERFORM THE CLICK ... LASTLY USE JAVASCRIPT EXECUTOR IF 1ST 2-WAYS DIDNT WORK

        // actions.moveToElement(registerForIntroLink).perform();
        // Waiter.pause(2);
        // actions.click(registerForIntroLink).perform();
        //actions.moveToElement(registerForIntroLink).pause(Duration.ofSeconds(2)).click().perform();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.techglobalschool.com/apply-now-1");
    }

    /* TEST CASE 4:
    Go to https://www.techglobalschool.com/
    Right-Click on "Register for Intro Session" link  ---> contextClick();
    Validate the url is https://www.techglobalschool.com/
    */
    @Test (priority = 4, description = "Actions | Right click")
    public void rightClickPractice(){
        driver.get("https://www.techglobalschool.com/");
        WebElement registerForIntroLink = driver.findElement(By.cssSelector("#comp-kvjohd5t5>a"));
        actions.contextClick(registerForIntroLink).perform();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.techglobalschool.com/");
    }

    /* TEST CASE 5:
    Go to https://demoqa.com/droppable
    Click and hold "Drag me" box and release it on "Drop here" box
    Validate "Drop here" text is replaced with "Dropped!"
    */
    @Test(priority = 5, description = "Actions | Click - hold and release | Drag and drop")
    public void clickHoldAndReleasePractice(){
        driver.get("https://demoqa.com/droppable");
        WebElement dragMeBox = driver.findElement(By.id("draggable"));
        WebElement dropHereBox = driver.findElement(By.id("droppable"));

        //actions.clickAndHold(dragMeBox).moveToElement(dropHereBox).release().perform();
        actions.dragAndDrop(dragMeBox, dropHereBox).perform();
        Assert.assertEquals(dropHereBox.getText(), "Dropped!");
    }

    /* TEST CASE 6:
    Go to https://www.google.com/
    Enter "Hello" to search input box
    Validate value attribute is "Hello"
    Method name = sendKeysToAnElement ()
    Test name = Actions class | send keys to an element
    */
    @Test(priority = 6, description = "Actions class | send keys to an element")
    public void sendKeysToAnElement(){
        driver.get("");
        actions.sendKeys(googleSearchPage.searchInputBox, "Hello").perform(); // sendKeys(target, "keys")
        //actions.moveToElement(googleSearchPage.searchInputBox).sendKeys("Hello").perform();
    }

    /* TEST CASE 7:
    Go to https://www.google.com/
    Enter “techglobal” to search input box with uppercases
    Validate the value attribute for search input box is “TECHGLOBAL”
    Then, copy the text and paste again
    Validate the value attribute for search input box is “TECHGLOBALTECHGLOBAL”
    */
    @Test(priority = 7, description = "Actions | key down and key up")
    public void practiceKeyDownAndKeyUp(){
        driver.get("https://www.google.com/");
        //googleSearchPage.searchInputBox.sendKeys("TECHGLOBALTECHGLOBAL");

        actions.keyDown(Keys.SHIFT)
                .sendKeys(googleSearchPage.searchInputBox, "techglobal")
                .keyUp(Keys.SHIFT)
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .sendKeys("c")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.ARROW_RIGHT)
                .keyDown(Keys.COMMAND).sendKeys("v")
                .perform();
    }

    /* TEST CASE 8:
    Go to https://www.etsy.com/
    Hover over on "Jewelry & Accessories" menu item
    Validate below categories are displayed with their expected texts
    Accessories
    Bags & Purses
    Necklaces
    Rings
    Earrings
    Bracelets
    Body Jewelry
    All Jewelry
    */
    @Test(priority = 8, description = "Etsy | test")
    public void etsyTest(){
        driver.get("https://www.etsy.com/");
        actions.moveToElement(etsySearchPage.mainHeaderLinks.get(1)).perform();
        String[] jewelryMenuItemsText = {"Accessories", "Bags & Purses", "Necklaces", "Rings", "Earrings", "Bracelets", "Body Jewelry", "All Jewelry"};
        int index = 0;
        for (WebElement menuItem : etsySearchPage.jewelryAccessoriesMenuItems){
            Waiters.waitUntilTextToBePresentInElement(driver, 10, menuItem, jewelryMenuItemsText[index++]);
            softAssert.assertEquals(menuItem.getText(), jewelryMenuItemsText[index++]);
        }
    }
    // NOTE: IF YOU'RE NOT ABLE TO GET TEXT OF THE WEB ELEMENT AND ALL OTHER WAYS ARE NOT SUCCESSFUL LAST OPTION IS TO USE JAVASCRIPT EXECUTOR AS JS IS THE BASE OF THE APPLICATION.
}
