package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class _02_TechGlobalTest extends Base{

    //WebDriver driver;

    /*
    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
    }
    */



    @Test(description = "TC123: Validate Application form heading")
    public void testApplicationFormHeading(){
        driver.get("https://www.techglobalschool.com/apply-now");

        //WebElement heading1 = driver.findElement(By.cssSelector("#comp-kh9s3kyz3 span span"));
        //System.out.println(heading1.isDisplayed() ? "Application Form Heading1 validation PASSED" : "Application Form Heading1 validation FAILED");

        Assert.assertTrue(tgApplicationPage.heading1.isDisplayed());
        Assert.assertEquals(tgApplicationPage.heading1.getText(), "Application Form");
    }


    /*
    @AfterTest
    public void teardown(){
        driver.quit();
    }
    */


}
