package testng_learning;

import org.testng.Assert;

import org.testng.annotations.Test;

public class _04_Optional_Assertion_Error_Msg {

    @Test
    public void method1(){
        // TestNG way
        Assert.assertTrue(false, "Error Msg");
        Assert.assertEquals("actual", "expected", "Error Msg");

        // JUnit way
        // Assert.assertTrue("Error Msg", false);
        // Assert.assertEquals("expected","actual",  "Error Msg");

    }


}
