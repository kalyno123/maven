package scripts;

import org.testng.annotations.Test;

public class _15_GroupsTest {

    @Test(priority = 6, groups = "Functional")
    public void test6(){
        System.out.println("This is test6");
    }

}
