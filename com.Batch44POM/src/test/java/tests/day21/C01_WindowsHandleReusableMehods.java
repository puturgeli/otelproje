package tests.day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.Set;

public class C01_WindowsHandleReusableMehods {

    @Test
    public void test01(){
        // https://demoqa.com/browser-windows adresine gidelim
        Driver.getDriver().get("https://demoqa.com/browser-windows");

        String ilkSayfaWindowHandle=Driver.getDriver().getWindowHandle();
    // new tab butonuna basalım

    Driver.getDriver().findElement(By.xpath("(//button[@type=\"button\"])[2]")).click();

        // new tab'a gecip title'nın "new Tab" oldugunu test edelim
        Set<String> handles=Driver.getDriver().getWindowHandles();
        String ikinciSayfahandle = "";
        for (String each :handles ) {
            if (!each.equals(ilkSayfaWindowHandle)){
                ikinciSayfahandle=each;
            }

            Driver.getDriver().switchTo().window(ikinciSayfahandle);

            String expectedTitle="This is a sample page";
      String actualTitle =Driver.getDriver().findElement(By.tagName("h1")).getText();
            Assert.assertEquals(actualTitle,expectedTitle);

        }




    }
    @Test
    public void Test02(){
        // https://the-internet.herokuapp.com/windows adresine gidelim
        // new tab butonuna basalim
        // new tab'a gecip title'inin "New Window" oldugunu test edin
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWindowHandle=Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        Set<String> handleSeti=Driver.getDriver().getWindowHandles();
        String ikinciSayfaHandle="";
        for (String each : handleSeti
        ) {
            if (!each.equals(ilkSayfaWindowHandle)){
                ikinciSayfaHandle=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaHandle);
        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();
        System.out.println("actualTitle"+ actualTitle);
        Assert.assertEquals(actualTitle,expectedTitle);


    }

    @Test
    public void windowHandleReusable() throws IOException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWindowHandle=Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        ReusableMethods.switchToWindow("New Window");

        String expectedTitle="New Window";

        String actualTitle=Driver.getDriver().getTitle();

        System.out.println("actualTitle"+ actualTitle);
        ReusableMethods.getScreenshot("windowsSwitch");

        Assert.assertEquals(actualTitle,expectedTitle);





    }




}
