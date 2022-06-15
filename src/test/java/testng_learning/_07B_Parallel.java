package testng_learning;

import org.testng.annotations.Test;

public class _07B_Parallel {

    @Test(priority = 1)
    public void testB1(){
        System.out.println("This is testB1");
        System.out.println("Thread id = " + Thread.currentThread().getId());
    }

    @Test(priority = 2)
    public void testB2(){
        System.out.println("This is testB2");
        System.out.println("Thread id = " + Thread.currentThread().getId());
    }

    @Test(priority = 3)
    public void testB3(){
        System.out.println("This is testB3");
        System.out.println("Thread id = " + Thread.currentThread().getId());
    }
}
