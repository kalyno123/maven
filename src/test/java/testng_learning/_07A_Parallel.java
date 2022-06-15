package testng_learning;

import org.testng.annotations.Test;

public class _07A_Parallel {

    @Test(priority = 1)
    public void testA1(){
        System.out.println("This is testA1");
        System.out.println("Thread id = " + Thread.currentThread().getId());
    }

    @Test(priority = 2)
    public void testA2(){
        System.out.println("This is testA2");
        System.out.println("Thread id = " + Thread.currentThread().getId());
    }

    @Test(priority = 3)
    public void testA3(){
        System.out.println("This is testA3");
        System.out.println("Thread id = " + Thread.currentThread().getId());
    }

}
