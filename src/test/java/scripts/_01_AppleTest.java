package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utilities.Driver;

public class _01_AppleTest {

    // ** Declare your global driver
    WebDriver driver;

    // 1. Initial set up - before each test
    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
    }

    @Test (groups = "Functional")// this is annotation make this method executable without main(); -- this will look for @BeforeMethod annotation and run that first
    // 2. Validation of test - test
    public void testAppleTitle(){
        driver.get("https://www.apple.com/");

        String expectedTitle = "Apple"; // requirement
        String actualTitle = driver.getTitle(); // development

        //if(actualTitle.equals(expectedTitle)) System.out.println("Apple title validation passed");
        //else System.out.println("Apple title validation failed");

        // ** instead of if/else we will use TestNG assertion methods **
        // NOTE: tests run alphabetically [A_Za-z0-9]
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 1, description = "TC345")
    public void testAppleURL(){
        driver.get("https://www.apple.com/");

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.apple.com/";

        Assert.assertEquals(actualURL, expectedURL);
    }

    @Ignore//(priority = 2, description = "TC873")
    public void X(){
        //fail(); method is used to fail a test on purpose
        //We use this for known issues; test cases that have a bug and a bug ticket is already generated for it.
        Assert.fail("Failure on purpose"); // message here should be meaningful for reporting
    }

    @AfterTest
    // 3. Teardown actions - after each test
    public void teardown(){
        Driver.quitDriver();
    }




    /* OLD PRIMITIVE WAY
    public static void main(String[] args) {
        // 1. Initial set up - before each test
        WebDriver driver = Driver.getDriver();

        // 2. Validation of test - test
        driver.get("https://www.apple.com/");

        String expectedTitle = "Apple"; // requirement
        String actualTitle = driver.getTitle(); // development

        if(actualTitle.equals(expectedTitle)) System.out.println("Apple title validation passed");
        else System.out.println("Apple title validation failed");

        // 3. Teardown actions - after each test
        Driver.quitDriver();
    }
    */




}
