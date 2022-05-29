package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResultPage {

    public GoogleSearchResultPage(WebDriver driver){
        PageFactory.initElements(driver, this); // 'this' --> referring to the current object (which is in the Base class)
    }

    @FindBy(id = "result-stats")
    public WebElement searchResults;






}
