package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Driver;

public class Base {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver(); // SETTING UP DRIVER OBJECT (OPENING BROWSER)
    }

    @AfterMethod
    public void teardown(){
        Driver.quitDriver(); // THIS METHOD IN OUR UTIL. CLASS TEARDOWN THE DRIVER COMPLETELY INCLUDING DELETING ANY STORED DATA(COOKIES)
    }


}
