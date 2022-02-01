package tests.day015;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.security.Key;

public class C01_screenShot extends TestBase {


    @Test
    public void netellaTest1() throws InterruptedException, IOException {

        //amazon ana sayfaya gidelim
        driver.get("https://www.amazon.com");

        // nutella için arama yapalım

        WebElement aramakutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramakutusu.sendKeys("nutella"+ Keys.ENTER);

        //sonucların nutella içerdigini test edelim
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        String sonucYazisiStr=sonucYazisi.getText();

        Assert.assertTrue(sonucYazisiStr.contains("nutella"));



        //testin calıştıgını ispatı için tüm sayfanın screenShot'ını alalım

        // tüm sayfanın screenshot'ını almak için 4 adımımız var
        //1. adım TakeScreenShot objesi oluşturalım

        TakesScreenshot tss=(TakesScreenshot) driver;

        //2. olarak kayıt edecegimiz dosyayı oluştralım
        File tumSayfa=new File("target/ScreenShot/tumsayfa.jpg");

        //3. adım bir dosya daha oluşturup screen shot objesi ile screenshot'ı alalım
        File geciciResim=tss.getScreenshotAs(OutputType.FILE);


        //4. adım olarak gecici resmi kayıt etmek istedigimiz asıl dosyaya copy yapalım
        FileUtils.copyFile(geciciResim,tumSayfa);










    }


}
