package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _13_Tables extends Base{

    /* TEST CASE 1:
    Go to http://the-internet.herokuapp.com/
    Click on “Sortable Data Tables” link
    Validate the table 1 headers to be displayed as below:
    Last Name
    First Name
    Email
    Due
    Web Site
    Action
    */
    @Test (priority = 1, description = "Table Header Validation")
    public void testTableHeaders(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");
        String[] headerTexts = {"Last Name", "First Name", "Email", "Due", "Web Site", "Action"};
        int index = 0;
        for (WebElement header : heroAppPage.tableHeaders){
            Assert.assertEquals(header.getText(), headerTexts[index++]);
        }
    }

    /* TEST CASE 2:
    Go to http://the-internet.herokuapp.com/
    Click on “Sortable Data Tables” link
    Validate the table 1 row 1 to be displayed as below:
    Smith
    John
    jsmith@gmail.com
    $50.00
    http://www.jsmith.com
    edit delete
    */
    @Test (priority = 2, description = "Table Row1 Validation")
    public void testTableRow() {
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");
        String[] row1Texts = {"Smith", "John", "jsmith@gmail.com", "$50.00", "http://www.jsmith.com", "edit delete"};
        int index = 0;
        for (WebElement rowElement : heroAppPage.table1Row1){
            Assert.assertEquals(rowElement.getText(), row1Texts[index++]);
        }
    }

    /* TEST CASE 3:
    Go to http://the-internet.herokuapp.com/
    Click on “Sortable Data Tables” link
    Validate the table 1 column 2 (First Name) to be displayed as below:
    John
    Frank
    Jason
    Tim
    */
    @Test (priority = 3, description = "Table Column2 Validation")
    public void testTableColumn() {
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");
        String[] column2Texts = {"John", "Frank", "Jason", "Tim"};
        int index = 0;
        for (WebElement column2Element : heroAppPage.table1Column2){
            Assert.assertEquals(column2Element.getText(), column2Texts[index++]);
        }
    }

    /* TEST CASE 4:
    Go to http://the-internet.herokuapp.com/
    Click on “Sortable Data Tables” link
    Validate each cell has value (not empty)
    */
    @Test (priority = 4, description = "Table Body Validation")
    public void testTableBody() {
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");
        for (WebElement tableBodyElements : heroAppPage.tableBody){
            Assert.assertNotEquals(tableBodyElements.getText(),  "");
        }
    }


}
