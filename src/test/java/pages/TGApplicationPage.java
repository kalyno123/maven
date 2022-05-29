package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TGApplicationPage {

    //DEFAULT CONSTRUCTOR
    public TGApplicationPage(WebDriver driver){
        PageFactory.initElements(driver,this); // this method initializes all the elements below
    }

    // LOCATE ALL ETSY SEARCH PAGE WEB ELEMENTS HERE:
    @FindBy (css = "#comp-kh9s3kyz3 span span") // this tell it to find the web element specifically by (locator)
    public WebElement heading1;


}
