package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // PRIVATE CONSTRUCTOR SO THIS OBJECT CAN'T BE CREATED OUTSIDE OF THIS CLASS
    private Driver(){

    }

    // PRIVATE INSTANCE VARIABLE SO THIS ATTRIBUTE CAN'T BE MODIFIED OUTSIDE OF THIS CLASS
    private static WebDriver driver;

    // PUBLIC GET DRIVER METHOD
    public static WebDriver getDriver(){
        if (driver == null){ // if driver is not create (empty) then create a driver object ... otherwise just return the already existing driver.
            //System.setProperty("webdriver.chromedriver", "/Users/ngo/IdeaProjects/Selenium_Intro/chromedriver"); // TELLING THE SYSTEM WHERE THE CHROME DRIVER IS LOCATED
            //WebDriverManager.chromiumdriver().setup(); // THE DRIVER SETUP VIA MAVEN + BONI GARCIA
            //driver = new ChromeDriver(); // CREATE OBJECT OF WEB BROWSER
            String browser = "chrome"; // define which browser you will run your test in; THIS IS INTERCHANGEABLE
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
                default:
                    throw new NotFoundException("Browser IS NOT DEFINED properly!!!");
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // WAITING FOR THE WEB ELEMENT TO LOAD(EXIST)
        }
        return driver;
    }


    // PUBLIC QUIT DRIVER METHOD
    public static void quitDriver(){
        if (driver != null){ // this method is to teardown driver completely
            driver.manage().deleteAllCookies(); // deleting stored data from session
            driver.quit();
            driver = null;
        }
    }






}
