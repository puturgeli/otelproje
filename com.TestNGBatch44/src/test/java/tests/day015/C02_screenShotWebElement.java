package tests.day015;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_screenShotWebElement extends TestBase {



    @Test
    public void nutellaTest() throws IOException {

        //amazon sayfasına gidelim
        driver.get("https://www.amazon.com");

        //nutella aratalım
        WebElement aramakutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramakutusu.sendKeys("nutella"+ Keys.ENTER);

        //nutella aradıgını test edin
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        String sonucYazisiStr=sonucYazisi.getText();

        Assert.assertTrue(sonucYazisiStr.contains("nutella"));
        //arama textinin screenshotını alın

        //1. adım screenShot cekecegimiz web elementi locate edelim
        //2. adım kayıt edecegimiz bir dosya oluşturalım
        File webelementSs=new File("target/ScreenShot/webElement.jpg");

        //3. adım: gecici resmi kayıt yapacagımız asıl dosyay kopyalayalım
             File geciciResim=sonucYazisi.getScreenshotAs(OutputType.FILE);

             //4. adım
        FileUtils.copyFile(geciciResim,webelementSs);



    }

}
