package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _16_DataProvider extends Base{

    @DataProvider
    public Object[] searchKeys(){
        return new Object[]{"Apple", "Orange", "Cucumber", "Gherkin", "Eggplant", "Kiwi"};
    }

    @Test(priority = 1, dataProvider = "searchKeys")
    public void testGoogleSearch(String key){
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys(key + Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains(key));
    }


    @DataProvider
    public Object[][] getCredentials(){
        Object[][] credentials = new Object[4][2];
        credentials[0][0] = "johndoe";
        credentials[0][1] = "abcd1234";
        credentials[1][0] = "alexsmith";
        credentials[1][1] = "alex123";
        credentials[2][0] = "x_smith";
        credentials[2][1] = "@#%#%@#4";
        credentials[3][0] = "tomsmith";
        credentials[3][1] = "SuperSecretPassword!";

        return credentials;
    }

    @Test(priority = 2, dataProvider = "getCredentials")
    public void testLogin(String username, String password){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Form Authentication");
        heroAppPage.username.sendKeys(username);
        heroAppPage.password.sendKeys(password);
        heroAppPage.loginButton.click();
    }

}
