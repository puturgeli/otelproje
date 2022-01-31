package tests.day011;


import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_TestBaseIlkTest extends TestBase {



    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
    }


}
