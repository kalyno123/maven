package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _06_RadioButtonTest extends Base{

    /* TEST CASE:
    Go to https://www.facebook.com/
    Click on “Create New Account” link
    Validate “Female”, “Male” and “Custom” radio buttons are displayed, enabled and not selected
    Select “Female” and validate it is selected
    Select “Male” radio button and validate “Male” is selected and “Female” is deselected
    */

    @Test(priority = 1, description = "TC243: Validate Facebook gender radio")
    public void testFacebookGenderRadioButton(){
        driver.get("https://www.facebook.com/"); // Go to https://www.facebook.com/
        faceBookPage.createNewAccountLink.click(); // Click on “Create New Account” link

        // Validate “Female”, “Male” and “Custom” radio buttons are displayed, enabled and not selected
        for (WebElement element : faceBookPage.genderRadioButtons){ // List maintains insertion order: [female, male, custom]
            Assert.assertTrue(element.isDisplayed(), "Element is NOT displayed");
            Assert.assertTrue(element.isEnabled(), "Element is NOT enabled");
            Assert.assertFalse(element.isSelected(), "Element is selected");
        }

        // Select “Female” and validate it is selected
        faceBookPage.genderRadioButtons.get(0).click();
        Assert.assertTrue(faceBookPage.genderRadioButtons.get(0).isSelected());

        // Select “Male” radio button and validate “Male” is selected and “Female” is deselected
        faceBookPage.genderRadioButtons.get(1).click();
        Assert.assertTrue(faceBookPage.genderRadioButtons.get(1).isSelected());
        Assert.assertFalse(faceBookPage.genderRadioButtons.get(0).isSelected());




    }
}
