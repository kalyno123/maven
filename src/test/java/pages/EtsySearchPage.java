package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EtsySearchPage {

    //NOTE: PAGE OBJECT MODEL --> CONSIST OF THE PAGE CONSTRUCTOR, THE WEB ELEMENTS, AND ANY RELATED METHODS FOR THE PAGE

    //DEFAULT CONSTRUCTOR
    public EtsySearchPage(WebDriver driver) {
        PageFactory.initElements(driver,this); // this method initializes all the elements below
    }

    // LOCATE ALL ETSY SEARCH PAGE WEB ELEMENTS HERE:
    @FindBy (id = "global-enhancements-search-query") // this tell it to find the web element specifically by (locator)
    public WebElement searchInputBox;

    @FindBy (css = "button[data-id='gnav-search-submit-button']")
    public WebElement searchButton;

    @FindBy (id = "logo")
    public WebElement etsyLogo;

    @FindBy (css = ".wt-display-inline-flex-sm>span")
    public WebElement searchResult;

    @FindBy (css = "ul[role='menubar'] span")
    public List<WebElement> mainHeaderLinks;

    @FindBy(css = ".signin-header-action")
    public WebElement signInButton;

    @FindBy(id = "join-neu-overlay")
    public WebElement signInModel;

    @FindBy(id = "join-neu-overlay-title")
    public WebElement signInModalHeading;


}
