package testng_learning;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import scripts.Base;

public class _03_Soft_vs_Hard_Assertions extends Base {

    @Test (priority = 1, description = "Practicing Hard Assertions")
    public void method1(){
        // HARD ASSERTION --> WHEN THERE IS AN ERROR AT ANY LINE THE PROGRAM FLOW *WILL* BREAK AND WILL *NOT* CONTINUE WITH THE REST
        Assert.assertTrue(true);
        Assert.assertFalse(false, "===FAIL===");
        System.out.println("Hello World");
    }

    @Test (priority = 2, description = "Practicing Soft Assertions")
    public void method2(){
        // SOFT ASSERTION --> WHEN THERE IS AN ERROR AT ANY LINE THE PROGRAM FLOW WILL *NOT* BREAK AND *WILL* CONTINUE WITH THE REST
        // 1. create soft assert Object
        // NOTE: IF IT NOT CRITICAL THEN USE SOFT ASSERT BUT IF IT'LL EFFECT THE REST USE HARD ASSERTION

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(true);
        softAssert.assertTrue(false, "===FAIL==="); // ASSERTION ERROR

        System.out.println("Hello World");
        softAssert.assertAll(); //
    }

}
