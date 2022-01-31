package tests.day014;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;

public class C04_screenShot extends TestBase {

    @Test
    public void screenShot(){

        driver.get("https://www.google.com");

        //Tüm sayfanın screen shot'ını almak için;

        TakesScreenshot tss=(TakesScreenshot) driver ;

        //screenShot almak için ;
        //1. adım : obje oluşturup driver'ımızı buna atayalım
        //          deger olarak driver'ı kabul etmesi için casting yapmamız gerekir

        //tüm sayfanın screenshot'ını almak için bir file oluşturalım ve dosya yolunu belirtelim

        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\Projeler";

        File tümSayfaSS=new File(dosyaYolu.concat("\\tumSayfa.png"));


        //3. adım : oluşturdugumuz file ile takeSS objesini ilişkilendirelim.

        tümSayfaSS=tss.getScreenshotAs(OutputType.FILE);


        //eger spesifik bir webelementinin screenShot'ını almak istiyorsanız

        WebElement logoResmi=driver.findElement(By.xpath("//img[@id='hplogo']"));

        File logoElement=new File(dosyaYolu.concat("\\logo.png"));
        logoElement=logoResmi.getScreenshotAs(OutputType.FILE);






    }


}
