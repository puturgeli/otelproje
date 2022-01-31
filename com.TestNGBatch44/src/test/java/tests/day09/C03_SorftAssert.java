package tests.day09;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SorftAssert {

    @Test
    public void test(){
        int a=10;
        int b=20;
        int c=30;

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(a,b);//failed
        softAssert.assertTrue(a>b,"2.Test Fail");//failed
        softAssert.assertTrue(a<c,"3.Test Fail");//pass
        softAssert.assertTrue(c>b,"3.Test Fail");//pass
        softAssert.assertTrue(c<a,"4.Test Fail");//failed

        //assertAll demezsek class çalışır ve pass yazar, çünkü aslında raporlama yapmaz sadece kodalar çalışmış olur
        //
        softAssert.assertAll();
        System.out.println("eger softasser'lerden fail olan varsa bu satır çalışmaz");


    }

}
