package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FaceBookPage {

    public FaceBookPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "a[data-testid='open-registration-form-button']")
    public WebElement createNewAccountLink;

    @FindBy(css = "._8esa")
    public List<WebElement> genderRadioButtons;

    @FindBy(css = "input[name='firstname']")
    public WebElement firstNameInputBox;

    @FindBy(css = "input[name='lastname']")
    public WebElement lastNameInputBox;

    @FindBy(css = "input[name='reg_email__']")
    public WebElement emailOrPhnInputBox;

    @FindBy(css = "input[name='reg_email_confirmation__']")
    public WebElement reenterEmailOrPhnInputBox;

    @FindBy(css = "input[name='reg_passwd__']")
    public WebElement passwordInputBox;

    @FindBy(id = "month")
    public WebElement monthDropDown;

    @FindBy(id = "day")
    public WebElement dayDropDown;

    @FindBy(id ="year")
    public WebElement yearDropDown;

    @FindBy(css = "button[name='websubmit']")
    public WebElement signupButton;

    @FindBy(id = "reg_error_inner")
    public WebElement errorMessage;

}
