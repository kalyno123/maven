package testng_learning;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestData;

public class _06_Parameters {

    // HOW TO SET UP GLOBAL PARAMETERS
    @Parameters ({"username", "password"})
    @Test()
    public void login1(String username, String password){
        System.out.println("Username comes from xml = " + username);
        System.out.println("Password comes from xml = " + password);
    }

    // ANOTHER WAY TO SET UP PARAMETERS FROM CONFIGURATION.PROPERTIES FILE
    @Test()
    public void login2(){
        System.out.println("Username comes from properties = " + ConfigReader.getProperty("username"));
        System.out.println("Password comes from properties = " + ConfigReader.getProperty("password"));
    }

    // ANOTHER WAY TO SET UP PARAMETERS FROM A CUSTOM CLASS FINAL INSTANCE VARIABLE
    @Test()
    public void login3(){
        System.out.println("Username comes from TestData = " + TestData.username);
        System.out.println("Password comes from TestData = " + TestData.password);
    }

}
