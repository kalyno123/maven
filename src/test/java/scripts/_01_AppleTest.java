package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
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


    @Test // this is annotation make this method executable without main(); -- this will look for @BeforeMethod annotation and run that first
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

    @Test
    public void testAppleURL(){
        driver.get("https://www.apple.com/");

        String expectedURL = "https://www.apple.com/";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL);
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
