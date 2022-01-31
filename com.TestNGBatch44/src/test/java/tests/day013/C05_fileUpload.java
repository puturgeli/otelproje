package tests.day013;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_fileUpload extends TestBase {


    @Test
    public void fileUpload(){

        //Tests packagenin altina bir class oluşturun : C05_UploadFile
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim

        // 1. File Secme butonunu locate edelim
        WebElement fileSecButonu= driver.findElement(By.xpath("//input[@id='file-upload']"));
        // 2. adım dinamik olarak secicegimiz dosyanın adı lazım
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\Projeler\\1.GIF";

        // 3.sendkeys ile dinamik oluşturdugumuz dosya yolunu dosya sec butnınuna yollayalım

        fileSecButonu.sendKeys(dosyaYolu);


        //Yuklemek istediginiz dosyayi secelim.

        //Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim

        WebElement sonucYazisi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(sonucYazisi.isDisplayed());






    }




}
