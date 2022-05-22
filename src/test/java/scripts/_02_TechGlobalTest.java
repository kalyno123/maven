package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;

public class _02_TechGlobalTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
    }

    @Test
    public void testApplicationFormHeading(){
        driver.get("https://www.techglobalschool.com/apply-now");

        WebElement heading1 = driver.findElement(By.cssSelector("#comp-kh9s3kyz3 span span"));
        String actualText = heading1.getText();
        String expectedText = "Application Form";

        //System.out.println(heading1.isDisplayed() ? "Application Form Heading1 validation PASSED" : "Application Form Heading1 validation FAILED");
        Assert.assertTrue(heading1.isDisplayed());
        Assert.assertEquals(actualText, expectedText);
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }


}
