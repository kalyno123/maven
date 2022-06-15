package testng_learning;

import org.testng.annotations.Test;

public class _07C_Parallel {

    @Test(priority = 1)
    public void testC1(){
        System.out.println("This is testC1");
        System.out.println("Thread id = " + Thread.currentThread().getId());
    }

    @Test(priority = 2)
    public void testC2(){
        System.out.println("This is testC2");
        System.out.println("Thread id = " + Thread.currentThread().getId());
    }

    @Test(priority = 3)
    public void testC3(){
        System.out.println("This is testC3");
        System.out.println("Thread id = " + Thread.currentThread().getId());
    }

}
