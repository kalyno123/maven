package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // SINGLETON DESIGN PATTERN: PRIVATE CONSTRUCTOR SO THIS OBJECT CAN'T BE CREATED OUTSIDE OF THIS CLASS
    private Driver(){

    }

    // ENCAPSULATION: PRIVATE INSTANCE VARIABLE SO THIS ATTRIBUTE CAN'T BE MODIFIED OUTSIDE OF THIS CLASS
    private static WebDriver driver;

    // ENCAPSULATION: PUBLIC GET DRIVER METHOD
    public static WebDriver getDriver(){
        if (driver == null){ // if driver is not create (empty) then create a driver object ... otherwise just return the already existing driver.
            //System.setProperty("webdriver.chromedriver", "/Users/ngo/IdeaProjects/Selenium_Intro/chromedriver"); // TELLING THE SYSTEM WHERE THE CHROME DRIVER IS LOCATED
            //WebDriverManager.chromiumdriver().setup(); // THE DRIVER SETUP VIA MAVEN + BONI GARCIA
            //driver = new ChromeDriver(); // CREATE OBJECT OF WEB BROWSER

            // *** the browser define below with String is hard-coded ***
            //String browser = "chrome"; // define which browser you will run your test in; THIS IS INTERCHANGEABLE
            switch (ConfigReader.getProperty("browser")) {
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
                case "headless":
                    driver = new HtmlUnitDriver();
                    break;
                default:
                    throw new NotFoundException("Browser IS NOT DEFINED properly!!!");
            }
            if (!ConfigReader.getProperty("browser").equals("headless")){
                driver.manage().window().maximize();
                //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // WAITING FOR THE WEB ELEMENT TO LOAD(EXIST) ---> the time-amount(30) define is hard-coded
                driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigReader.getProperty("implicitWait")), TimeUnit.SECONDS); // WAITING FOR THE WEB ELEMENT TO LOAD(EXIST)
            }

        }
        return driver;
    }


    // QUIT DRIVER METHOD
    public static void quitDriver(){
        if (driver != null){ // this method is to teardown driver completely
            driver.manage().deleteAllCookies(); // deleting stored data from session
            driver.quit();
            driver = null;
        }
    }






}
