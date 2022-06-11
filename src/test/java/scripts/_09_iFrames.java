package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _09_iFrames extends Base{

    /* TEST CASE 1:
    Go to http://the-internet.herokuapp.com/
    Click on “Frames” link
    Click on “iFrame” link
    Clear text “Your content goes here.” in the content box
    Enter “Hello World” in the content box
    Validate the text of the content box is “Hello World”
    Validate the heading3 as “An iFrame containing the TinyMCE WYSIWYG Editor”
    */
    @Test (priority = 1)
    public void iFrameTestCase1(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Frames");
        heroAppPage.iFrameLink.click();

        // SWITCH TO INNER HTML - IFRAME
        // Locating inner iFrame as a web element and passing it into the switchTo() method ---> Syntax: WebElement innerIframe = driver.findElement(By.id("")); || driver.switchTo().frame(innerIframe);
        // Switching by index; this can be useful when you do not have anything static to locate your iframe ---> Syntax: driver.switchTo().frame(0);
        // By name or id; if they are not dynamic --> Syntax: driver.switchTo().frame("name or id");

        // driver.switchTo().frame(0); // HERE ---> Switching focus of iFrame to the INNER HTML by index;
        // driver.switchTo().frame("mce_0_ifr"); // HERE ---> Switching focus of iFrame to the INNER HTML by id locator
        driver.switchTo().frame(heroAppPage.innerIFrame); // HERE ---> Switching focus of iFrame to the INNER HTML by web element
        heroAppPage.contentBox.clear(); // belong to inner html
        heroAppPage.contentBox.sendKeys("Hello World");// belong to inner html
        softAssert.assertEquals(heroAppPage.contentBox.getText(), "Hello World");// belong to inner html

        // SWITCH TO OUTER / PARENT HTML
        // driver.switchTo().parentFrame(); --> this will go back to the parent
        // driver.switchTo().defaultContent(); --> this will go back to default html
        driver.switchTo().parentFrame();  // HERE --> Switching focus of iFrame to the OUTER(PARENT) HTML by index;
        softAssert.assertEquals(heroAppPage.heading3.getText(), "An iFrame containing the TinyMCE WYSIWYG Editor");// belong to outer html
    }

    /* HOW TO FIND ALL IFRAMES IN AN HTML DOM?
    ---> //iFrame
    */


    /* TEST CASE 2:
    Go to https://www.rediff.com/
    Validate money iFrame displayed with cell one and cell two
    */
    @Test(priority = 2)
    public void testIFrame2(){
        driver.get("https://www.rediff.com/");

        driver.switchTo().frame(rediffHomePage.moneyIFrame);
        //driver.switchTo().frame(0);
        //driver.switchTo().frame("moneyiframe");

        softAssert.assertTrue(rediffHomePage.iFrameCellOne.isDisplayed());
        softAssert.assertTrue(rediffHomePage.iFrameCellTwo.isDisplayed());

        //BELOW IS VALIDATING THE SAME THING BUT USING LIST AND LOOPS
        //System.out.println(rediffHomePage.moneyCells.size()); // 2 --> this is to show how many elements it's currently focusing on in the list
        for(WebElement element : rediffHomePage.moneyCells) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

}
