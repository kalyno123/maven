package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeroAppPage {

    public HeroAppPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//ul/li/a")
    public List<WebElement> links;

    @FindBy(css = "form#checkboxes>input")
    public List<WebElement> checkboxes;

    @FindBy (xpath = "//ul//button")
    public List<WebElement> alertButtons;

    @FindBy(id = "result")
    public WebElement resultParagraph;

    @FindBy (xpath = "(//div[@id='content']//a)[2]")
    public WebElement iFrameLink;

    @FindBy(css = "#tinymce>p")
    public WebElement contentBox;

    @FindBy(css = ".example>h3")
    public WebElement heading3;

    @FindBy(id = "mce_0_ifr")
    public WebElement innerIFrame;

    @FindBy(css = "#content a")
    public WebElement clickHereLink;

    @FindBy(css = "#content h3")
    public WebElement openingWindowH3;

    @FindBy(css = ".example>h3")
    public WebElement newWindowH3;

    @FindBy(id = "file-upload")
    public WebElement chooseFileInputBox;

    @FindBy(id = "file-submit")
    public WebElement uploadFileButton;

    @FindBy(xpath = "//h3")
    public WebElement fileUploadedH3;

    @FindBy(id = "uploaded-files")
    public WebElement uploadedFileText;

    @FindBy(css = "table[id='table1'] th")
    public List<WebElement> tableHeaders;

    @FindBy(css = "#table1>tbody>tr:nth-child(1)>td") // xpath = "(//table[@id='table1'']//tr)[2]/td"
    public List<WebElement> table1Row1;

    @FindBy(xpath = "//table[@id='table1']/tbody/tr/td[2]") // css = "#table1>tbody td:nth-child(2)"
    public List<WebElement> table1Column2;

    @FindBy(css = "#table1>tbody>tr>td")
    public List<WebElement> tableBody;


    public void clickOnLink(String linkText){
        for (WebElement link : links){
            if (link.getText().equals(linkText)){
                link.click();
                break;
            }
        }
    }

    public void clickOnAlertButton(String buttonText){
        for (WebElement button : alertButtons){
            if (button.getText().equals(buttonText)){
                button.click();
                break;
            }
        }
    }




}
