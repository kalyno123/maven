package scripts;

import org.testng.annotations.Test;
import utilities.Waiters;

public class _14_Scrolling extends Base{

    /* SCROLLING: not always but sometimes you may need to scroll the element into view in order to do some displayed validation.
    - if an exception is thrown it may be bc the element isn't in view to test; Scroll page down or up to avoid these unexpected exceptions.
    1. Using actions.moveToElement().perform() method from Actions class
    2. Using actions.sendKeys(Keys.PAGE_DOWN).perform()
    NOTE: You can pass this line as many as you want, until you reach to the web element that you want to perform some task on. Use WHILE LOOP (while element isn't visible keep scrolling).
    3. Using JavascriptExecutor
    */
    @Test
    public void testScrolling(){
        driver.get("https://www.techglobalschool.com/");
        //actions.moveToElement(tgHomePage.registerForIntroLink).perform();
        //actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        //JavascriptExecutor js = (JavascriptExecutor) driver; --> ADDED TO BASE
        Waiters.pause(3);
        //js.executeScript("arguments[0].scrollIntoView(true);", tgHomePage.registerForIntroLink); --> this line of code scrolled too much passing the element we want
        js.executeScript ("arguments[0].scrollIntoView({block: 'center'})", tgHomePage.registerForIntroLink); //js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",tgHomePage.registerForIntroLink);
        Waiters.pause(3);
        /* ANOTHER WAY TO MOVE ELEMENT INTO MIDDLE OF WINDOW:
        js.executeScript("var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);\n" +
        "var elementTop = arguments[0].getBoundingClientRect().top;\n" +
        "window.scrollBy(0, elementTop-(viewPortHeight/2));", tgHomePage.registerForIntroLink);
        HELPFUL JSE SCR:
        https://www.softwaretestingmaterial.com/javascriptexecutor-selenium-webdriver/#:~:text=JavaScript%20executor%20is%20an%20interface,frame%20or%20window%20or%20page.
        */

    }
}
