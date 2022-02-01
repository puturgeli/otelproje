package tests.day015;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.IOException;

public class C03_ScreenShotKlasoru extends TestBase {
    //amazona gidelim
    //3 farklı test metodu ile java, nutella ve elma aratıp
    //sonuc sayfasını screen shot'ını kayıtedelim

    @Test
    public void nutellaTest() throws IOException {
        driver.get("https://www.amazon.com");
        WebElement aramakutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramakutusu.sendKeys("nutella"+ Keys.ENTER);

        tümSyafaScreenShootMethod();




    }
    @Test
    public void javaTest() throws IOException {
        driver.get("https://www.amazon.com");
        WebElement aramakutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramakutusu.sendKeys("java"+ Keys.ENTER);
        tümSyafaScreenShootMethod();



    }
    @Test
    public void elmaTest() throws IOException {
        driver.get("https://www.amazon.com");
        WebElement aramakutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramakutusu.sendKeys("elma"+ Keys.ENTER);
        tümSyafaScreenShootMethod();

    }

}
