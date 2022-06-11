package scripts;

import com.sun.deploy.util.Waiter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _11_FileUpload extends Base{

    // SELENIUM CANNOT DIRECTLY UPLOAD FILE BUT WE CAN IF WE DEFINE THE FILE'S PATH.
    // we will pass file path to input field by using sendKeys(path) method and click on upload button by click() method.
    // SELENIUM ITSELF CANNOT HANDLE FILE DOWNLOADS (half of the process can be automated but the validation of the downloaded file is out-of-scope- for Selenium) ... THUS, WE KEEP UPLOAD/DOWNLOAD AS MANUAL.
    // NOTE: THIRD-PARTY TOOLS SUCH AS ROBOT & AUTOIT CAN BE USED TO AUTOMATE DOWNLOAD TEST CASES. OR BY USING JAVA'S FILE CLASS AND PASSING THE PATH OF THE FILE.


    /* TEST CASE 1:
    Create an MS-Word file on your desktop called “myFile.docx”
    Go to http://the-internet.herokuapp.com/
    Click on “File Upload” link
    Choose created file to be uploaded to the page
    Click on “Upload” button
    Validate “File Uploaded!” heading3 text
    Validate ”myFile.docx” in the uploaded file list
    */
    @Test(priority = 1, description = "File upload")
    public void testFileUpload1() {
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("File Upload");
        heroAppPage.chooseFileInputBox.sendKeys("/Users/ngo/IdeaProjects/tentng_framework/myKalyFile.txt");
        heroAppPage.uploadFileButton.click();

        Assert.assertEquals(heroAppPage.fileUploadedH3.getText(), "File Uploaded!");
        Assert.assertEquals(heroAppPage.uploadedFileText.getText(), "myKalyFile.txt");
    }

}
