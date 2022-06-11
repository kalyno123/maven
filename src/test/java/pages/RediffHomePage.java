package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RediffHomePage {

    public RediffHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "moneyiframe")
    public WebElement moneyIFrame;

    @FindBy (css = ".cellone")
    public WebElement iFrameCellOne;

    @FindBy (css = ".celltwo")
    public WebElement iFrameCellTwo;

    // cell one and two in a list; in DOM locator found 5 elements but 3/5 is in outer frame and 2/5 is in inner frame; when switch between frames it only focus on the ones that belong to that frame
    @FindBy (css = "div[class^='cell']")
    public List<WebElement> moneyCells;


}
