package testng_learning;

import org.testng.annotations.Test;

public class _02_Priority_Keyword {

    // NOTE: By default, all the tests are running by alphabetical order. But this is not the proper way,
    // so we will create our own way to put tests in order with 'priority' keyword.
    // PRIORITY KEYWORD IS USED TO PROVIDE COSTUME ORDERING OF THE TEST EXECUTION. EX: IF A TEST NEEDS TO RUN BEFORE ANOTHER DUE TO DEPENDENCIES.
    // syntax: @Test(priority = #) --> the # can be negative, zero, positive values (minimum value will run first; if same # then it'll run alphabetically)
    // NOTE: 'PRIORITY' KEYWORD CAN ONLY BE USED WITH @TEST ANNOTATIONS (each class @Test max = 10)

    @Test(priority = 1)
    public void login(){
        System.out.println("this is login");
    }

    @Test(priority = 2)
    public void test(){
        System.out.println("this is test");
    }

    @Test(priority = 3)
    public void logout(){
        System.out.println("this is logout");
    }





}
