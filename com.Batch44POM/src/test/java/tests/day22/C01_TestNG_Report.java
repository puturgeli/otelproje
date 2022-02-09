package tests.day22;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class C01_TestNG_Report extends TestBaseRapor {


    @Test
    public void windowHandleReusable() throws IOException {

        extentTest =extentReports.createTest("Window handle","title ile ikinci sayfaya gecildi");

        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        extentTest.info("herokuapp sayfasına gidildi");
        String ilkSayfaWindowHandle=Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        extentTest.info("New Window linkine tıklandı");
        ReusableMethods.switchToWindow("New Window");

        extentTest.info("resuable metod kullanarak yeni sayfaya gecildi");


        String expectedTitle="New Window";

        String actualTitle=Driver.getDriver().getTitle();

        System.out.println("actualTitle"+ actualTitle);
        ReusableMethods.getScreenshot("windowsSwitch");


        Assert.assertEquals(actualTitle,expectedTitle);

        extentTest.info("title nın aynı oldununu dogruladı.");



    }

}
